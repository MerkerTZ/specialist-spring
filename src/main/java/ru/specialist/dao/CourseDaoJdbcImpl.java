package ru.specialist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository("courseDao")
public class CourseDaoJdbcImpl implements CourseDao {

    public static final String SQL_SELECT_COURSE = "SELECT id, title, length, description from courses";
    public static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";
    public static final String SQL_SELECT_COURSE_BY_TITLE = SQL_SELECT_COURSE + " WHERE title like ?";
    private static final String SQL_DELETE_COURSE_BY_ID =
            "DELETE FROM courses WHERE id = ?";
    private static final String SQL_INSERT_COURSE =
            "INSERT INTO courses (title, length, description) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_COURSE =
            "UPDATE courses SET title = ?, length = ?, description = ? WHERE id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CourseRowMapper courseRowMapper;

    @Override
    public Course findById(int id) {
        return (Course) jdbcTemplate.queryForObject(SQL_SELECT_COURSE_BY_ID, new BeanPropertyRowMapper(Course.class), id);
    }

    @Override
    public List<Course> findAll() {
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_SELECT_COURSE);
//        CourseRowMapper crm = new CourseRowMapper();
//        crm.mapRow(getJdbcTemplate().queryForList(SQL_SELECT_COURSE));

//        Стандартный RowMapper работает если переменные сущности совпадают с таблице БД
//        return jdbcTemplate.query(SQL_SELECT_COURSE, new BeanPropertyRowMapper(Course.class));
        return jdbcTemplate.query(SQL_SELECT_COURSE, courseRowMapper);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_COURSE_BY_TITLE, courseRowMapper, new Object[]{"%" + title + "%"});
    }

    @Override
    public void insert(Course course) {
        jdbcTemplate.update(
                SQL_INSERT_COURSE,
                course.getTitle(),
                course.getLength(),
                course.getDescription());
    }

    @Override
    public void update(Course course) {
        jdbcTemplate.update(
                SQL_UPDATE_COURSE,
                course.getTitle(),
                course.getLength(),
                course.getDescription(),
                course.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE_COURSE_BY_ID, id);
    }

}
