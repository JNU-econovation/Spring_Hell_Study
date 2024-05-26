package com.econovation.fourth_project.structure.repository;

import com.econovation.fourth_project.structure.domain.Structure;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StructureRepository {
    private Map<Long, Structure> structureRepository = new HashMap<>();

    public void save(Long id,Structure structure){
        structureRepository.put(id,structure);
    }

    public Structure findById(Long id){
        return structureRepository.get(id);
    }

    public List<Structure> getAllStructure(){
        return new ArrayList<>(structureRepository.values());
    }
}
