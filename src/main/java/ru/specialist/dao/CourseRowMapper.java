package ru.specialist.dao;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CourseRowMapper implements RowMapper {
    @Override
    public @Nullable Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Course(rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("length"),
                rs.getString("description"));
    }
}
