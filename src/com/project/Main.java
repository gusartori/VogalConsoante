package com.project;

import com.project.exception.VowelNotFoundException;
import com.project.model.Stream;
import com.project.model.StreamWord;
import com.project.util.CharacterFinder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = readInput();
        Stream stream = new StreamWord(input);
        try {
            char vogal = CharacterFinder.firstChar(stream);
            System.out.println(vogal);
        } catch (VowelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readInput(){
        Scanner scan = new Scanner(System.in);
        String palavra = scan.next();
        scan.close();
        return palavra;
    }

}
