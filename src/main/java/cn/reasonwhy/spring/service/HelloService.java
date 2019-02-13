package cn.reasonwhy.spring.service;

import cn.reasonwhy.spring.domain.User;
import cn.reasonwhy.spring.drds.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    private UserMapper userMapperDrds;

    @Resource
    private cn.reasonwhy.spring.rds.mapper.UserMapper userMapperRds;

    public String helloRds() {
        return String.valueOf(userMapperRds.selectByName("野马"));
    }

    public String helloDrds() {
        return String.valueOf(userMapperDrds.selectByName("野马"));
    }
}
