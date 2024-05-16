package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

    @Override
    public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
        Stack<String> pilha = new Stack<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho + "\\" + nome));
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.contains(",Brazil,")) {
                    pilha.push(linha);
                }
            }
        } catch (IOException e) {

        }
        return pilha;
    }

    @Override
    public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
        while (!pilha.isEmpty()) {
            String jogador = pilha.pop();
            String[] dados = jogador.split(",");
            int overall = Integer.parseInt(dados[7]);
            if (overall > 80) {
                System.out.println(dados[2] + " - Overall: " + dados[7]);
            }
        }
    }
    @Override
    public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
        List<String> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho + "\\" + nome));
            String linha;
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Ignorar o cabeçalho
                }
                String[] dados = linha.split(",");
                int idade;
                try {
                    idade = Integer.parseInt(dados[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter idade: " + dados[3]);
                    continue;
                }
                if (idade <= 20) {
                    lista.add(linha);
                }
            }
        } catch (IOException e) {
        }
        return lista;
    }


    @Override
    public void buscaListaBonsJovens(List<String> lista) throws IOException {
        for (int i = lista.size() - 1; i >= 0; i--) {
            String jogador = lista.get(i);
            String[] dados = jogador.split(",");
            int overall = Integer.parseInt(dados[7]);
            if (overall >= 80) {
                System.out.println(dados[2] + " - Idade: " + dados[3] + ", Overall: " + dados[7]);
            }
        }
    }
}