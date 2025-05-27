package ru.specialist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import ru.specialist.graph.Scene;

@ImportResource("annotateConfiguration.xml")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GraphConfig.class);

//        context.getBean("myPoint", Point.class).draw();
//        context.getBean("myCircle", Circle.class).draw();
        context.getBean(Scene.class).draw();
    }
}