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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author duart
 */


public class Teclado {

    // Mapa: letra → conjunto das letras vizinhas (incluindo ela própria)
    private static final Map<Character, Set<Character>> VIZINHOS;

    static {
        VIZINHOS = new HashMap<>();

        // Linha superior
        adicionarVizinhos('q', "w");
        adicionarVizinhos('w', "qea");
        adicionarVizinhos('e', "wrsd");
        adicionarVizinhos('r', "etdf");
        adicionarVizinhos('t', "ryfg");
        adicionarVizinhos('y', "tugf");  // y tem vizinhos t,u,g,f
        adicionarVizinhos('u', "yihg");
        adicionarVizinhos('i', "ueojk");
        adicionarVizinhos('o', "ipkl");
        adicionarVizinhos('p', "olç");

        // Linha do meio
        adicionarVizinhos('a', "qws");
        adicionarVizinhos('s', "awedxz");
        adicionarVizinhos('d', "serfcx");
        adicionarVizinhos('f', "drtgvc");
        adicionarVizinhos('g', "ftbhv");
        adicionarVizinhos('h', "gyujnb");
        adicionarVizinhos('j', "huikm");
        adicionarVizinhos('k', "jioçl");
        adicionarVizinhos('l', "kopç");
        adicionarVizinhos('ç', "pl");

        // Linha de baixo (sem espaço, mas com enter normalmente)
        adicionarVizinhos('z', "asx");
        adicionarVizinhos('x', "zcsd");
        adicionarVizinhos('c', "xdfv");
        adicionarVizinhos('v', "cgb");
        adicionarVizinhos('b', "vhn");
        adicionarVizinhos('n', "bhjm");
        adicionarVizinhos('m', "nkj");
    }

    // Método auxiliar para adicionar as duas direções automaticamente
   
    private static void adicionarVizinhos(char centro, String vizinhosStr) {
        centro = Character.toLowerCase(centro);
        Set<Character> set = new HashSet<>();
        set.add(centro); // inclui a própria letra
        
        for (char c : vizinhosStr.toCharArray()) {
            char vizinho = Character.toLowerCase(c);
            set.add(vizinho);
        }
        
        VIZINHOS.put(centro, Collections.unmodifiableSet(set));
                                                                
    }

    // Método que vais usar em todo o lado
    //“Dá-me os vizinhos da letra c. Se não souberes quem são, pelo menos devolve a própria letra c.”
    public static Set<Character> getVizinhos(char c) {
        c = Character.toLowerCase(c);
        return VIZINHOS.getOrDefault(c, Set.of(c)); // se não existir, devolve só ela própria
    }

   
}

//Resumo
//O mapa de vizinhos inclui sempre a própria letra porque o utilizador pode ter acertado.
//Uso Set<Character> porque não queremos repetidos e a ordem não importa.
//Uso getOrDefault(..., Set.of(c)) para letras fora do teclado (números, símbolos) não darem erro.
//E coloco os conjuntos imutáveis com unmodifiableSet para garantir que o teclado nunca é alterado acidentalmente.