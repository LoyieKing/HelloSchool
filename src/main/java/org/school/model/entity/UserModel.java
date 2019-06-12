package org.school.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User", schema = "myschool", catalog = "")
public class UserModel {
    private String userId;
    private UserType userType;
    private String schoolNumber;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private List<Event> events;
    private List<GroupUser> groupUsers;

    @Id
    @Column(name = "userID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name="userTypeId")
    public UserType getUserType(){return userType;}

    public void setUserType(UserType userType){this.userType = userType;}

    @Basic
    @Column(name = "schoolNumber")
    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String emali) { this.email = emali; }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        return userId.equals(userModel.userId);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (schoolNumber != null ? schoolNumber.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "hosts")
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    @OneToMany(mappedBy = "groupUserPK.user")
    public List<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<GroupUser> groups) {
        this.groupUsers = groups;
    }
}
