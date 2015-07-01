package mi.khtp.spring3mvcxml;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mattong
 */
@Component
public class PersonsService {

    private static Logger log = Logger.getLogger(PersonsService.class);
    private static final String NAME = PersonsService.class.getCanonicalName();

    @Autowired
    private PersonDAO personDao;

    private List<Person> persons = new ArrayList<>();

    @Transactional(readOnly = true)
    public String getStatus() {
        return NAME + ":OK\n";
    }

    @Transactional(readOnly = false)
    public String init() {
        log.info("Listing currentList...");
        personDao.init();
        return "OK";
    }

    @Transactional(readOnly = true)
    public Person[] currentList() {
        log.info("Listing currentList...");
        List<Person> list = personDao.listAll();
        int size = list.size();
        Person[] persons = new Person[size];
        int idx = 0;
        for (Person person : list) {
            persons[idx] = person;
            idx++;
        }
        return persons;
    }

    @Transactional(readOnly = true)
    public Person getPerson(int id) {
        if (id < persons.size()) {
            return persons.get(id);
        }
        return null;
    }

}
