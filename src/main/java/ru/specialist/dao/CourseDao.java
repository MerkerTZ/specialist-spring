package ru.specialist.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CourseDao extends CrudRepository<Course, Integer> {

    Iterable<Course> findByLength(int length);

    @Query("select c from Course c where c.length <= :mLength")
    Iterable<Course> findShortCourses(@Param("mLength") int maxLength);

    @Query(value = "select * from courses c where c.title like  concat('%',:title,'%')", nativeQuery = true)
    Iterable<Course> findByTitle(@Param("title") String title);

    @Modifying
    @Query(value = "update Course c set c.length = :nLength where c.length = :oLength")
    int changeCourseLength(@Param("oLength") int oldLength, @Param("nLength") int newLength);

}
