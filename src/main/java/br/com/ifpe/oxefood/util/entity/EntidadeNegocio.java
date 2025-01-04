package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@MappedSuperclass
public abstract class EntidadeNegocio implements Serializable {

    public static final String ROLE_CLIENTE = "CLIENTE";
    public static final String ROLE_FUNCIONARIO_ADMIN = "ROLE_FUNCIONARIO_ADMIN"; // READ, DELETE, WRITE, UPDATE.
    public static final String ROLE_FUNCIONARIO_USER = "ROLE_FUNCIONARIO_USER"; // READ, WRITE, UPDATE.
 

    @Id // para definir que esse campo é a chave primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // inplementar o novo id no banco
    private Long id;

    @JsonIgnore
    @Column
    private Boolean habilitado;

}
