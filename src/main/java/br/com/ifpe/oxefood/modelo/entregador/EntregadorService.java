package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.produto.Produto;
//import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
  
  @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       entregador.setHabilitado(Boolean.TRUE);
       return repository.save(entregador);
   }

   public List<Entregador> listarTodos() {
  
        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, Entregador entregadorAlterado) {

      Entregador entregador = repository.findById(id).get();
      entregador.setNome(entregadorAlterado.getNome());
      entregador.setCpf(entregadorAlterado.getCpf());
      entregador.setRg(entregadorAlterado.getRg());
      entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
      entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
      entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
	  entregador.setQtEntregadorRealizadas(entregadorAlterado.getQtEntregadorRealizadas());
      entregador.setValorFrete(entregadorAlterado.getValorFrete());
      entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
      entregador.setEnderecoCompletomento(entregadorAlterado.getEnderecoCompletomento());
      entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
      entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
      entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
      entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
      entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
      entregador.setAtivo(entregadorAlterado.getAtivo());

      repository.save(entregador);
  }

   @Transactional // o transactional faz um collback, o transactional ou ele faz tudo ou faz nada mas isso ele só confirma no final.
  public void delete(Long id) {

       Entregador entregador = repository.findById(id).get();
      entregador.setHabilitado(Boolean.FALSE);

      repository.save(entregador); // se fosse fazer uma exclusão fisica usaria o delete, mas como não usar o save
  }


}
