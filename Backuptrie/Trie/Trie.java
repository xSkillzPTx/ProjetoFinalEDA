//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Duarte Rodrigues Carvalho                                           ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::                                                                         ::
//::     e-mail: aluno27218@ipt.pt                                           ::
//::                                                                         ::
//::                                                                         ::
//::     This software was build with the purpose of learning.               ::
//::                                                                         ::
//::                                                                         ::
//::                                                                  2025   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////




/**
 *
 * @author duart
 */
package projetofinaleda.Trie;

import java.io.Serializable;
import java.util.*;

public class Trie implements Serializable {
    private final TrieNode raiz = new TrieNode();

    public void inserir(String palavra) {
        palavra = palavra.toLowerCase();
        TrieNode atual = raiz;
        for (char c : palavra.toCharArray()) {
            atual.getFilhos().putIfAbsent(c, new TrieNode());
            atual = atual.getFilhos().get(c);
        }
        atual.setFimDePalavra(true);
        atual.incrementarFrequencia();
    }

    public List<String> sugerir(String prefixo, int maximo) {
        TrieNode no = descer(prefixo.toLowerCase());
        if (no == null) return new ArrayList<>();

        List<PalavraComPeso> candidatas = new ArrayList<>();
        coletar(no, prefixo.toLowerCase(), candidatas);

        candidatas.sort(Comparator.reverseOrder());
        List<String> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(maximo, candidatas.size()); i++) {
            resultado.add(candidatas.get(i).palavra);
        }
        return resultado;
    }

    private TrieNode descer(String prefixo) {
        TrieNode atual = raiz;
        for (char c : prefixo.toCharArray()) {
            atual = atual.getFilhos().get(c);
            if (atual == null) return null;
        }
        return atual;
    }

    private void coletar(TrieNode no, String atual, List<PalavraComPeso> lista) {
        if (no.isFimDePalavra()) {
            lista.add(new PalavraComPeso(atual, no.getFrequencia()));
        }
        for (Character c : new TreeSet<>(no.getFilhos().keySet())) {
            coletar(no.getFilhos().get(c), atual + c, lista);
        }
    }
    
    
    
    public void imprimirTudo() {
    imprimirRecursivo(raiz, new StringBuilder());
}

private void imprimirRecursivo(TrieNode node, StringBuilder prefixo) {
    if (node == null) return;

    if (node.fimDePalavra) {
        System.out.println(prefixo.toString());
    }

    for (char c : node.filhos.keySet()) {
        prefixo.append(c);
        imprimirRecursivo(node.filhos.get(c), prefixo);
        prefixo.deleteCharAt(prefixo.length() - 1);  // voltar atrás
    }
}
    
}

