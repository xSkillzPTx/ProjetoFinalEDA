/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal;

import java.util.*;
import java.io.*;

/**
 *
 * @author Igor
 */
public class PredictiveEngine {

    private List<String> dictionary;
    private Map<Character, char[]> vizinhos;

    public PredictiveEngine() {
        dictionary = new ArrayList<>();
        inizializeVizinhos();
    }

    private void inizializeVizinhos() {
        vizinhos = new HashMap<>();

        vizinhos.put('q', new char[]{'w', 'a'});
        vizinhos.put('w', new char[]{'q', 'e', 'a', 's'});
        vizinhos.put('e', new char[]{'w', 'r', 's', 'd'});
        vizinhos.put('r', new char[]{'e', 't', 'd', 'f'});
        vizinhos.put('t', new char[]{'r', 'y', 'f', 'g'});
        vizinhos.put('y', new char[]{'t', 'u', 'g', 'h'});
        vizinhos.put('u', new char[]{'y', 'i', 'h', 'j'});
        vizinhos.put('i', new char[]{'u', 'o', 'j', 'k'});
        vizinhos.put('o', new char[]{'i', 'p', 'k', 'l'});
        vizinhos.put('p', new char[]{'o', 'l'});
        vizinhos.put('a', new char[]{'q', 'w', 's', 'z'});
        vizinhos.put('s', new char[]{'w', 'e', 'a', 'd', 'z', 'x'});
        vizinhos.put('d', new char[]{'e', 'r', 's', 'f', 'x', 'c'});
        vizinhos.put('f', new char[]{'r', 't', 'd', 'g', 'c', 'v'});
        vizinhos.put('g', new char[]{'t', 'y', 'f', 'h', 'v', 'b'});
        vizinhos.put('h', new char[]{'y', 'u', 'g', 'j', 'b', 'n'});
        vizinhos.put('j', new char[]{'u', 'i', 'h', 'k', 'n', 'm'});
        vizinhos.put('k', new char[]{'i', 'o', 'j', 'l', 'm'});
        vizinhos.put('l', new char[]{'o', 'p', 'k'});
        vizinhos.put('z', new char[]{'a', 's', 'x'});
        vizinhos.put('x', new char[]{'s', 'd', 'z', 'c'});
        vizinhos.put('c', new char[]{'d', 'f', 'x', 'v'});
        vizinhos.put('v', new char[]{'f', 'g', 'c', 'b'});
        vizinhos.put('b', new char[]{'g', 'h', 'v', 'n'});
        vizinhos.put('n', new char[]{'h', 'j', 'b', 'm'});
        vizinhos.put('m', new char[]{'j', 'k', 'n'});
    }

    public void carregaFicheiro(String... paths) {
        for (String filename : paths) {
            boolean carregado = false;

            String[] possiblePaths = {
                filename,
                "../" + filename,
                "src/" + filename,
                "projetoFinal/" + filename
            };

            for (String path : possiblePaths) {
                java.io.File file = new java.io.File(path);
                if (file.exists()) {
                    try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), java.nio.charset.StandardCharsets.UTF_8))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            String[] palavras = linha.split("\\P{L}+");
                            for (String palavra : palavras) {
                                if (palavra.length() > 0) {
                                    dictionary.add(palavra.toLowerCase());
                                }
                            }
                        }
                        System.out.println("Ficheiro Carregado: " + file.getAbsolutePath());
                        carregado = true;
                        break;
                    } catch (IOException e) {
                        System.err.println("Erro ao tentar ler o ficheiro " + path + ": " + e.getMessage());
                    }
                }
            }
            if (!carregado) {
                System.err.println("Nao foi possivel encontrar o ficheiro: " + filename);
            }
        }
    }

    public List<String> getSuggetions(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        String minusculas = input.toLowerCase();
        Set<String> resultados = new HashSet<>();

        for (String palavra : dictionary) {
            if (matches(minusculas, palavra)) {
                resultados.add(palavra);
                if (resultados.size() >= 20) {
                    break;
                }
            }
        }

        List<String> resultadoOrganizado = new ArrayList<>(resultados);
        Collections.sort(resultadoOrganizado);

        if (resultadoOrganizado.size() > 5) {
            return resultadoOrganizado.subList(0, 5);
        }
        return resultadoOrganizado;

    }

    public boolean matches(String input, String palavra) {
        if (palavra.length() < input.length()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char cIn = input.charAt(i);
            char cWord = palavra.charAt(i);

            if (cIn != cWord) {
                //Verifica se é vizinho
                boolean eVizinho = false;
                char[] perto = vizinhos.get(cIn);
                if (perto != null) {
                    for (char n : perto) {
                        if (n == cWord) {
                            eVizinho = true;
                            break;
                        }
                    }
                }
                if (!eVizinho) {
                    return false;
                }
            }
        }
        return true;
    }
}
