package org.school.service;

import org.school.model.entity.UserModel;
import org.school.model.result.Event;

import java.util.List;


public interface IUserService {

    UserModel Login(String userinfo, String password)throws Exception;
    UserModel Register(UserModel user)throws Exception;
    UserModel UpdateUser(UserModel user)throws Exception;
    List<Event> GetClassTable(UserModel user);
    List<UserModel> ListAll()throws Exception;

}
