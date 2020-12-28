package com.mapeamento.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_PESSOA", schema = "DB")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SQ_PS_ID", sequenceName = "SQ_PS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PS_ID")
	@Column(name = "PS_ID")
	private Long id;
	
	@Column(name = "PS_NOME")
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "pessoa")
	private List<Telefone> contatos;
	
}
