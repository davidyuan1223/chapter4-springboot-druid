package cn.f33v.chapter4springbootjdbctemplate;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/03/23 16:15
 * @Created by Administrator
 */
public interface UserService {
    int addUser(String name,Integer age);
    List<Map<String, Object>> listAll();
    int deleteById(int id);
    List<User> getByName(String name);
    int deleteAllUsers();
}
