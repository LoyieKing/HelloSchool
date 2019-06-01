package org.school.model;

import javax.persistence.*;

@Entity
@Table(name = "Department", schema = "myschool", catalog = "")
public class DepartmentModel {
    private String departmentId;
    private String departmentName;
    private CollegeModel college;

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

        DepartmentModel that = (DepartmentModel) o;

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
    public CollegeModel getCollege() {
        return college;
    }

    public void setCollege(CollegeModel college) {
        this.college = college;
    }

}
