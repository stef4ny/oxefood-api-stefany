package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/entregador")
@CrossOrigin

@Tag(
    name = "API Cliente",
    description = "API responsável pelos servidos de entregador no sistema"
)
public class EntregadorController {
  
   @Autowired
   private EntregadorService EntregadorService;


     @Operation(
       summary = "Serviço responsável por salvar um entregador no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um entregador no sistema."
   )


   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

       Entregador entregador = EntregadorService.save(request.build()); 
       return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
   }
     @GetMapping
    public List<Entregador> listarTodos() {
        return EntregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador obterPorID(@PathVariable Long id) {
        return EntregadorService.obterPorID(id);
    }
    
    @PutMapping("/{id}")
 public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

       EntregadorService.update(id, request.build());
       return ResponseEntity.ok().build();
 }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       EntregadorService.delete(id);
       return ResponseEntity.ok().build();
   }

}
