package com.project;

import com.project.exception.VowelNotFoundException;
import com.project.model.Stream;
import com.project.model.StreamWord;
import com.project.util.CharacterFinder;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String input = readInput();
        Stream stream = new StreamWord(input);
        try {
            char vogal = CharacterFinder.firstChar(stream);
            System.out.println("Vogal encontrada: "+vogal);
        } catch (VowelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readInput(){
        System.out.println("Entre com a palavra desejada:");
        Scanner scan = new Scanner(System.in);
        String palavra = scan.nextLine();
        scan.close();
        return palavra;
    }

}
