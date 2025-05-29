package ru.specialist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.specialist.dao.*;


public class App {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class)) {


//            CourseDao courseDao = context.getBean(CourseDao.class);
//
//            Course git = new Course();
//            git.setTitle("GIT");
//            git.setLength(16);
//            git.setDescription("GIT course for junior Developers");
////            dao.save(git);
//
////            System.out.println(dao.findOne(2));
//
////            dao.findOne(2).setLength(1);
//
////            Course s = dao.findOne(2);
////            s.setLength(5);
////            dao.delete(s);
////            dao.save(s);
//
//            courseDao.changeCourseLength(40, 45);
//            System.out.println("");
//
//            courseDao.findAll().forEach(d -> System.out.println(d.toString()));
//
//            System.out.println("\n\n\n");
//
//            System.out.println(courseDao.findByTitle("Web"));


            TeacherDao teacherDao = context.getBean(TeacherDao.class);

            teacherDao.findAll().forEach(d -> System.out.println(d.toString()));

            System.out.println(teacherDao.findTeacherByName("Иван"));
            System.out.println(teacherDao.findTeacherByName("Иван"));

//            dao.findAll().forEach(d -> {System.out.println(d.toString());});
//            System.out.println(dao.findById(2));
//            dao.findByTitle("Web").forEach(str->System.out.println(str));
        }
    }
}