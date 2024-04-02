package com.example.Exercicio04.Controllers;

import com.example.Exercicio04.Exercicio04Application;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonMessageController {

    @GetMapping("/jogadorJson")
    public Map<String, Object> jogadorJson() {
        Map<String, Object> jogador = new HashMap<>();
        jogador.put("nome", Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_nomes));
        jogador.put("sobrenome", Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_sobrenomes));
        jogador.put("clube", Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_clubes));
        jogador.put("posicao", Exercicio04Application.retorna_indice_aleatorio(Exercicio04Application.lista_posicoes));
        jogador.put("idade", Exercicio04Application.retorna_numero_aleatorio(17,40));

        return jogador;
    }
}
