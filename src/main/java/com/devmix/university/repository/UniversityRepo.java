package com.devmix.university.repository;

import com.devmix.university.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepo extends JpaRepository<UniversityEntity,String> {

    UniversityEntity findByUniversityIdAndUniversityName(String universityId,String universityName);

    List<UniversityEntity> findAllByStateIn(List<String> state);


    @Query(value = "select u from UniversityEntity u where universityId = ?1 and universityName = ?2 ")
    UniversityEntity findByUniversityIdAndUniversityNameUsingJPQL(String universityId,String universityName);

    @Query(value = "select * from University  where university_Id = ?1 and university_Name = ?2 " ,nativeQuery = true)
    UniversityEntity findByUniversityIdAndUniversityNameUsingNative(String universityId,String universityName);
    List<UniversityEntity> findAllByStateInNamed(List<String> states);
    List<UniversityEntity> findAllByStateInNative(List<String> states);


}
