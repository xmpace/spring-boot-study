package cn.reasonwhy.spring.rds.mapper;

import cn.reasonwhy.spring.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT id FROM user WHERE name = #{name}")
    User selectByName(@Param("name") String name);
}
