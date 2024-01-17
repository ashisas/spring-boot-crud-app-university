package com.devmix.university.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "UNIVERSITY")
@NamedQuery(name = "UniversityEntity.findAllByStateInNamed",query = "select u from UniversityEntity u where u.state in(?1)")
@NamedNativeQuery(name = "UniversityEntity.findAllByStateInNative",query = "select * from UNIVERSITY where state in(?1) ",resultClass = UniversityEntity.class)
public class UniversityEntity implements Serializable {

    @Id
    @Column(name = "UNIVERSITY_ID",length = 10)
    private String universityId;
    private String universityName;
    @Column(name = "CREATION_DATE")
    private LocalDate establishmentDate;
    @Column(name = "UNIVERSITY_ADDRESS" , length = 1000)
    private String address;
    private String updatedBy;
    private String createdBy;
    private LocalDate updatedOn;
    private String state;
    private Boolean activeStatus;


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

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
