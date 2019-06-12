package org.school.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserType", schema = "myschool", catalog = "")
public class UserType {
    private short userTypeId;
    private String userTypeName;
    private Boolean isAdmin;
    private Boolean canEditClass;
    private Boolean canEditCourse;

    public static final UserType VISITOR;
    public static final UserType STUDENT;

    static {
        VISITOR = new UserType();
        VISITOR.userTypeId = 0;
        VISITOR.userTypeName = "游客";
        VISITOR.isAdmin = false;
        VISITOR.canEditClass = false;
        VISITOR.canEditCourse = false;

        STUDENT = new UserType();
        STUDENT.userTypeId = 1;
        STUDENT.userTypeName = "学生";
        STUDENT.isAdmin = false;
        STUDENT.canEditClass = false;
        STUDENT.canEditCourse = false;
    }

    @Id
    @Column(name = "userTypeID")
    public short getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(short userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "userTypeName")
    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Basic
    @Column(name = "isAdmin")
    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Basic
    @Column(name = "canEditClass")
    public Boolean getCanEditClass() {
        return canEditClass;
    }

    public void setCanEditClass(Boolean canEditClass) {
        this.canEditClass = canEditClass;
    }

    @Basic
    @Column(name = "canEditCourse")
    public Boolean getCanEditCourse() {
        return canEditCourse;
    }

    public void setCanEditCourse(Boolean canEditCourse) {
        this.canEditCourse = canEditCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserType that = (UserType) o;

        if (userTypeId != that.userTypeId) return false;
        if (userTypeName != null ? !userTypeName.equals(that.userTypeName) : that.userTypeName != null) return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;
        if (canEditClass != null ? !canEditClass.equals(that.canEditClass) : that.canEditClass != null) return false;
        return canEditCourse != null ? canEditCourse.equals(that.canEditCourse) : that.canEditCourse == null;

    }

    @Override
    public int hashCode() {
        int result = (int) userTypeId;
        result = 31 * result + (userTypeName != null ? userTypeName.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        result = 31 * result + (canEditClass != null ? canEditClass.hashCode() : 0);
        result = 31 * result + (canEditCourse != null ? canEditCourse.hashCode() : 0);
        return result;
    }
}
