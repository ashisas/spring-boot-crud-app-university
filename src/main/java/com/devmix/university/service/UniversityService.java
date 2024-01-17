package com.devmix.university.service;

import com.devmix.university.dto.UniversityDTO;

import java.util.List;

public interface UniversityService {

    public UniversityDTO saveUniversity(UniversityDTO universityDTO);
    public List<UniversityDTO> allUniversity();
    public UniversityDTO updateUniversity(UniversityDTO universityDTO);
    boolean deleteUniversityById(String universityId);

    UniversityDTO findBYNameAndId(String universityId,String universityName);
    UniversityDTO findBYNameAndIdJPQL(String universityId,String universityName);
    UniversityDTO findBYNameAndIdNative(String universityId,String universityName);
    List<UniversityDTO> findAllByState(List<String> state);
    List<UniversityDTO> findAllByStateNamed(List<String> state);
    List<UniversityDTO> findAllByStateNamedNative(List<String> state);
}
