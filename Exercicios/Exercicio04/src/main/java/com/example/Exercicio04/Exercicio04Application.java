package com.example.Exercicio04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@SpringBootApplication
public class Exercicio04Application {

    public static String lista_nomes;
    public static String lista_sobrenomes;
    public static String lista_clubes;
    public static String lista_posicoes;

    public static void main(String[] args) throws Exception {
        lista_nomes = retorna_lista_uri("https://venson.net.br/resources/data/nomes.txt");
        lista_sobrenomes = retorna_lista_uri("https://venson.net.br/resources/data/sobrenomes.txt");
        lista_clubes = retorna_lista_uri("https://venson.net.br/resources/data/clubes.txt");
        lista_posicoes = retorna_lista_uri("https://venson.net.br/resources/data/posicoes.txt");

        SpringApplication.run(Exercicio04Application.class, args);
    }

    public static int retorna_numero_aleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static String retorna_lista_uri(String minhaUri) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String lista = response.body();
        return lista;
    }

    public static String retorna_indice_aleatorio(String stringao) {
        // Quebrando o texto em várias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um número aleatório entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }
}
