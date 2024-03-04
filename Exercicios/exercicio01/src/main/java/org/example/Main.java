package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static String retorna_lista_uri(String minha_uri) throws Exception{
        // Puxando o arquivo de texto usando HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minha_uri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }

    public static String retorna_indice_aleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] lista_de_nomes = stringao.split("\n");
        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indice_aleatorio = (int) Math.floor(Math.random() * lista_de_nomes.length);
        return lista_de_nomes[indice_aleatorio];
    }

    public static int retorna_numero_aleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) throws Exception {
        String lista_de_nomes = retorna_lista_uri("https://venson.net.br/resources/data/nomes.txt");
        String nome = retorna_indice_aleatorio(lista_de_nomes);
        nome = nome.toLowerCase();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);

        String lista_de_sobrenomes = retorna_lista_uri("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retorna_indice_aleatorio(lista_de_sobrenomes);
        sobrenome = sobrenome.toLowerCase();
        sobrenome = sobrenome.substring(0, 1).toUpperCase() + sobrenome.substring(1);

        String lista_de_posicoes = retorna_lista_uri("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retorna_indice_aleatorio(lista_de_posicoes);
        posicao = posicao.replace("\"", "");
        posicao = posicao.replace(",", "");

        String lista_de_clubes = retorna_lista_uri("https://venson.net.br/resources/data/clubes.txt");
        String clube = retorna_indice_aleatorio(lista_de_clubes);

        int idade = retorna_numero_aleatorio(17, 40);


        System.out.println("%s %s de %d anos joga na posição de %s no time %s".formatted(nome, sobrenome, idade, posicao, clube));
        //System.out.println(nome + " " + sobrenome + " de " + idade + " anos joga na posição de " + posicao + " no time " + clube);
    }
}