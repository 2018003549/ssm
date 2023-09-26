package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Emp;

import java.util.List;

public interface CacheMapper {
    List<Emp> getEmpByCondition(@Param("id") int id);

}
