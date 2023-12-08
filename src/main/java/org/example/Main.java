package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        String s1 = "ABCD ABCE ABCDJ ABCDFF";
        String s2 = "ABCCDEFF";
        String s3 = "ABCOP";
        String s4 = "abcd abce a0bc5abcg6abch? st st123 st0 12345 ababwef abab ababab ababababababab";
        String s5 = "мой номер 79804357234";

        Pattern pattern1 = Pattern.compile("AB");
        Pattern pattern2 = Pattern.compile("[ABC]");
        Pattern pattern3 = Pattern.compile("AB[A-F]OP");
        Pattern pattern4 = Pattern.compile("abc[^e-g4-7]");
        Pattern pattern5 = Pattern.compile("abc(e|5)");
        Pattern pattern6 = Pattern.compile("abc.");
        Pattern pattern7 = Pattern.compile("abch$");

        Pattern pattern8 = Pattern.compile("[0-9]");
        Pattern pattern81 = Pattern.compile("\\d"); // только цифры
        Pattern pattern82 = Pattern.compile("\\D"); // всё, кроме цифр

        Pattern pattern83 = Pattern.compile("\\w"); // только цифры и буквы
        Pattern pattern84 = Pattern.compile("\\W"); // всё, кроме цифр и букв

        Pattern pattern85 = Pattern.compile("st\\w+");

        Pattern pattern86 = Pattern.compile("\\w{5}");

        Pattern pattern87 = Pattern.compile("\\w\\s\\w");
        Pattern pattern88 = Pattern.compile("\\D{2,}");

        Pattern pattern89 = Pattern.compile("(ab){2,6}");


        Matcher matcher = pattern89.matcher(s4);

        while (matcher.find()) {
            System.out.println("position " + matcher.start() + " " + matcher.group() + "\n");
        }
        System.out.println("end");


        System.out.println(s5.replaceAll("\\d", "*"));

        returnNumbersFromAString("43fdsw56hhfgff8");

        System.out.println(returnListOfPhoneNumbers("+79515604647"));

        System.out.println(replaceNumbersInStringWithCharacters("rersds733291023rkre0483i2324"));

        System.out.println(countOfNumbersInString("674red27a11d"));
    }


    public static void returnNumbersFromAString(String stringWithNumbers) {

        Pattern pattern = Pattern.compile("\\d");

        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            System.out.println("position " + matcher.start() + " number " + matcher.group());
        }
    }

    public static List<String> returnListOfPhoneNumbers(String phoneNumber) {

        List<String> phoneNumbersList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\+\\d{0,11}");

        Matcher matcher = pattern.matcher(phoneNumber);

        while (matcher.find()) {
            phoneNumbersList.add(matcher.group());
        }
        return phoneNumbersList;
    }


    public static String replaceNumbersInStringWithCharacters(String stringWithNumbers) { //метод берет строку и заменяет числа на *
        return stringWithNumbers.replaceAll("\\d", "*");
    }


    public static int countOfNumbersInString(String stringWithNumbers) {

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(stringWithNumbers);
        int counter = 0;
        while (matcher.find()) {
            counter++; // метод groupCount() не подойдет для подобного подсчета, поэтому надо создать счетчик
        }

        return counter;
    }


}