package org.school.service;

import org.school.model.UserModel;


public interface IUserService {

    UserModel Login(String userinfo, String password)throws Exception;
    UserModel Register(UserModel user)throws Exception;
    UserModel UpdateUser(UserModel user)throws Exception;
}
