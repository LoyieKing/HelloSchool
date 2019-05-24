package org.school.model;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "College", schema = "dbo", catalog = "myschool")
public class CollegeModel {
    private String collegeId;
    private String collegeName;
    private UserModel user;
    private List<DepartmentModel> departments;
    private String userId;

    @Id
    @Column(name = "collegeID")
    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    @Basic
    @Column(name = "collegeName")
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollegeModel that = (CollegeModel) o;

        return collegeId.equals(that.collegeId);
    }

    @Override
    public int hashCode() {
        int result = collegeId != null ? collegeId.hashCode() : 0;
        result = 31 * result + (collegeName != null ? collegeName.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "userID")
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "college")
    public List<DepartmentModel> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentModel> departments) {
        this.departments = departments;
    }

}
