import java.util.List;
import java.util.Arrays;

// Interface comum para as duas implementações
interface Keyboard {
    List<String> getSuggestions(String prefix);
}

// Exemplo: tua implementação com Trie
class TrieKeyboard implements Keyboard {
    // construtor, insert, etc.

    public TrieKeyboard(List<String> words) {
        for (String w : words) {
            insert(w);
        }
    }

    private void insert(String word) {
        // TODO: implementação da trie
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        // TODO: devolve as sugestões a partir da trie
        return List.of();
    }
}

// Exemplo: tua implementação com array
class ArrayKeyboard implements Keyboard {
    private final List<String> words;

    public ArrayKeyboard(List<String> words) {
        this.words = words;
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        // exemplo simples: filtra linearmente
        return words.stream()
                .filter(w -> w.startsWith(prefix))
                .toList();
    }
}

public class BenchmarkTeclado {

    // função genérica de benchmark
    public static long benchmarkGetSuggestions(Keyboard k,
                                              List<String> prefixes,
                                              int repeticoes) {
        long start = System.nanoTime();
        for (int r = 0; r < repeticoes; r++) {
            for (String p : prefixes) {
                k.getSuggestions(p); // só interessa o tempo
            }
        }
        long end = System.nanoTime();
        return end - start; // nanos
    }

    public static void main(String[] args) {
        // 1) palavras do "dicionário"
        List<String> words = Arrays.asList(
                "Abundante",
  "Benevolente",
  "Convergente",
  "Diligente",
  "Empático",
  "Furtivo",
  "Genuíno",
  "Hospitaleiro",
  "Íntegro",
  "Jubiloso",
  "Kafkiano",
  "Límpido",
  "Magnânimo",
  "Nostálgico",
  "Obstetra",
  "Pacífico",
  "Quimera",
  "Resiliente",
  "Solidário",
  "Temerário",
  "Útil",
  "Virtuoso",
  "Xilofone",
  "Ypê (Ipê)",
  "Ziguezague",
  "Ética",
  "Moralidade",
  "Transparência",
  "Responsabilidade",
  "Diversidade",
  "Resiliência",
  "Integração",
  "Empatia",
  "Tolerância",
  "Injustiça",
  "Autêntico",
  "Perspicaz",
  "Efêmero",
  "Eloquente",
  "Paradoxal",
  "Ubíquo",
  "Serendipidade",
  "Alvíssaras",
  "Cauteloso",
  "Deslumbrante",
  "Eficaz",
  "Frugal",
  "Gratuito",
  "Harmonia",
  "Inefável",
  "Jurisprudência",
  "Lacónico",
  "Mitigação",
  "Nefasto",
  "Onírico",
  "Perene",
  "Quixotesco",
  "Racional",
  "Sarcástico",
  "Taciturno",
  "Umbrátil",
  "Vituperar",
  "Xénofobo",
  "Zelo",
  "Aberração",
  "Banal",
  "Conspícuo",
  "Delirante",
  "Efervescente",
  "Fulminante",
  "Gregário",
  "Híbrido",
  "Idiosincrasia",
  "Juízo",
  "Lúdico",
  "Meticuloso",
  "Nuance",
  "Oneroso",
  "Paternalista",
  "Quociente",
  "Ruminar",
  "Súbito",
  "Tangível",
  "Ufanismo",
  "Voraz",
  "Xenofobia",
  "Yuppie (jovem profissional)",
  "Zênite",
  "Aconchego",
  "Breve",
  "Cativante",
  "Dilema",
  "Enigma",
  "Fascínio",
  "Genuinidade",
  "Harmônico",
  "Ilusório",
  "Jactância",
  "Labirinto",
  "Misericórdi"
        );

        // 2) constrói as duas implementações
        Keyboard trieKeyboard = new TrieKeyboard(words);
        Keyboard arrayKeyboard = new ArrayKeyboard(words);

        // 3) lista de prefixos de teste (podes trocar ou aumentar)
        List<String> prefixes = Arrays.asList(
                "Abundante",
  "Benevolente",
  "Convergente",
  "Diligente",
  "Empático",
  "Furtivo",
  "Genuíno",
  "Hospitaleiro",
  "Íntegro",
  "Jubiloso",
  "Kafkiano",
  "Límpido",
  "Magnânimo",
  "Nostálgico",
  "Obstetra",
  "Pacífico",
  "Quimera",
  "Resiliente",
  "Solidário",
  "Temerário",
  "Útil",
  "Virtuoso",
  "Xilofone",
  "Ypê (Ipê)",
  "Ziguezague",
  "Ética",
  "Moralidade",
  "Transparência",
  "Responsabilidade",
  "Diversidade",
  "Resiliência",
  "Integração",
  "Empatia",
  "Tolerância",
  "Injustiça",
  "Autêntico",
  "Perspicaz",
  "Efêmero",
  "Eloquente",
  "Paradoxal",
  "Ubíquo",
  "Serendipidade",
  "Alvíssaras",
  "Cauteloso",
  "Deslumbrante",
  "Eficaz",
  "Frugal",
  "Gratuito",
  "Harmonia",
  "Inefável",
  "Jurisprudência",
  "Lacónico",
  "Mitigação",
  "Nefasto",
  "Onírico",
  "Perene",
  "Quixotesco",
  "Racional",
  "Sarcástico",
  "Taciturno",
  "Umbrátil",
  "Vituperar",
  "Xénofobo",
  "Zelo",
  "Aberração",
  "Banal",
  "Conspícuo",
  "Delirante",
  "Efervescente",
  "Fulminante",
  "Gregário",
  "Híbrido",
  "Idiosincrasia",
  "Juízo",
  "Lúdico",
  "Meticuloso",
  "Nuance",
  "Oneroso",
  "Paternalista",
  "Quociente",
  "Ruminar",
  "Súbito",
  "Tangível",
  "Ufanismo",
  "Voraz",
  "Xenofobia",
  "Yuppie (jovem profissional)",
  "Zênite",
  "Aconchego",
  "Breve",
  "Cativante",
  "Dilema",
  "Enigma",
  "Fascínio",
  "Genuinidade",
  "Harmônico",
  "Ilusório",
  "Jactância",
  "Labirinto",
  "Misericórdi"
        );

        int repeticoes = 10_000;

        // 4) mede o tempo das duas
        long trieTime = benchmarkGetSuggestions(trieKeyboard, prefixes, repeticoes);
        long arrayTime = benchmarkGetSuggestions(arrayKeyboard, prefixes, repeticoes);

        int totalChamadas = prefixes.size() * repeticoes;
        double trieMedioNs = (double) trieTime / totalChamadas;
        double arrayMedioNs = (double) arrayTime / totalChamadas;

        System.out.println("Total chamadas: " + totalChamadas);
        System.out.println("Trie  - total ns: " + trieTime + " | médio ns/busca:  " + trieMedioNs);
        System.out.println("Array - total ns: " + arrayTime + " | médio ns/busca: " + arrayMedioNs);
        
    }
}
