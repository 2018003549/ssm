package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface SpecialSqlMapper {
    /**
     * 批量删除目前方法一
     * @param ids
     */
    void deleteMore(@Param("ids")String ids);

    /**
     * 动态设置表名，查询相应表的数据
     * @param table_name
     * @return
     */
    List<User> getList(@Param("table_name") String table_name);

    void insert(User user);
}
