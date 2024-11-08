package br.com.ifpe.oxefood.modelo.produto;

import br.com.ifpe.oxefood.api.produto.ProdutoRequest.ProdutoRequestBuilder;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  
@Table(name = "Produto")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {
    
    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column 
    private Double valorUnitario;

    @Column 
    private int tempoEntregaMinimo;

    @Column 
    private int tempoentregaMaximo;

    public static ProdutoRequestBuilder builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }

   

}
