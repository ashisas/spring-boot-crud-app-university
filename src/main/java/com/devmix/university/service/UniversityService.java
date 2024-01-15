package com.devmix.university.service;

import com.devmix.university.dto.UniversityDTO;

import java.util.List;

public interface UniversityService {

    public UniversityDTO saveUniversity(UniversityDTO universityDTO);
    public List<UniversityDTO> allUniversity();
    public UniversityDTO updateUniversity(UniversityDTO universityDTO);
    boolean deleteUniversityById(String universityId);
}
