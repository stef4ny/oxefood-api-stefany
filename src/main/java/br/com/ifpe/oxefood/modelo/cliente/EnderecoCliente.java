package br.com.ifpe.oxefood.modelo.cliente;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  //ele torna a classe em uma entidade manipulada pela JPA
@Table(name = "Cliente") // a partir dessa classe ele vai virar uma tabela no banco
@SQLRestriction("habilitado = true") // ela vai acresentar um glasula (exlusão logica)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente extends EntidadeAuditavel {
   @JsonIgnore //exibir os dados da tabela cliente se não colocado
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;

   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;
  


}
