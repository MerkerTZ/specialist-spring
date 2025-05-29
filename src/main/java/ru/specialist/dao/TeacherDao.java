package ru.specialist.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TeacherDao extends CrudRepository<Teacher, Integer> {

    @Query(value = "select * from teachers t where t.name like concat('%', :name, '%')", nativeQuery = true)
    Iterable<Teacher> findTeacherByName(@Param("name") String name);

}
