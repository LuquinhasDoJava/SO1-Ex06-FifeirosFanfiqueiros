package view;

import controller.FifaController;
import controller.IFifaController;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class Principal {
    public static void main(String[] args) {
        IFifaController controller = new FifaController();
        String caminho = "C:\\TEMP";
        String nomeArquivo = "data.csv";
        try {
            // Empilhar jogadores brasileiros
            Stack<String> brasileiros = controller.empilhaBrasileiros(caminho, nomeArquivo);
            System.out.println("----- Brasileiros empilhados -----");
            Stack<String> brasileiros2 = new Stack<>();
            while(!brasileiros.isEmpty()){
                String jogador = brasileiros.pop();
                String[] dados = jogador.split(",");
                System.out.println(dados[2] + " - Idade: " + dados[3] + ", Overall: " + dados[7]);
                brasileiros2.push(jogador);
            }

            // Desempilhar bons jogadores brasileiros
            System.out.println("\n----- Bons brasileiros desempilhados -----");
            controller.desmpilhaBonsBrasileiros(brasileiros2);

            List<String> revelacoes = controller.listaRevelacoes(caminho, nomeArquivo);
            System.out.println("\n----- Revelações listadas -----");
            for (String jogador : revelacoes) {
                String[] dados = jogador.split(",");
                System.out.println(dados[2] +", Overall: " + dados[7]);
            }

            // Buscar bons jovens
            System.out.println("\n----- Bons jovens encontrados -----");
            controller.buscaListaBonsJovens(revelacoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
