package com.dlut.service.impl;

import com.dlut.dao.UserMapper;
import com.dlut.pojo.User;
import com.dlut.pojo.UserExample;
import com.dlut.pojo.UserKey;
import com.dlut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zhonghua on 2016/7/10.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(User user) {
        //Example不能定义成属性，否则就成为了缓存，下次查询依然还保持上次的结果
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andUserPasswordEqualTo(user.getUserPassword());

        List<User> users=userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return null;
        }else if(users.size()==1){
            return users.get(0);
        }
        return null;
    }

    @Override
    public int register(User user) {
        //默认权限
        user.setUserAuthority(0);
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectById(int userId) {
        UserKey key = new UserKey();
        key.setUserId(userId);
        return userMapper.selectByPrimaryKey(key);
    }


}
