package org.school.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.school.model.entity.Group;
import org.school.model.entity.GroupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupDao {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Group QueryGroup(String groupID) {
        String queryString = "FROM Group WHERE groupID=:id";
        return (Group) getSession()
                .createQuery(queryString)
                .setString("id", groupID)
                .uniqueResult();
    }

    public void AddGroup(Group group) {
        getSession().save(group);
    }

    public void RemoveGroup(Group group) {
        getSession().delete(group);
    }

    public void UpdateGroup(Group group) {
        getSession().update(group);
    }

    public List<Group> ListAll() {
        String queryString = "FROM Group";
        return getSession()
                .createQuery(queryString)
                .list();
    }


}
