package br.com.ifpe.oxefood.modelo.funcionario;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoFuncionario {
 // o enum serve para limita o acesso ao usuário
    ADMINISTRADOR(
            "Administrador"),
    OPERADOR(
            "Operador");

    private String tipo;

    private TipoFuncionario(String tipo) {
        this.tipo = tipo;
    }

    @JsonValue
    public String getTipo() {
        return tipo;
    }

}