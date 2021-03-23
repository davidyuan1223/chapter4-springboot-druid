package cn.f33v.chapter4springbootjdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/03/23 16:19
 * @Created by Administrator
 */
@Service
public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(String name,Integer age) {
        return jdbcTemplate.update("insert into user(name, age) values(?,?)",name,age);
    }

    @Override
    public List<Map<String, Object>> listAll() {
        return jdbcTemplate.queryForList("select * from user");
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from user where id=?",id);
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users = jdbcTemplate.query("select NAME, AGE from USER where NAME = ?", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        }, name);
        return users;
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from user");
    }
}
