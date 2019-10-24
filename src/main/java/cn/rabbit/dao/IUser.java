package cn.rabbit.dao;

import cn.rabbit.pojo.User;

import java.util.List;

public interface IUser {
    void add();
    List<User> query(String id);
}
