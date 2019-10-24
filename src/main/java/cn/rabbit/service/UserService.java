package cn.rabbit.service;

import cn.rabbit.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void add() {
        userDAO.add();
        int i = 1/ 0;
        userDAO.add();

    }
}
