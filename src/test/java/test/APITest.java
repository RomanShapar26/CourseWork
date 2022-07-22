package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.Data;
import data.SQL;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static data.API.CreditRequestPageForm;
import static data.API.PaymentPageForm;
import static data.Data.*;

public class APITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void cleanTable() {
        SQL.cleanTable();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldValidStatusCardPaymentApproved() {
        val validApprovedCard = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        val status = PaymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldValidStatusCardPaymentDeclined() {
        val validDeclinedCard = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        val status = PaymentPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }

    @Test
    void shouldValidStatusCardCreditRequestApproved() {
        val validApprovedCard = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        val status = CreditRequestPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void shouldValidStatusCardCreditRequestDeclined() {
        val validDeclinedCard = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCVC());
        val status = CreditRequestPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }
}
