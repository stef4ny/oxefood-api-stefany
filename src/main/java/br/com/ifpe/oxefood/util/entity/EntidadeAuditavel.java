package br.com.ifpe.oxefood.util.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass // esta mapeada mas não ira se criar uma tabela para ela
@EntityListeners(AuditingEntityListener.class)

public abstract class EntidadeAuditavel extends EntidadeNegocio {
    @JsonIgnore // não será enivada para a consultas, nunca vão ser retornados 
    @Version // vai poder ver quantas versão foram realizadas

    private Long versao;
    @JsonIgnore
    @CreatedDate

    private LocalDate dataCriacao;
    @JsonIgnore
    @LastModifiedDate // são anotações de auditoria 

    private LocalDate dataUltimaModificacao;
    @JsonIgnore
    @Column

    private Long criadoPor; // Id do usuário que o criou
    @JsonIgnore
    @Column

    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}
