package mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    User getUserByID(@Param("id") Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAlluser();

    /**
     * 查询用户的总数量
     * @return
     */
    Integer selectCount();

    Map<String,Object> getUserByidtomap(@Param("id") Integer id);
    @MapKey("id")
    Map<String,Object> getAllusertomap();


    List<User> getUserLike(@Param("condition")String condition);
}
