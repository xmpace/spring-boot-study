package cn.reasonwhy.spring.service;

import cn.reasonwhy.spring.domain.User;
import cn.reasonwhy.spring.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    private UserMapper userMapper;

    public HelloService() {
        System.out.println("helloService");
    }

    public String hello() {
        User user = userMapper.selectByName("肖密");
        User updateDO = new User();
        updateDO.setId(user.getId());
        updateDO.setName("野马");
        userMapper.updateSelective(updateDO);
        return updateDO.getName();
    }
}
