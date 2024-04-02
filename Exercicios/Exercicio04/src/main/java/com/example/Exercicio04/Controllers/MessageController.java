package com.example.Exercicio04.Controllers;

import com.example.Exercicio04.Exercicio04Application;

@RestController
public class MessageController {

    @GetMapping("/mensagem")
    public String mensagem() {
        String nome = Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_nomes);
        String sobrenome = Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_sobrenomes);
        String clube = Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_clubes);
        String posicao = Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_posicoes);
        int idade = Exercicio04Application.retorna_numero_aleatorio(17,40);

        return nome +" "+ sobrenome + " de " + idade + " anos joga na posição de " + posicao +" no time " + clube;
    }
}
