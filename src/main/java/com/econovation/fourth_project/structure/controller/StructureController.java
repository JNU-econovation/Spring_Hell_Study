package com.econovation.fourth_project.structure.controller;

import com.econovation.fourth_project.structure.domain.Structure;
import com.econovation.fourth_project.structure.dto.ReqStructureDto;
import com.econovation.fourth_project.structure.service.StructureService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class StructureController {

    private final StructureService structureService;

    @PostMapping("/api/structure")
    public String createStructure(@RequestBody ReqStructureDto request){
        structureService.createStructure(request.getStructure());
        return "create structure success";
    }

    @GetMapping("/api/structure")
    public List<Structure> getAllStructure(){
        return structureService.getAllStructure();
    }

}
