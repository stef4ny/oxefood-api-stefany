package br.com.ifpe.oxefood.api.funcionario;

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

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
//import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood.modelo.funcionario.FuncionarioService;
import br.com.ifpe.oxefood.modelo.funcionario.TipoFuncionario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin

@Tag(
    name = "API Cliente",
    description = "API responsável pelos servidos de funcionário no sistema"
)



public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


      @Operation(
       summary = "Serviço responsável por salvar um funcionário no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um funcionário no sistema."
   )


    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioRequest request) {

        Funcionario funcionarioNovo = request.build();

           if (funcionarioNovo.getTipo().equals(TipoFuncionario.ADMINISTRADOR)) {
                funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_ADMIN));
           } else if (funcionarioNovo.getTipo().equals(TipoFuncionario.OPERADOR)) {
                funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_USER));
           }

        Funcionario funcionario = funcionarioService.save(funcionarioNovo);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {

        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario obterPorID(@PathVariable Long id) {

        return funcionarioService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable("id") Long id, @RequestBody FuncionarioRequest request) {

        funcionarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

}
