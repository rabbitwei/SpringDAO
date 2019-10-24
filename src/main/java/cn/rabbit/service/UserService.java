package cn.rabbit.service;

import cn.rabbit.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    //想要控制哪个方法事务，在其前面添加@Transactional这个注解就行了
    //如果想要控制整个类的事务，那么在类上面添加就行了。
    @Transactional
    public void add() {
        userDAO.add();
        int i = 1/ 0;
        userDAO.add();

    }
}
