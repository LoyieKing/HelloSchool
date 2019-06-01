package org.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Group", schema = "myschool", catalog = "")
public class GroupModel {
    private String groupId;
    private String groupName;
    private String groupDescription;
    private List<GroupUserModel> groupUsers;

    @Id
    @Column(name = "groupID")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "groupDescription")
    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupModel that = (GroupModel) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupDescription != null ? !groupDescription.equals(that.groupDescription) : that.groupDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupDescription != null ? groupDescription.hashCode() : 0);
        return result;
    }


    @OneToMany(mappedBy = "groupUserModelPK.group")
    public List<GroupUserModel> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<GroupUserModel> users) {
        this.groupUsers = users;
    }

}
