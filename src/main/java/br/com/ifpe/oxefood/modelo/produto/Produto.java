package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
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

@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {

    @ManyToOne
    private CategoriaProduto categoria;

    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false)
    private String titulo;

    @Column  (nullable = false)
    private String descricao;

    @Column  (nullable = false)
    private Double valorUnitario;

    @Column
    private int tempoEntregaMinimo;

    @Column
    private int tempoentregaMaximo;

}
