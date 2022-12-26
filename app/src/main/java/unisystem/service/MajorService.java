package unisystem.service;

import unisystem.domain.Major;

import java.util.List;

public interface MajorService {
    List<Major> getMajors();
    void listAllMajors();
    void listAllFieldsOfStudy();
    void listAllDegrees();
    void listAllFaculties();
}
