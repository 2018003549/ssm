package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 修改用户
     * @return
     */
    int updateUser();

    /**
     * 删除用户
     * @return
     */
    void deleteUser();

    /**
     * 查询单个用户
     * @return
     */
    User selectUserByid();

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();
}
