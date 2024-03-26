package com.dlut.service;

import com.dlut.pojo.User;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/10.
 */
public interface IUserService {

    public User checkUser(User user);

    public int register(User user);

    public int update(User user);

    public User selectById(int userId);

}
