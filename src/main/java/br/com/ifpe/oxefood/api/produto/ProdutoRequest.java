package br.com.ifpe.oxefood.api.produto;


import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String codigo;

    private String titulo;

    private String descricao;

    private Double valorUnitario;

    private int tempoEntregaMinimo;

    private int tempoentregaMaximo;

    public Produto build() {

       return Produto.builder()
           .titulo(titulo)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .tempoEntregaMinimo(tempoEntregaMinimo)
           .tempoentregaMaximo(tempoentregaMaximo)
           .build();
   }

}
