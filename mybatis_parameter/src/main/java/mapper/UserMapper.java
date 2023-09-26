package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User selectByID(String username);
    /**
     *验证登录
     */
    User checkLogin(String username,String password);

    /**
     * 通过自定义集合的键访问
     * @param map
     * @return
     */
    User checkByMap(Map map);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 验证登录，使用@param注解
     * @return
     */
    User selectByParam(@Param(value = "username") String username, @Param("password")String password);
}
