package br.com.ifpe.oxefood.modelo.venda;



import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  //ele torna a classe em uma entidade manipulada pela JPA
@Table(name = "Venda") // a partir dessa classe ele vai virar uma tabela no banco
@SQLRestriction("habilitado = true") // ela vai acresentar um glasula (exlusão logica)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda  extends EntidadeAuditavel {

    @Column 
   private String cliente;

   @Column
   private String produto;

   @Column
   private String statusVenda ;

   @Column
   private LocalDate dataVenda;

   @Column 

   private Double valorTotal;

   @Column
   private String observacao;

   @Column
   private Boolean retiradaEmLoja;




}
