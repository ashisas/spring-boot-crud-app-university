package com.devmix.university.service.impl;

import com.devmix.university.dto.UniversityDTO;
import com.devmix.university.entity.UniversityEntity;
import com.devmix.university.repository.UniversityRepo;
import com.devmix.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepo universityRepo;

    @Override
    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setUniversityId(universityDTO.getUniversityId());
        universityEntity.setUniversityName(universityDTO.getUniversityName());
        universityEntity.setAddress(universityDTO.getAddress());
        universityEntity.setCreatedBy(universityDTO.getCreatedBy());
        UniversityEntity  universityRes = universityRepo.save(universityEntity);
        UniversityDTO universityDTOResponse = new UniversityDTO();
        universityDTOResponse.setCreatedBy(universityRes.getCreatedBy());
        universityDTOResponse.setUniversityId(universityRes.getUniversityId());
        universityDTOResponse.setAddress(universityRes.getAddress());
        universityDTOResponse.setUniversityName(universityRes.getUniversityName());
        return universityDTOResponse;
    }

    @Override
    public List<UniversityDTO> allUniversity() {
        List<UniversityDTO> dtos= new ArrayList<>();
        List<UniversityEntity> universityEntityList = universityRepo.findAll();
        universityEntityList.forEach(u->{
            UniversityDTO universityDTOResponse = new UniversityDTO();
            universityDTOResponse.setCreatedBy(u.getCreatedBy());
            universityDTOResponse.setUniversityId(u.getUniversityId());
            universityDTOResponse.setAddress(u.getAddress());
            universityDTOResponse.setUniversityName(u.getUniversityName());
            dtos.add(universityDTOResponse);
        });

        return dtos;
    }

    @Override
    public UniversityDTO updateUniversity(UniversityDTO universityDTO) {
        UniversityDTO universityDTOResponse = new UniversityDTO();
        //check in db
        Optional<UniversityEntity> universityEntity  = universityRepo.findById(universityDTO.getUniversityId());
        if(universityEntity.isPresent()) {
            universityEntity.get().setAddress(universityDTO.getAddress());
            universityEntity.get().setUpdatedBy("CURRENT_USER");
            UniversityEntity updatedUniversityData =  universityRepo.save(universityEntity.get());
            universityDTOResponse.setCreatedBy(updatedUniversityData.getCreatedBy());
            universityDTOResponse.setUniversityId(updatedUniversityData.getUniversityId());
            universityDTOResponse.setAddress(updatedUniversityData.getAddress());
            universityDTOResponse.setUniversityName(updatedUniversityData.getUniversityName());
            universityDTOResponse.setUpdatedBy(updatedUniversityData.getUpdatedBy());
        }

        return universityDTOResponse;
    }

    @Override
    public boolean deleteUniversityById(String universityId) {

        //check the DB record is exist or not
        Optional<UniversityEntity> universityEntity = universityRepo.findById(universityId);
        if(universityEntity.isPresent()) {
            universityRepo.deleteById(universityId);
            return true;
        }
        return false;
    }
}
