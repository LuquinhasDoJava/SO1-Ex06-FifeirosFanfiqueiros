package controller;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public interface IFifaController {
    Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException;

    void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException;

    List<String> listaRevelacoes(String caminho, String nome) throws IOException;

    void buscaListaBonsJovens(List<String> lista) throws IOException;

}
