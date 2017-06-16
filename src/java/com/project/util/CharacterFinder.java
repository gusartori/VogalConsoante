package com.project.util;

import com.project.exception.VowelNotFoundException;
import com.project.model.Stream;

import java.util.*;

public class CharacterFinder {


    public static char firstChar(Stream stream) throws VowelNotFoundException {
        Map<Character, List<Character>> streamStructured = readStreamIntoDataStructure(stream);
        Optional<Character> vowelFound = findVowelWithCorrectPredecessors(streamStructured);
        if(!vowelFound.isPresent()){
            throw new VowelNotFoundException();
        }
        return vowelFound.get();
    }

    private static Map<Character, List<Character>> readStreamIntoDataStructure(Stream stream){
        Map<Character, List<Character>> streamStructured = new LinkedHashMap<>();
        LinkedList<Character> predecessorsChars = new LinkedList<>();
        while(stream.hasNext()){
            char nextChar = stream.getNext();
            if(CharRegExUtil.isVowel(nextChar)){
                if(streamStructured.get(nextChar)==null){
                    streamStructured.put(nextChar, new LinkedList<>(predecessorsChars));
                } else {
                    streamStructured.replace(nextChar, new LinkedList<>());
                }
            }
            predecessorsChars.add(nextChar);
        }
        return streamStructured;
    }

    private static Optional<Character> findVowelWithCorrectPredecessors(Map<Character, List<Character>> streamStructured) {
        Optional<Character> firstVowel = streamStructured.keySet()
                .stream()
                .filter(character -> streamStructured.get(character).size()>0
                        && CharRegExUtil.isConsonant(streamStructured.get(character).get(streamStructured.get(character).size() - 1))
                        && CharRegExUtil.isVowel(streamStructured.get(character).get(streamStructured.get(character).size() - 2)))
                .findFirst();
        return firstVowel;
    }
}
