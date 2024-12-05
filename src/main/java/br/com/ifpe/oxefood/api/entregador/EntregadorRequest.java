package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
  
  @NotNull(message = "O Nome é de preenchimento obrigatório")
   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
  private String nome;

  @NotBlank(message = "O CPF é de preenchimento obrigatório")
   @CPF
  private String cpf;

  private String rg;

   @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dataNascimento;

  @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
  @NotBlank()
  private String foneCelular;

  private  String foneFixo;

  private int qtEntregadorRealizadas;

  private double valorFrete;

  private String enderecoRua; 

  private String enderecoCompletomento;

  private String enderecoNumero;

  private String enderecoBairro;

  private String enderecoCidade;

  private String enderecoCep;

  private String enderecoUf;

  private Boolean ativo; 

  public Entregador build() {

       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .rg(rg)
           .dataNascimento(dataNascimento)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtEntregadorRealizadas(qtEntregadorRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoCompletomento(enderecoCompletomento)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCidade(enderecoCidade)
           .enderecoCep(enderecoCep)
           .enderecoUf(enderecoUf)
           .ativo(ativo)
           .build();
   }
  
}
