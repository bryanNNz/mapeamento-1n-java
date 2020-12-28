package com.mapeamento.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_TELEFONE", schema = "DB")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SQ_TF_ID", sequenceName = "SQ_TF_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TF_ID")
	@Column(name = "TF_ID")
	private Long id;
		
	@Column(name = "TF_NUMERO")
	private String numero;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TF_TIPO")
	private TipoTelefoneEnum tipoTelefone;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "PS_ID", referencedColumnName = "PS_ID")
	private Pessoa pessoa;
}
