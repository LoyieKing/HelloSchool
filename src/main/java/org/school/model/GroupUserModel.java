package org.school.model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;


@Entity
@Table(name = "GroupUser", schema = "myschool", catalog = "")
public class GroupUserModel {

    @EmbeddedId
    private GroupUserModelPK groupUserModelPK;
    private short priority;

    public GroupUserModelPK getGroupUserModelPK() {
        return groupUserModelPK;
    }

    public void setGroupUserModelPK(GroupUserModelPK groupUserModelPK) {
        this.groupUserModelPK = groupUserModelPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupUserModel that = (GroupUserModel) o;
        return groupUserModelPK.equals(that.groupUserModelPK);
    }

    @Override
    public int hashCode() {
        return groupUserModelPK.hashCode();
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
