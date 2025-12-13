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
public class Teclado {
    private final  Map<Character, char[]> adjacencyMap;
    
    public Teclado() {
        adjacencyMap = new HashMap<>();
        carregaTeclas();
    }
    
    public void carregaTeclas() { 
        //Linha 1
        adjacencyMap.put('q', new char[] { 'w', 'a'});
        adjacencyMap.put('w', new char[] { 'q', 'e', 'a', 's'});
        adjacencyMap.put('e', new char[] { 'w', 'r', 's', 'd'});
        adjacencyMap.put('r', new char[] { 'e', 't', 'd', 'f'});
        adjacencyMap.put('t', new char[] { 'r', 'y', 'f', 'g'});
        adjacencyMap.put('y', new char[] { 't', 'u', 'g', 'h'});
        adjacencyMap.put('u', new char[] { 'y', 'i', 'h', 'j'});
        adjacencyMap.put('i', new char[] { 'u', 'o', 'j', 'k'});
        adjacencyMap.put('o', new char[] { 'i', 'p', 'k', 'l'});
        adjacencyMap.put('p', new char[] { 'o', 'l'});
        
        //Linha 2
        adjacencyMap.put('a', new char[] { 'q', 'w', 's', 'c'});
        adjacencyMap.put('s', new char[] { 'w', 'e', 'a', 'd', 'z', 'x'});
        adjacencyMap.put('d', new char[] { 'e', 'r', 's', 'f', 'x', 'c'});
        adjacencyMap.put('f', new char[] { 'r', 't', 'd', 'g', 'c', 'v'});
        adjacencyMap.put('g', new char[] { 't', 'y', 'f', 'h', 'v', 'b'});
        adjacencyMap.put('h', new char[] { 'y', 'u', 'g', 'j', 'b', 'n'});
        adjacencyMap.put('j', new char[] { 'u', 'i', 'h', 'k', 'n', 'm'});
        adjacencyMap.put('k', new char[] { 'i', 'o', 'j', 'l', 'm'});
        adjacencyMap.put('l', new char[] { 'o', 'p', 'k'});
        
        //Linha 3
        adjacencyMap.put('z', new char[] { 'a', 's', 'x'});
        adjacencyMap.put('x', new char[] { 's', 'd', 'z', 'c'});
        adjacencyMap.put('c', new char[] { 'd', 'f', 'x', 'v'});
        adjacencyMap.put('v', new char[] { 'f', 'g', 'c', 'b'});
        adjacencyMap.put('b', new char[] { 'g', 'h', 'v', 'n'});
        adjacencyMap.put('n', new char[] { 'h', 'j', 'b', 'm'});
        adjacencyMap.put('m', new char[] { 'j', 'k', 'n'});
    }
    
    public List<Character> getVizinhos(char c) {
        List<Character> vizinhos = new ArrayList<>(); 
        vizinhos.add(c);
        
        if(adjacencyMap.containsKey(c)) {
            for (char vizinho : adjacencyMap.get(c)) {
                vizinhos.add(vizinho);
            }
        }
        return vizinhos;
    }
}