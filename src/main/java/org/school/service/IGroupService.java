package org.school.service;

import org.school.model.entity.Group;

import java.util.List;

public interface IGroupService {
    void AddGroup(Group group)throws Exception;
    void RemoveGroup(Group group)throws Exception;
    void UpdateGroup(Group group)throws Exception;

    List<Group> ListAll()throws Exception;
}
