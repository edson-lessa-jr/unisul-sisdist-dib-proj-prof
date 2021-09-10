package br.unisul.proj.prof.projprof.controller;

import br.unisul.proj.prof.projprof.dto.DadosBasicoProfessorDTO;
import br.unisul.proj.prof.projprof.dto.ProfessorDTO;
import br.unisul.proj.prof.projprof.model.Professor;
import br.unisul.proj.prof.projprof.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/{id}")
    public ProfessorDTO localicarProfessor(@PathVariable(name = "id") Long id){
        ProfessorDTO dto = new ProfessorDTO(professorRepository.getById(id));
        return dto;
    }

    @GetMapping("/nome/{nome}")
    public DadosBasicoProfessorDTO localizarPorNome(@PathVariable(name = "nome")String nome){
        DadosBasicoProfessorDTO dto =
                new DadosBasicoProfessorDTO(professorRepository.findFirstByNome(nome));
        return dto;
    }

    @GetMapping("/")
    public List<ProfessorDTO> listarProfessor(){
        List<ProfessorDTO> dtoList = new ArrayList<>();
        List<Professor> professorList = professorRepository.findAll();
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
        professorRepository.save(professor);
    }
}
