package br.unisul.proj.prof.projprof.dto;

import br.unisul.proj.prof.projprof.model.Especialidade;
import br.unisul.proj.prof.projprof.model.Professor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfessorDTO {
    private String nome;
    private String dataNascimento;
    private List<String> especialidade=new ArrayList<>();

    public ProfessorDTO() {
    }

    public ProfessorDTO(String nome, String dataNascimento, String[] especialidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.especialidade.addAll(Arrays.asList(especialidade));
    }

    public ProfessorDTO(Professor professor) {
        this.nome = professor.getNome();
        this.dataNascimento = professor.getDataNascimentoFormada();
        for (int i = 0; i < professor.getEspecialidade().size(); i++) {
            Especialidade especialidade = professor.getEspecialidade().get(i);
            this.especialidade.add(especialidade.name());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<String> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<String> especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "ProfessorDTO: \n" +
                "nome=" + nome + ",\n" +
                "dataNascimento=" + dataNascimento + ",\n" +
                "especialidade=" + especialidade;
    }

    public Professor converteParaProfessor() {
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setDataNascimento(this.dataNascimento);
        for (int i = 0; i < this.especialidade.size(); i++) {
            professor.adicionarEspecialidade(Especialidade.valueOf(this.especialidade.get(i)));
        }
        return professor;
    }
}
