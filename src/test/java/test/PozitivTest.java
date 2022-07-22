package test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.Data;
import data.SQL;
import page.MainPage;
import page.PayPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static data.Data.*;

public class PozitivTest extends UiBase {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }

    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldSuccessNotification();

        val expectedStatus = "APPROVED";
        val actualStatus = SQL.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void shouldFailurePayIfValidDeclinedCards() {
        val cardData = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        payPage.fillCardData(cardData);
        payPage.shouldFailureNotification();

        val expectedStatus = "DECLINED";
        val actualStatus = SQL.getPaymentStatus();
        assertEquals(expectedStatus, actualStatus);
    }
}
