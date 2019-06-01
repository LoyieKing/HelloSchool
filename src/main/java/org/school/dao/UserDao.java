package org.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.school.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public UserModel QueryUser(String userinfo) {
        String queryString =
                "FROM UserModel " +
                "WHERE userId=:info " +
                "OR phone=:info " +
                "OR email=:info ";
        return (UserModel) getSession()
                .createQuery(queryString)
                .setString("info", userinfo)
                .uniqueResult();
    }

    public void UpdateUser(UserModel user)
    {
        getSession().update(user);
    }

    public void AddUser(UserModel user)
    {
        getSession().save(user);
    }
}
