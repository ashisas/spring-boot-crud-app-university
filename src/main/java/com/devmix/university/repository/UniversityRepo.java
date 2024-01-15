package com.devmix.university.repository;

import com.devmix.university.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<UniversityEntity,String> {
}
