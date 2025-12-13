/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal;

import java.io.*;

/**
 *
 * @author Igor Fonseca
 */
public class DictionaryLoader {

    public void loadDictionary(DictionaryArray dictionary, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] palavras = line.split("[^\\ p{L}]+");
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        dictionary.insert(palavra.toLowerCase());
                    }
                }
            }
            System.out.println("Dicionario carregado com sucesso a partir do arquivo " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao tentar carregar o dicionario" + e.getMessage());
        }
    }

}
