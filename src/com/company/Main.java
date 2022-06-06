package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static String word = "vanobivan";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Угадай слово");
        String maskWord = "-".repeat(word.length());
        System.out.println(maskWord);

        do{
            System.out.print("Введите букву: ");
            char c = input.next().charAt(0);

            if(word.toLowerCase(Locale.ROOT).indexOf(Character.toLowerCase(c)) >= 0){
                maskWord = checkUnmask(c, maskWord);
            } else {
                System.out.println("Промах, попробуй еще раз.");
            }

            System.out.println(maskWord);
        } while(maskWord.contains("-"));
        System.out.println("Слово отгадано: " + maskWord);
    }

    public static String checkUnmask(char ch, String maskWord){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            if (Character.toLowerCase(ch) == word.toLowerCase(Locale.ROOT).charAt(i)){
                sb.append(word.charAt(i));
            } else {
                sb.append(maskWord.charAt(i));
            }
        }
        return sb.toString();
    }
}
