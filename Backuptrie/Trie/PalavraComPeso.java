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

public class PalavraComPeso implements Comparable<PalavraComPeso> {
    public final String palavra;
    public final int peso;

    public PalavraComPeso(String palavra, int peso) {
        this.palavra = palavra;
        this.peso = peso;
    }

    @Override
    public int compareTo(PalavraComPeso o) {
        return Integer.compare(this.peso, o.peso);
    }

    @Override
    public String toString() { return palavra; }
}