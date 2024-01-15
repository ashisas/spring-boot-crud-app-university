package com.devmix.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "UNIVERSITY")
public class UniversityEntity implements Serializable {

    @Id
    @Column(name = "UNIVERSITY_ID",length = 10)
    private String universityId;
    private String universityName;
    //private LocalDate establishmentDate;
    @Column(name = "UNIVERSITY_ADDRESS" , length = 1000)
    private String address;
    private String updatedBy;
    private String createdBy;
    //private LocalDate updatedDate;


    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
