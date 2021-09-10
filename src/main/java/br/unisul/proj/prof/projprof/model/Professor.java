package br.unisul.proj.prof.projprof.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PROFESSOR")
public class Professor {
    private static final DateTimeFormatter FORMATAR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ElementCollection
    @CollectionTable(name = "TB_ESPECIALIDADES_PROFESSOR",
    joinColumns = @JoinColumn(name = "professor_id"),
    uniqueConstraints =
        @UniqueConstraint(columnNames = {"professor_id","especialidade_nome"}))
    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade_nome")
    private List<Especialidade> especialidade=new ArrayList<>();


    public Professor() {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoFormada(){
        return this.dataNascimento.format(FORMATAR_DATA);
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setDataNascimento(String dataNascimentoSTR) {
        this.dataNascimento= LocalDate.parse(dataNascimentoSTR, FORMATAR_DATA);
    }

    public List<Especialidade> getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List<Especialidade> especialidade) {
        this.especialidade = especialidade;
    }

    public void adicionarEspecialidade(Especialidade especialidade) {
        this.especialidade.add(especialidade);
    }
}
