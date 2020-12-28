package com.mapeamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mapeamento.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	
	@Query("SELECT t FROM Telefone t WHERE t.pessoa.id = :idPessoa")
	List<Telefone> findTelefoneByPessoa(@Param("idPessoa") long idPessoa);
}
