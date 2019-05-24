package org.school.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GroupUserModelPK implements Serializable {
    private String groupId;
    private String userId;

    @Column(name = "groupID")
    @Id
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "userID")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupUserModelPK that = (GroupUserModelPK) o;

        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
