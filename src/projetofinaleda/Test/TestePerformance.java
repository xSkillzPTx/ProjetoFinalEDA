package projetofinaleda.Test;


import java.util.List;
import projetofinaleda.Array.PredictiveEngine;
import projetofinaleda.Trie.ListaPalavras;
import projetofinaleda.Trie.PreditorInteligente;
import projetofinaleda.Trie.Trie;

public class TestePerformance {
    
    private  PredictiveEngine engine;  // ArrayList
    private  Trie trie;
    
    
    public List<String> prefixos = List.of(
            "xil", "z", "kaf", "ypê", "quix", "jur", "lac"
            
        );
    
    public TestePerformance() {
        
        inicializarTrie();
        inicializarEngine();
           
    }
    private void inicializarEngine() {
        engine = new PredictiveEngine();
        engine.carregaFicheiro("Textos.txt");
    }
    
   private void inicializarTrie() {
        final String TRIE_SALVA = "dicionario_textos.trie";
        
        trie = ListaPalavras.carregarTrie(TRIE_SALVA);
        if (trie == null) {
            trie = new Trie();
            ListaPalavras.carregarDeFicheiro("Textos.txt", trie);
            ListaPalavras.guardarTrie(trie, TRIE_SALVA);
            System.out.println("✅ Trie criada e salva em " + TRIE_SALVA);
        } else {
            System.out.println("✅ Trie carregada de " + TRIE_SALVA);
        }
    }
    
   
    
    public long testarTrie(int repeticoes, List<String> prefixos) {
        long tempoTotal = 0;
        
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            for (String prefixo : prefixos) {
                PreditorInteligente.obterSugestoes(prefixo, trie, 5);
            }
            tempoTotal += System.nanoTime() - inicio;
        }
        
        double mediaNs = (double) tempoTotal / (repeticoes * prefixos.size());
        System.out.printf("TRIE  - Total: %d ns | Média: %.1f ns/busca%n", 
                         tempoTotal, mediaNs);
        return tempoTotal;
            }

    public long testarArray(int repeticoes, List<String> prefixos) {
        long tempoTotal = 0;
        
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            for (String prefixo : prefixos) {
                engine.getSuggetions(prefixo);
            }
            tempoTotal += System.nanoTime() - inicio;
        }
        
        double mediaNs = (double) tempoTotal / (repeticoes * prefixos.size());
        System.out.printf("ARRAY - Total: %d ns | Média: %.1f ns/busca%n", 
                         tempoTotal, mediaNs);
        return tempoTotal;
    }
    
    
}