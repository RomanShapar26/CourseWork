package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import data.SQL;

import static com.codeborne.selenide.Selenide.open;

public class UiBase {

    static String appUrl = System.getProperty("sut.url");

    @BeforeEach
    public void openSource() {
        open(appUrl);
        SQL.cleanTable();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}
