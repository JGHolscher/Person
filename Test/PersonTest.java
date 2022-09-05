
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {
    Person p1, p2, p3;


    @BeforeEach
    void setUp() {
        Person.startSeed(0);
        p1 = new Person("Sarah", "Smith", "Ms.", 1998);
        p2 = new Person("Donovan", "Scoglietti", "Mr.", 1999);
        p3 = new Person("Rhonda", "Holscher", "Mrs.", 1969);

    }



    @Test
    void getID() {
        assertEquals(0, Person.startSeed());

    }

    @Test
    void setfName() {
        p1.setfName("Sarah");
        assertEquals("Sarah", p1.getfName());
        p2.setfName("Donovan");
        assertEquals("Donovan", p2.getfName());
        p3.setfName("Rhonda");
        assertEquals("Rhonda", p3.getfName());
    }


    @Test
    void setlName() {
        p1.setlName("Smith");
        assertEquals("Smith", p1.getlName());
        p2.setlName("Scoglietti");
        assertEquals("Scoglietti", p2.getlName());
        p3.setlName("Holscher");
        assertEquals("Holscher", p3.getlName());
    }


    @Test
    void setTitle() {
        p1.setTitle("Ms.");
        assertEquals("Ms.", p1.getTitle());
        p2.setTitle("Mr.");
        assertEquals("Mr.", p2.getTitle());
        p3.setTitle("Mrs.");
        assertEquals("Mrs.", p3.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1998);
        assertEquals(1998, p1.getYOB());
        p2.setYOB(1999);
        assertEquals(1999, p2.getYOB());
        p3.setYOB(1969);
        assertEquals(1969, p3.getYOB());
    }
    @Test
    void fullName() {
        p1.fullName();
        assertEquals("Sarah" + " " + "Smith", p1.fullName());
        p2.fullName();
        assertEquals("Donovan" + " " + "Scoglietti", p2.fullName());
        p3.fullName();
        assertEquals("Rhonda" + " " + "Holscher", p3.fullName());
    }

    @Test
    void formalName() {
        p1.formalName();
        assertEquals("Ms." + "Sarah" + " " + "Smith", p1.formalName());
        p2.formalName();
        assertEquals("Mr." + "Donovan" + " " + "Scoglietti", p2.formalName());
        p3.formalName();
        assertEquals("Mrs." + "Rhonda" + " " + "Holscher", p3.formalName());
    }

    @Test
    void getAge() {
        p1.getAge(Calendar.getInstance().get(Calendar.YEAR));
        assertEquals((Calendar.getInstance().get(Calendar.YEAR) - p1.YOB), p1.getAge());
        p2.getAge(Calendar.getInstance().get(Calendar.YEAR));
        assertEquals((Calendar.getInstance().get(Calendar.YEAR) - p2.YOB), p2.getAge());
        p3.getAge(Calendar.getInstance().get(Calendar.YEAR));
        assertEquals((Calendar.getInstance().get(Calendar.YEAR) - p3.YOB), p3.getAge());
    }



    @Test
    void testGetAge() {
        p1.getAge(2018);
        assertEquals(2018 - p1.YOB, p1.getAge(2018));
        p2.getAge(2017);
        assertEquals(2017 - p2.YOB, p2.getAge(2017));
        p3.getAge(2004);
        assertEquals(2004 - p3.YOB, p3.getAge(2004));
    }
}


