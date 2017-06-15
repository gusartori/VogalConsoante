package com.project.model;

public class StreamWord implements Stream {

    private final String palavra;

    private int index;

    private final char[] caracteresPalavra;

    @Override
    public char getNext() {
        char caractereAtual = caracteresPalavra[index];
        index++;
        return caractereAtual;
    }

    @Override
    public boolean hasNext() {
        if(index < caracteresPalavra.length) {
            return true;
        } else {
            return false;
        }

    }

    public StreamWord(String palavra) {
        if(palavra==null){
            throw new IllegalArgumentException("O input de dados não contém uma palavra. Tente novamente por favor.");
        }
        this.palavra = palavra;
        this.caracteresPalavra = palavra.toCharArray();
    }
}
