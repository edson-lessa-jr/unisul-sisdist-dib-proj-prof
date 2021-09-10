package br.unisul.proj.prof.projprof.dto;

import br.unisul.proj.prof.projprof.model.Especialidade;
import br.unisul.proj.prof.projprof.model.Professor;

import java.util.Arrays;

public class DadosBasicoProfessorDTO {
    private Long id;
    private String nome;

    public DadosBasicoProfessorDTO() {
    }

    public DadosBasicoProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
