package ru.specialist.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("CourseDao")
public class CourseDaoHibernateImpl implements CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public Object findById(int id) {
        return getSessionFactory().getCurrentSession().byId(Course.class).load(id);
    }

    @Override
    public List<Course> findAll() {
        return getSessionFactory().getCurrentSession().createSelectionQuery("from Course c", Course.class).list();
    }

    @Override
    public List<Course> findByTitle(String title) {
        return getSessionFactory()
                .getCurrentSession()
                .createSelectionQuery("from Course c where c.title like :title", Course.class)
                .setParameter("title", "%" + title + "%")
                .list();

    }

    @Override
    public void insert(Course course) {
        getSessionFactory().getCurrentSession().persist(course);
    }

    @Override
    public void update(Course course) {
        getSessionFactory().getCurrentSession().merge(course);
    }

    @Override
    public void delete(int id) {
        Course course = new Course();
        course.setId(id);
        getSessionFactory().getCurrentSession().remove(course);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
