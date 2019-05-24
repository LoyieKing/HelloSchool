package org.school.model;

import javax.persistence.*;


@Entity
@Table(name = "GroupUser", schema = "dbo", catalog = "myschool")
@IdClass(GroupUserModelPK.class)
public class GroupUserModel {
    private GroupModel group;
    private UserModel user;
    private short priority;

    @Id
    @ManyToOne
    @JoinColumn(name = "groupID")
    public GroupModel getGroup() {
        return group;
    }

    public void setGroup(GroupModel group) {
        this.group = group;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "userID")
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupUserModel that = (GroupUserModel) o;
        return group.equals(that.group) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return group.hashCode()*31+user.hashCode();
    }

    @Basic
    @Column(name = "priority")
    public short getPriority() {
        return priority;
    }

    public void setPriority(short priority) {
        this.priority = priority;
    }

}
