/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal;

import java.util.*;

/**
 *
 * @author Igor
 */
public class DictionaryArray {

    private final List<String> palavras;

    public DictionaryArray() {
        this.palavras = new ArrayList<>();
    }

    public void insert(String palavra) {
        palavras.add(palavra);
    }

    public List<String> search(String input, Teclado teclado) {
        Set<String> results = new HashSet<>(); //Uso o Set para evitar duplicados nos resultados

        for (String palavra : palavras) {
            if (matches(palavra, input, teclado)) {
                results.add(palavra);
            }
        }
        return new ArrayList<>(results);
    }

    private boolean matches(String palavra, String input, Teclado teclado) {
        if (palavra.length() < input.length()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char palavraChar = palavra.charAt(i);

            List<Character> vizinhos = teclado.getVizinhos(inputChar);
            if (!vizinhos.contains(palavraChar)) {
                return false;
            }

        }
        return true;
    }
}
