package cn.rabbit.dao;

import cn.rabbit.pojo.MyResult;
import cn.rabbit.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDAO implements IUser {

    //使用Spring的自动装配
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add() {
        String sql = "insert into user_(name) values('user@3')";
        jdbcTemplate.update(sql);
    }

    /*
    如果我们使用queryForMap()，那么只能封装一行的数据，如果封装多行的数据、
    那么就会报错！并且，Spring是不知道我们想把一行数据封装成是什么样的，
    因此返回值是Map集合…我们得到Map集合的话还需要我们自己去转换成自己需要的类型。
     */
    @Override
    public List<User>  query(String id) {
        String sql = "select * from user_ where id = ?";

        //一般使用 query 方法， 这里我们重写了 RowMapper 接口，
        // 我们可以将每行记录封装成一个JavaBean对象的，
        // 因此直接实现RowMapper，在使用的时候创建就好了。
        /*
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            //实现RowMapper，告诉Spriing我们将每行记录封装成怎么样的。
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user  = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        }, id);
        */


        //实现 RowMapper， 将每行记录封装成一个bean对象
        List<User> list = jdbcTemplate.query(sql, new MyResult(), id);
        return list;
    }
}
