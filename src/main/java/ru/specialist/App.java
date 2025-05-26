package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.specialist.person.Person;

public class App {

    public static void main (String[] args){
        System.out.println("before context create");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("after context create");

        Person person = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);
        person.setAge(25);
        System.out.println(person.hashCode() + "\n" + person2.hashCode());
        person.getInfoAboutGuest(person);
        person.getInfoAboutGuest(person2);

    }
}