package br.unisul.proj.prof.projprof.controller;

import br.unisul.proj.prof.projprof.dto.ProfessorDTO;
import br.unisul.proj.prof.projprof.model.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfessorController {
    private List<Professor> professorList = new ArrayList<>();

    @GetMapping("/{id}")
    public ProfessorDTO localicarProfessor(@PathVariable(name = "id") Integer id){
        ProfessorDTO dto = new ProfessorDTO(professorList.get(id));
        return dto;
    }

    @GetMapping("/")
    public List<ProfessorDTO> listarProfessor(){
        List<ProfessorDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < professorList.size(); i++) {
            Professor professor = professorList.get(i);
            ProfessorDTO dto = new ProfessorDTO(professor);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @PostMapping("/")
    public void incluirProfessor(@RequestBody ProfessorDTO dto){
        Professor professor = dto.converteParaProfessor();
        professorList.add(professor);

    }
}
