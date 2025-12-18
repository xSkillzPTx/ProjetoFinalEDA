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


package projetofinaleda.Trie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TrieNode implements Serializable {
    protected final Map<Character, TrieNode> filhos = new HashMap<>();
    protected boolean fimDePalavra = false;
    protected int frequencia = 0;

    public void incrementarFrequencia() {
        frequencia++;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public Map<Character, TrieNode> getFilhos() {
        return filhos;
    }

    public boolean isFimDePalavra() {
        return fimDePalavra;
    }

    public void setFimDePalavra(boolean fimDePalavra) {
        this.fimDePalavra = fimDePalavra;
    }
}