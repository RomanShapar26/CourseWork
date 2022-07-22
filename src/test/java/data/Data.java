package data;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class Data {

    private Data() {
    }

    public static Faker faker = new Faker(new Locale("en"));

    @Value
    @RequiredArgsConstructor
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    //number

    public static String getApprovedCardNumber() {
        return ("1111 2222 3333 4444");
    }

    public static String getDeclinedCardNumber() {
        return ("5555 6666 7777 8888");
    }

    public static String getWrongBigCardNumber() {
        return ("5555 6666 7777 9999 8564 066");
    }

    public static String getLettersNumber() {
        return ("kfdlsxwЯлвыалд");
    }

    public static String getUnknownCardNumber() {
        return ("2873 5228 0136 4500");
    }

    public static String getShortUnknownCardNumber() {
        return ("2873 5228 0136 450");
    }

    public static String getWithZeroCardNumber() {
        return ("0000 0000 0000 0000");
    }

    public static String getCardNumberWithSigns() {
        return ("$#55 &&&3 3443 ****");
    }

    public static String getCardNumberWithEmptyField() {
        return ("");
    }

    //month

    public static String getValidMonth() {
        LocalDate localDate = LocalDate.now();
        return String.format("%02d", localDate.getMonthValue());
    }

    public static String getMonthMore12() {
        return ("24");
    }

    public static String getLettersMonth() {
        return ("Go");
    }

    public static String getMonthWithOneDigit() {
        return ("5");
    }

    public static String getMonthWithZero() {
        return ("00");
    }

    public static String getMonthWithSigns() {
        return ("#/");
    }

    public static String getMonthWithEmptyField() {
        return ("");
    }

    //year

    public static String getValidYear() {
        return String.format("%ty", Year.now());
    }

    public static String getPastYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.minusYears(1));
    }

    public static String getLettersYear() {
        return ("Sт");
    }

    public static String getYearWithOneDigit() {
        return ("5");
    }

    public static String getLastYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(7));
    }

    public static String get23Year() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(1));
    }

    public static String get27Year() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(5));
    }

    public static String getYearWithSigns() {
        return ("#)");
    }

    public static String getYearEmptyField() {
        return ("");
    }

    //holder

    public static String getValidName() {
        return faker.name().fullName();
    }

    public static String getNameInRussia() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String getNameWithNumbers() {
        return "4321 1234";
    }

    public static String getNameWithSigns() {
        return "$^% #&*";
    }

    public static String getNameOne() {
        return faker.name().firstName();
    }

    public static String getOneLetter() {
        return "Q";
    }

    public static String getOwnerNameLong() {
        return "REfdsfsdssz Nfdssdofotrtkljskdjfaafoortopwwpw";
    }

    public static String getNameWithHyphens() {
        return "Vidfiowwa Xafsdkr-Wkfldjjuzoin";
    }

    public static String getNameEmptyField() {
        return "";
    }

    //cvv

    public static String getCVC() {
        return "864";
    }

    public static String getCVCLetters() {
        return "mlt";
    }

    public static String getCVCOneDigit() {
        return "2";
    }

    public static String getCVCTwoDigits() {
        return "25";
    }

    public static String getCVCFourDigits() {
        return "2552";
    }

    public static String getCVCWithSigns() {
        return "$&^";
    }

    public static String getCVCEmptyField() {
        return "";
    }
}