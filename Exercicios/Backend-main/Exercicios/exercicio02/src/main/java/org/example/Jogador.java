package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Jogador {
    private String nome = "Jogador";
    private String sobrenome = "Padrão";
    private String posicao = "atacante";
    private String clube = "Clube";
    private int idade = 18;

    private String uri_nomes = "https://venson.net.br/resources/data/nomes.txt";
    private String uri_sobrenomes = "https://venson.net.br/resources/data/sobrenomes.txt";
    private String uri_posicoes = "https://venson.net.br/resources/data/posicoes.txt";
    private String uri_clubes = "https://venson.net.br/resources/data/clubes.txt";

    public void set_nome(String nome) {
        this.nome = capitalizacao(nome);
    }

    public void set_sobrenome(String sobrenome) {
        this.sobrenome = capitalizacao(sobrenome);
    }

    public void set_posicao(String posicao) {
        this.posicao = posicao;
    }

    public void set_clube(String clube) {
        this.clube = clube;
    }

    public void set_idade(int idade) {
        this.idade = idade;
    }

    public String capitalizacao(String palavra) {
        palavra = palavra.toLowerCase();
        palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
        return palavra;
    }

    public void gera_jogador() {
        try {
            String lista_nomes = retorna_lista_uri(this.uri_nomes);
            this.nome = retorna_indice_aleatorio(lista_nomes);
            this.nome = capitalizacao(this.nome);

            String lista_sobrenomes = retorna_lista_uri(this.uri_sobrenomes);
            this.sobrenome = retorna_indice_aleatorio(lista_sobrenomes);
            this.sobrenome = capitalizacao(this.sobrenome);

            String lista_de_posicoes = retorna_lista_uri(this.uri_posicoes);
            this.posicao = retorna_indice_aleatorio(lista_de_posicoes);
            this.posicao = this.posicao.replace("\"", "");
            this.posicao = this.posicao.replace(",", "");
            this.posicao = this.posicao.toLowerCase();

            String lista_de_clubes = retorna_lista_uri(this.uri_clubes);
            this.clube = retorna_indice_aleatorio(lista_de_clubes);
            this.clube = capitalizacao(this.clube);
        } catch (Exception e) {
            // Lidar com a exceção aqui
            e.printStackTrace();
        }

        this.idade = retorna_numero_aleatorio(17, 40);
    }

    public static String retorna_lista_uri(String minhaURI) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaURI)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }

    public static String retorna_indice_aleatorio(String stringao) {
        // Quebrando o texto em várias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");
        // gera um número aleatório entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public static int retorna_numero_aleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public String get_nome() {
        return this.nome;
    }

    public String get_sobrenome() {
        return this.sobrenome;
    }

    public String get_posicao() {
        return this.posicao;
    }

    public String get_clube() {
        return this.clube;
    }

    public int get_idade() {
        return this.idade;
    }

    public void print_jogador() {
        System.out.printf("%s %s de %d anos joga na posição de %s no time %s\n", this.nome, this.sobrenome, this.idade, this.posicao, this.clube);
    }
}
