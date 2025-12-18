package projetofinaleda;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class _Main {
    private static final String TEXTO = "lusiadas.txt";
    private static final String TRIE_SALVA = "dicionario_lusiadas.trie";

    public static void main(String[] args) {
        Trie trie = carregarOuConstruir();

        System.out.println("\nTECLE COM ERROS À VONTADE (sair → termina)\n");
        trie.imprimirTudo();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("→ ");
            String entrada = sc.nextLine().trim();
            if (entrada.equalsIgnoreCase("sair")) break;
            if (entrada.isEmpty()) continue;

            List<String> sugest = PreditorInteligente.obterSugestoes(entrada, trie, 10);
            System.out.println("Sugestões: " + sugest + "\n");
        }
        sc.close();
    }

    private static Trie carregarOuConstruir() {
        File f = new File(TRIE_SALVA);
        if (f.exists()) {
            System.out.println("Carregando dicionário rápido...");
            Trie trie = ListaPalavras.carregarTrie(TRIE_SALVA);
            if (trie != null) return trie;
        }

        System.out.println("Construindo dicionário d'Os Lusíadas...");
        Trie trie = new Trie();
        ListaPalavras.carregarDeFicheiro(TEXTO, trie);
        ListaPalavras.guardarTrie(trie, TRIE_SALVA);
        return trie;
    }
}