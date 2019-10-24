package cn.rabbit.pojo;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyResult implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        //通过字段名来访问 resultSet
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        return user;
    }

}
