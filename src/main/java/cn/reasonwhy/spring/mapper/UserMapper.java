package cn.reasonwhy.spring.mapper;

import cn.reasonwhy.spring.domain.User;
import cn.reasonwhy.spring.mybatis.SqlProviderAdapter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserMapper {
    @Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(@Param("name") String name);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "updateByPrimaryKeySelective")
    int updateSelective(User user);
}
