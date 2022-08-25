package org.example.foo;


import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {

    // toRoman method
    public static String toRoman(int n) {

        final int thousand = (n / 1000) * 1000;
        final int hundred = ((n - thousand) / 100) * 100;
        final int ten = (((n - thousand) - hundred) / 10) * 10;
        final int decimal = (((n - thousand) - hundred) - ten);

        final String thousandToString = switch (thousand) {
            case 0 -> "";
            case 1000 -> "M";
            case 2000 -> "MM";
            case 3000 -> "MMM";
            default -> throw new IllegalStateException("Unexpected value in thousands");
        };

        final String hundredToString = switch (hundred) {
            case 0 -> "";
            case 100 -> "C";
            case 200 -> "CC";
            case 300 -> "CCC";
            case 400 -> "CD";
            case 500 -> "D";
            case 600 -> "DC";
            case 700 -> "DCC";
            case 800 -> "DCCC";
            case 900 -> "CM";
            default -> throw new IllegalStateException("Unexpected value in hundreds");
        };

        final String tenToString = switch (ten) {
            case 0 -> "";
            case 10 -> "X";
            case 20 -> "XX";
            case 30 -> "XXX";
            case 40 -> "XL";
            case 50 -> "L";
            case 60 -> "LX";
            case 70 -> "LXX";
            case 80 -> "LXXX";
            case 90 -> "XC";
            default -> throw new IllegalStateException("Unexpected value in tens");
        };

        final String decimalToString = switch (decimal) {
            case 0 -> "";
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> throw new IllegalStateException("Unexpected value in decimals");
        };


        return thousandToString + hundredToString + tenToString + decimalToString;
    }

    // TODO: FromRoman method
    public static int fromRoman(String romanNumeral) {
//        Pattern p = Pattern.compile("(^M*)");
//        Matcher thousand = p.matcher(romanNumeral);
//        System.out.println(thousand.find());
//        Pattern p = Pattern.compile("(^M{0,3})(C|CC|CCC|CD|D|DC|DCC|DCCC|CM)");
        Pattern p = Pattern.compile("(^M{0,3})(CM|DCCC|DCC|DC|D|CD|CCC|CC|C)?(.*)");
        Matcher thousand = p.matcher("MDCCCLXVI");
        System.out.println(thousand.matches());
        System.out.println(thousand.group(1));
        System.out.println(thousand.group(2));
        System.out.println(thousand.group(3));
//        final int thousand = // RegEx pour les milliers : "(^M*)";
//        final int hundred = ((n - thousand) / 100) * 100;
//        final int ten = (((n - thousand) - hundred) / 10) * 10;
//        final int decimal = (((n - thousand) - hundred) - ten);

        return 1;
    }
}
