package org.example;

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        jogador1.gera_jogador();
        jogador2.gera_jogador();

        jogador1.print_jogador();
        jogador2.print_jogador();
    }
}