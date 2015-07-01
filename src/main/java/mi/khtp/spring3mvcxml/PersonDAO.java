package mi.khtp.spring3mvcxml;

import java.util.LinkedList;
import java.util.List;
import mi.common.utils.AppSettings;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mattong
 */
@Component
public class PersonDAO {

    private static final Logger log = Logger.getLogger(PersonDAO.class.getName());

    @Autowired
    private SessionFactory sf;
    private boolean isInit = false;

    public PersonDAO() {
    }

    public void init() {
        Session session = sf.getCurrentSession();
        if (isInit == false) {
            log.info("Initializing a list of people...");
            List<Person> persons = new LinkedList<>();
            int personCount = AppSettings.SINGLETON.getInt("person.count", 100);
            for (int i = 0; i < personCount; i++) {
                persons.add(new Person("Name" + i));
            }
            for (Person person : persons) {
                session.save(person);
            }
            isInit = true;
            log.info("Initialized a list of people in DB.");
        }
    }

    public Person insert(Person person) {
        log.info("Person inserted:" + person);
        Session session = sf.getCurrentSession();
        session.save(person);
        return person;
    }

    public Person update(Person person) {
        log.info("Person updated:" + person);
        Session session = sf.getCurrentSession();
        session.update(person);
        return person;
    }

    @SuppressWarnings("unchecked")
    public List<Person> listAll() {
        log.info("Returning from listAll().");
        Session session = sf.getCurrentSession();
        return session.createCriteria(Person.class).list();
    }
}
