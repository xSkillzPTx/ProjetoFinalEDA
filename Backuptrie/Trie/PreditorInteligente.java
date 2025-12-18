package projetofinaleda.Trie;

import java.util.*;

public class PreditorInteligente {

    public static List<String> obterSugestoes(String digitado, Trie trie, int maximo) {
        if (digitado.isEmpty()) return new ArrayList<>();

        Set<String> prefixos = new HashSet<>();
        gerarPrefixos(digitado.toLowerCase(), 0, "", prefixos);

        Set<String> todas = new HashSet<>();
        for (String p : prefixos) {
            todas.addAll(trie.sugerir(p, 50));
        }

        List<String> resultado = new ArrayList<>(todas);
        resultado.sort((a, b) -> {
            int lenDiff = Integer.compare(a.length(), b.length());
            return lenDiff != 0 ? lenDiff : a.compareTo(b);
        });

        return resultado.size() <= maximo ? resultado : resultado.subList(0, maximo);
    }

    private static void gerarPrefixos(String s, int pos, String atual, Set<String> lista) {
        if (pos == s.length()) {
            lista.add(atual);
            return;
        }
        char digitado = s.charAt(pos);
        for (char c : Teclado.getVizinhos(digitado)) {
            gerarPrefixos(s, pos + 1, atual + c, lista);
        }
    }
}