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

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Classe responsável por:
 * 1. Carregar texto (ex: Lusíadas)
 * 2. Extrair e limpar palavras
 * 3. Guardar/carregar a Trie serializada (persistência)
 */
public class ListaPalavras {

    private static final Pattern PADRAO_PALAVRA = Pattern.compile("[a-zçáéíóúàãõâêîôûäëïöü]+");

   
    // 1. CARREGA AS PALAVRAS DO FICHEIRO DE TEXTO E INSERE NA TRIE

    public static void carregarDeFicheiro(String caminhoFicheiro, Trie trie) {
        try {
            long inicio = System.currentTimeMillis();

            String textoCompleto = Files.readString(Path.of(caminhoFicheiro), StandardCharsets.UTF_8);

            textoCompleto = textoCompleto.toLowerCase();
            textoCompleto = textoCompleto.replaceAll("[^a-zçáéíóúàãõâêîôûäëïöü'\\-]", " ");

            var matcher = PADRAO_PALAVRA.matcher(textoCompleto);
            Set<String> palavrasUnicas = new HashSet<>();
            int totalEncontradas = 0;

            while (matcher.find()) {
                String palavra = matcher.group();
                if (palavra.length() >= 2) {
                    palavrasUnicas.add(palavra);
                    totalEncontradas++;
                }
            }

            for (String palavra : palavrasUnicas) {
                trie.inserir(palavra);
            }

            long fim = System.currentTimeMillis();
            System.out.println("========================================");
            System.out.println("Ficheiro carregado: " + caminhoFicheiro);
            System.out.println("Palavras brutas encontradas: " + totalEncontradas);
            System.out.println("Palavras únicas inseridas na Trie: " + palavrasUnicas.size());
            System.out.println("Tempo de carregamento: " + (fim - inicio) + " ms");
            System.out.println("========================================");

        } catch (IOException e) {
            System.err.println("Erro ao ler o ficheiro: " + caminhoFicheiro);
            e.printStackTrace();
        }
    }

    
    // 2. GUARDAR A TRIE NUM FICHEIRO BINÁRIO (serialização)
   
    public static void guardarTrie(Trie trie, String caminho) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(trie);
            System.out.println("Dicionário guardado com sucesso em: " + caminho);
        } catch (IOException e) {
            System.err.println("Erro ao guardar a Trie: " + e.getMessage());
        }
    }

   
    // 3. CARREGAR A TRIE DO FICHEIRO BINÁRIO 
  
    public static Trie carregarTrie(String caminho) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            Trie trie = (Trie) in.readObject();
            System.out.println("Dicionário carregado rapidamente de: " + caminho);
            return trie;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a Trie (a construir do zero): " + e.getMessage());
            return null;
        }
    }
}