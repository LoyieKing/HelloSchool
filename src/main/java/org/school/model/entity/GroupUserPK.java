package org.school.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class GroupUserPK implements Serializable {


    @ManyToOne()
    @JoinColumn(name="groupID")
    private Group group;


    @ManyToOne
    @JoinColumn(name="userID")
    private UserModel user;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

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

        GroupUserPK that = (GroupUserPK) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
