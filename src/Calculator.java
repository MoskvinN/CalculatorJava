import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static int number1, number2;
    private static char operation;
    private static int result;

    private static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static String[] arab = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10"};

    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){
        String inputWithoutSpaces = input.trim().replaceAll(" +", "");
        if (input.contains("+")) {
            operation = '+';
        }
        if (input.contains("-")) {
            operation = '-';
        }
        if (input.contains("*")) {
            operation = '*';
        }
        if (input.contains("/")) {
            operation = '/';
        }
        String[] splitInput = inputWithoutSpaces.split("[+-/*]");
        if (splitInput.length < 2){
            Exception e = new Exception("Строка не является мат. операцией");
            e.printStackTrace();
            return " ";
        }else if (splitInput.length > 2){
            Exception e = new Exception("Формат математической операции не удовлетворяет заданию");
            e.printStackTrace();
            return " ";
        }
        if(Arrays.asList(roman).contains(splitInput[0]) && Arrays.asList(roman).contains(splitInput[1])){
            number1 = romanToNumber(splitInput[0]);
            number2 = romanToNumber(splitInput[1]);
            if(number1 < number2 && operation == '-'){
                Exception e = new Exception("В римской системе нет отрицательных чисел");
                e.printStackTrace();
            }else {
                result = calculated(number1, number2, operation);
                String RomeResult = convertNumToRoman(result - 1);
                return RomeResult;
            }
        }else if(Arrays.asList(arab).contains(splitInput[0]) && Arrays.asList(arab).contains(splitInput[1])){
            number1 = Integer.parseInt(splitInput[0]);
            number2 = Integer.parseInt(splitInput[1]);
            result = calculated(number1, number2, operation);
            return "" + result;
        }else if((Arrays.asList(arab).contains(splitInput[0]) && Arrays.asList(roman).contains(splitInput[1]))||
                (Arrays.asList(roman).contains(splitInput[0]) && Arrays.asList(arab).contains(splitInput[1]))) {
            Exception e = new Exception("Используются разные системы счисления");
            e.printStackTrace();
        }else {
            Exception e = new Exception("Одно или несколько чисел больше 10");
            e.printStackTrace();
        }
        return "";
    }
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
    private static int romanToNumber (String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return 0;
    }
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
