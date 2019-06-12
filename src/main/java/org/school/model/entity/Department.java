package org.school.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Department", schema = "myschool", catalog = "")
public class Department {
    private String departmentId;
    private String departmentName;
    private College college;

    @Id
    @Column(name = "departmentID")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "departmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return departmentId.equals(that.departmentId);
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "collegeID")
    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

}
