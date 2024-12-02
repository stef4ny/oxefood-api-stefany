package br.com.ifpe.oxefood.modelo.cliente;



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
@Table(name = "Cliente") // a partir dessa classe ele vai virar uma tabela no banco
@SQLRestriction("habilitado = true") // ela vai acresentar um glasula (exlusão logica)
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {

    @Column (nullable = false, length = 100) // vai criar uma coluna para a tabela criar no @table
   private String nome;

   @Column
   private LocalDate dataNascimento;

   @Column(unique = true)
   private String cpf;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

}

