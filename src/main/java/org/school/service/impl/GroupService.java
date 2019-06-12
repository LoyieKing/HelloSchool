package org.school.service.impl;

import org.school.dao.GroupDao;
import org.school.model.entity.Group;
import org.school.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService implements IGroupService {

    @Autowired
    GroupDao groupDao;

    @Transactional
    public void AddGroup(Group group) throws Exception {
        groupDao.AddGroup(group);
    }

    @Transactional
    public void RemoveGroup(Group group) throws Exception {
        groupDao.RemoveGroup(group);
    }

    @Transactional
    public void UpdateGroup(Group group) throws Exception {
        groupDao.UpdateGroup(group);
    }

    @Transactional
    public List<Group> ListAll() throws Exception {
        return groupDao.ListAll();
    }
}
