package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Кол-во слов в строке: %d%n", wordsCount());
        String[] fullName = inputName().split(" ");
        notification(fullName[0], fullName[1]);
        randomWord();
    }

    public static int wordsCount() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String string = in.nextLine().replaceAll("  +", " ");
        return string.split(" ").length;
    }

    public static String inputName() {
        System.out.print("Введите имя и фамилию на кириллице через пробел. Имя и фамилия должны начинаться с большой буквы: ");
        Scanner in = new Scanner(System.in);
        Pattern regex = Pattern.compile("([А-ЯЁ][а-яё]+) ([А-ЯЁ][а-я]+)");
        while (true) {
            String value = in.nextLine();
            if (regex.matcher(value).find()) {
                return value;
            } else {
                System.out.print("Некорректный ввод! Имя и фамилия должны быть напечатаны на кириллице через пробел и начинаться с большой буквы.\nВведите имя и фамилию: ");
            }
        }
    }

    public static void notification(String firstName, String secondName) {
        System.out.printf("Внимание! %s %s героически спасает прод от падения! Вам начислено 2 СМ коина.%n", firstName, secondName);
    }

    public static void randomWord() {
        String[] words = {"Java", "это", "очень", "интересно", "и", "увлекательно", ":)"};
        Random random = new Random();
        int randomNumber = random.nextInt(words.length);
        System.out.println(words[randomNumber]);
    }
}