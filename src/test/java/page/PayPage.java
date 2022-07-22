package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Data;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PayPage {
    private final SelenideElement fieldCardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldNumberOfMonth = $("input[placeholder='08']");
    private final SelenideElement fieldYear = $("input[placeholder='22']");
    private final ElementsCollection fieldSet = $$(".input__control");
    private final SelenideElement fieldCardholder = fieldSet.get(3);
    private final SelenideElement fieldCvv = $("input[placeholder='999']");

    private final SelenideElement improperFormat = $(byText("Неверный формат"));
    private final SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement invalidExpiredDate = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredDatePass = $(byText("Истёк срок действия карты"));
    private final SelenideElement successNote = $(byText("Операция одобрена Банком."));
    private final SelenideElement failureNote = $(byText("Ошибка! Банк отказал в проведении операции."));

    private final SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public void fillCardData(Data.CardData cardData) {
        fieldCardNumber.setValue(cardData.getNumber());
        fieldNumberOfMonth.setValue(cardData.getMonth());
        fieldYear.setValue(cardData.getYear());
        fieldCardholder.setValue(cardData.getHolder());
        fieldCvv.setValue(cardData.getCvv());
        continueButton.click();
    }

    public void shouldImproperFormatNotification() {
        improperFormat.shouldBe(Condition.visible);
    }

    public void shouldImproperFormatNotificationHidden() {
        improperFormat.shouldBe(Condition.hidden);
    }

    public void shouldEmptyFieldNotification() {
        emptyField.shouldBe(Condition.visible);
    }

    public void shouldInvalidExpiredDateNotification() {
        invalidExpiredDate.shouldBe(Condition.visible);
    }

    public void shouldExpiredDatePassNotification() {
        expiredDatePass.shouldBe(Condition.visible);
    }

    public void shouldSuccessNotification() {
        successNote.shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public void shouldSuccessNotificationHidden() {
        successNote.shouldBe(Condition.hidden, Duration.ofSeconds(30));
    }

    public void shouldFailureNotification() {
        failureNote.shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}