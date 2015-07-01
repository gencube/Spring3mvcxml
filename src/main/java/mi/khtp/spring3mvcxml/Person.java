package mi.khtp.spring3mvcxml;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mattong
 */
@Entity
@XmlRootElement(name = "Person")
public class Person implements Serializable {

    private static int count = 1;
    private static final SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    private String pid;
    private String name;
    private String email;
    private boolean sex = false;
    private int age;
    private Date dob;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
        pid = "" + count;
        age = Integer.parseInt(count + "" + count);
        try {
            dob = dateParser.parse("20" + age + "-" + count + "-" + count);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        count++;
    }

    @XmlElement
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    @XmlElement
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    public String getPid() {
        return pid;
    }

    public Person setPid(String pid) {
        this.pid = pid;
        return this;
    }

    @XmlElement
    @Column(name = "male")
    public boolean isMale() {
        return sex;
    }

    public Person setMale(boolean sex) {
        this.sex = sex;
        return this;
    }

    @XmlElement
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public Person setAge(java.sql.Date age) {
        long time = age.getTime();
        dob = new Date(time);
        return this;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public java.sql.Date toDobSql() {
        return new java.sql.Date(dob.getTime());
    }

    @XmlElement
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public Person setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    @Override
    public String toString() {
        return "Person{'" + "pid:'" + pid + "', name:'" + name + "', sex:'" + sex + "', age:'" + age + "', dob:'" + dob + "'}";
    }

}
