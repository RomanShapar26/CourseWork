package test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.Data;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class NegativTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfMonthMore12() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthMore12(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldSuccessPayIfLettersMonth() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getLettersMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithOneDigit(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithZeros() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithZero(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldInvalidExpiredDateNotification();
    }

    @Test
    public void shouldSuccessPayIfMonthWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWithSigns(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCLetters() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCLetters());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCOneDigit());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCTwoDigits() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCTwoDigits());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCWithSigns());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfCVCEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVCEmptyField());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }

    @Test
    public void shouldSuccessPayIfNameInRussia() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameInRussia(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }

    @Test
    public void shouldSuccessPayIfNameWithNumbers() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWithNumbers(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldImproperFormatNotification();
    }


    @Test
    public void shouldSuccessPayIfNameWithHyphens() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWithHyphens(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldSuccessNotification();
    }

    @Test
    public void shouldSuccessPayIfNameEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameEmptyField(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldEmptyFieldNotification();
    }

}
