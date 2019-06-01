package org.school.service.impl;

import org.school.dao.UserDao;
import org.school.exceptions.*;
import org.school.model.UserModel;
import org.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public UserModel Login(String userinfo, String password)
            throws
            NoSuchUserException,WrongPasswordException,AccountBannedException
    {
        UserModel user = userDao.QueryUser(userinfo);
        if(user==null)
            throw new NoSuchUserException();
        if(!password.equals(user.getPassword()))
            throw new WrongPasswordException();
        return user;
    }

    @Transactional
    public UserModel Register(UserModel user)
            throws UserExistsException
    {
        if(userDao.QueryUser(user.getUserId())!=null)
            throw new UserExistsException();
        userDao.AddUser(user);
        return user;
    }

    @Transactional
    public UserModel UpdateUser(UserModel user)
    {
        userDao.UpdateUser(user);
        return user;
    }

}
