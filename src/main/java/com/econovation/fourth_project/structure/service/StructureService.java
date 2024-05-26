package com.econovation.fourth_project.structure.service;

import com.econovation.fourth_project.structure.domain.Policy;
import com.econovation.fourth_project.structure.domain.Structure;
import com.econovation.fourth_project.structure.repository.StructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class StructureService {
    private final StructureRepository structureRepository;
    private static Long ID = 0L;
    public void createStructure(Structure structure){
        structureRepository.save(ID, structure);
        structure.getPolicy().setId(ID++);
    }

    public List<Structure> getAllStructure(){
        return structureRepository.getAllStructure();
    }



}
