package org.school.service.impl;

import org.school.dao.UserDao;
import org.school.exceptions.*;
import org.school.model.entity.Group;
import org.school.model.entity.GroupUser;
import org.school.model.entity.GroupUserPK;
import org.school.model.entity.UserModel;
import org.school.model.result.Event;
import org.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<Event> GetClassTable(UserModel user)
    {
        List<Group> groups = new ArrayList<Group>(5);
        for(GroupUser groupUser : user.getGroupUsers())
        {
            groups.add(groupUser.getGroupUserPK().getGroup());
        }
        List<Event> result = new ArrayList<Event>(10);
        for(Group group : groups)
        {
            for(org.school.model.entity.Event event :group.getEvents())
            {
                Event revent = new Event();
                revent.setName(event.getEventName());
                revent.setDescription(event.getEventDescription());
                revent.setGroup(group.getGroupName());
                List<String> hosts = new ArrayList<String>(event.getHosts().size());
                for(UserModel userModel : event.getHosts())
                {
                    String host;
                    if(userModel.getPhone()!=null)
                    {
                        host = userModel.getUserName()+"("+userModel.getPhone()+")";
                    }
                    else if(userModel.getEmail()!=null)
                    {
                        host = userModel.getUserName()+"("+ userModel.getEmail()+")";
                    }
                    else
                    {
                        host = userModel.getUserName();
                    }
                    hosts.add(host);
                }
                revent.setType(event.getEventType().getEventName());
                revent.setPriority(event.getEventType().getPriority());
                revent.setTime(event.getEventTime());
            }
        }
        return result;
    }

    public List<UserModel> ListAll(){
        return userDao.ListAll();
    }

}
