package org.school.service.impl;

import org.school.dao.GroupDao;
import org.school.dao.UserDao;
import org.school.model.entity.Group;
import org.school.model.entity.GroupUser;
import org.school.model.entity.GroupUserPK;
import org.school.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService implements IGroupService {

    @Autowired
    GroupDao groupDao;

    @Autowired
    UserDao userDao;


    public void AddGroup(org.school.model.result.Group group) throws Exception{
        Group rgroup = new Group();
        rgroup.setGroupName(group.getGroupName());
        rgroup.setGroupId(group.getGroupName());
        rgroup.setGroupDescription(group.getGroupDescription());

        List<GroupUser> groupUsers = new ArrayList<GroupUser>();

        for(String member:group.getMembers())
        {
            GroupUser groupUser = new GroupUser();
            GroupUserPK groupUserPK = new GroupUserPK();
            groupUserPK.setUser(userDao.QueryUser(member));
            groupUserPK.setGroup(rgroup);

            groupUser.setGroupUserPK(groupUserPK);
            groupUser.setPriority((short)0);

            groupUsers.add(groupUser);
        }

        for(String host:group.getHosts())
        {
            GroupUser groupUser = new GroupUser();
            GroupUserPK groupUserPK = new GroupUserPK();
            groupUserPK.setUser(userDao.QueryUser(host));
            groupUserPK.setGroup(rgroup);

            groupUser.setGroupUserPK(groupUserPK);
            groupUser.setPriority((short)1);

            groupUsers.add(groupUser);
        }
        rgroup.setGroupUsers(groupUsers);

        groupDao.AddGroup(rgroup);
    }

    @Transactional
    public void RemoveGroup(Group group) throws Exception {
        groupDao.RemoveGroup(group);
    }

    @Transactional
    public void UpdateGroup(org.school.model.result.Group group) throws Exception {
        Group rgroup = groupDao.QueryGroup(group.getGroupId());
        rgroup.setGroupName(group.getGroupName());
        rgroup.setGroupDescription(group.getGroupDescription());

        List<GroupUser> groupUsers = new ArrayList<GroupUser>();

        for(String member:group.getMembers())
        {
            GroupUser groupUser = new GroupUser();
            GroupUserPK groupUserPK = new GroupUserPK();
            groupUserPK.setUser(userDao.QueryUser(member));
            groupUserPK.setGroup(rgroup);

            groupUser.setGroupUserPK(groupUserPK);
            groupUser.setPriority((short)0);

            groupUsers.add(groupUser);
        }

        for(String host:group.getHosts())
        {
            GroupUser groupUser = new GroupUser();
            GroupUserPK groupUserPK = new GroupUserPK();
            groupUserPK.setUser(userDao.QueryUser(host));
            groupUserPK.setGroup(rgroup);

            groupUser.setGroupUserPK(groupUserPK);
            groupUser.setPriority((short)1);

            groupUsers.add(groupUser);
        }
        rgroup.setGroupUsers(groupUsers);

        groupDao.UpdateGroup(rgroup);
    }

    @Transactional
    public List<Group> ListAll() throws Exception {
        return groupDao.ListAll();
    }
}
