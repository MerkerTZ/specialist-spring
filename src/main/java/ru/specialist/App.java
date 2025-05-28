package ru.specialist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.specialist.dao.CourseDao;
import ru.specialist.dao.CourseDaoConfig;

public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CourseDaoConfig.class)) {


            CourseDao dao = context.getBean(CourseDao.class);
            dao.findAll().forEach(d -> {System.out.println(d.toString());});
            System.out.println(dao.findById(2));
            dao.findByTitle("Web").forEach(str->System.out.println(str));
        }
    }
}