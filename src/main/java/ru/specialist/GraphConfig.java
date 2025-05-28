package ru.specialist;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import ru.specialist.graph.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("house.properties")
@ComponentScan("ru.specialist.graph")
public class GraphConfig implements BeanNameAware {

    @Autowired
    private Environment env;

    @Bean
    @Scope("prototype")
    public Coords coords() {
        return new Coords();
    }

    @Bean
    @Scope("prototype")
    public Circle myCircle() {
        Circle c = new Circle(coords());
        c.setX(env.getProperty("circle.x", Integer.class, 0));
        c.setY(env.getProperty("circle.y", Integer.class, 0));
        c.setRadius(env.getProperty("circle.radius", Integer.class, 0));
        c.setColor(env.getProperty("circle.color", String.class, Shape.DEFAULT_COLOR));
        return c;
    }


    public Point myPoint() {
        Point p = new Point(coords());
        p.setX(env.getProperty("point.x", Integer.class, 0));
        p.setY(env.getProperty("point.y", Integer.class, 0));
        p.setColor(env.getProperty("point.color", String.class, Shape.DEFAULT_COLOR));
        return p;
    }

//    @Autowired
//    private List<Shape> objects;

    //    @Bean
//    @Scope("singleton")
//    public Scene scene() {
//        return new Scene(objects);
//    }
    @Bean(destroyMethod = "erase")
    public Scene scene() {
        List<Shape> objects = new ArrayList<Shape>();
        int countPoints = env.getProperty("scene.points", Integer.class, 1);
        int countCircles = env.getProperty("scene.circles", Integer.class, 1);
        for (int i = 0; i < countCircles; i++)
            objects.add(myCircle());
        for (int i = 0; i < countPoints; i++)
            objects.add(myPoint());
        return new Scene(objects);
    }

    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

}
