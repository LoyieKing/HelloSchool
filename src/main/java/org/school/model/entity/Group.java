package org.school.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Group", schema = "myschool", catalog = "")
public class Group {
    private String groupId;
    private String groupName;
    private String groupDescription;
    private List<GroupUser> groupUsers;

    private List<Event> events;

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

        Group that = (Group) o;

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


    @OneToMany(mappedBy = "groupUserPK.group")
    public List<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<GroupUser> users) {
        this.groupUsers = users;
    }


    @ManyToMany(mappedBy = "groups")
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
