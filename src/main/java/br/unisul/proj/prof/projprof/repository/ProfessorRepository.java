package br.unisul.proj.prof.projprof.repository;

import br.unisul.proj.prof.projprof.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findFirstByNome(String nome);
}
