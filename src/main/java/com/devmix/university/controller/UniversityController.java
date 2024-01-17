package com.devmix.university.controller;

import com.devmix.university.dto.UniversityDTO;
import com.devmix.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    /*@PostMapping("/v1/create")
    public UniversityDTO saveUniversity(@RequestBody UniversityDTO universityDTO) {
        return universityService.saveUniversity(universityDTO);
    }*/
    @PostMapping("/v1/create")
    public ResponseEntity<UniversityDTO> saveUniversity(@RequestBody UniversityDTO universityDTO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header-1","header-1val");
        return new ResponseEntity<>(universityService.saveUniversity(universityDTO),httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/v1/all")
    public ResponseEntity<List<UniversityDTO>> allUniversity() {
        return new ResponseEntity<>(universityService.allUniversity(),HttpStatus.OK);
    }

    @PutMapping("/v1/update")
    public ResponseEntity<UniversityDTO> update(@RequestBody UniversityDTO universityDTO) {
        return new ResponseEntity<>(universityService.updateUniversity(universityDTO),HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{universityId}")
    public boolean delete(@PathVariable("universityId") String universityId ) {
        return universityService.deleteUniversityById(universityId);
    }

    @GetMapping("/v1/findByNameAndId/{universityName}/{universityId}")
    public UniversityDTO findByNameAndId(@PathVariable("universityName")String universityName,@PathVariable("universityId") String universityId) {
        return universityService.findBYNameAndId(universityId,universityName);
    }
    @GetMapping("/v1/findByNameAndIdJPQL/{universityName}/{universityId}")
    public UniversityDTO findByNameAndIdJPQL(@PathVariable("universityName")String universityName,@PathVariable("universityId") String universityId) {
        return universityService.findBYNameAndIdJPQL(universityId,universityName);
    }

    @GetMapping("/v1/findByNameAndIdNative/{universityName}/{universityId}")
    public UniversityDTO findByNameAndIdNative(@PathVariable("universityName")String universityName,@PathVariable("universityId") String universityId) {
        return universityService.findBYNameAndIdNative(universityId,universityName);
    }

    @PostMapping("/v1/findAllByState/named")
    public List<UniversityDTO> findAllByStateNamed(@RequestBody List<String> states) {
        return universityService.findAllByState(states);
    }

    @PostMapping("/v1/findAllByState/namedNative")
    public List<UniversityDTO> findAllByStateNamedNative(@RequestBody List<String> states) {
        return universityService.findAllByState(states);
    }
}
