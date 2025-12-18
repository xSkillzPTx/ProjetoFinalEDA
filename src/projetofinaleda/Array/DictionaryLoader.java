
package projetofinaleda.Array;

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
