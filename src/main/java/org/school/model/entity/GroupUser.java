package org.school.model.entity;

import javax.persistence.*;


@Entity
@Table(name = "GroupUser", schema = "myschool", catalog = "")
public class GroupUser {

    @EmbeddedId
    private GroupUserPK groupUserPK;
    private short priority;

    public GroupUserPK getGroupUserPK() {
        return groupUserPK;
    }

    public void setGroupUserPK(GroupUserPK groupUserPK) {
        this.groupUserPK = groupUserPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupUser that = (GroupUser) o;
        return groupUserPK.equals(that.groupUserPK);
    }

    @Override
    public int hashCode() {
        return groupUserPK.hashCode();
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
