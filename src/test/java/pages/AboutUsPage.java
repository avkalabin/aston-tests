package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AboutUsPage {
    private final SelenideElement OFFICES = $(byTagAndText("div", "Офисы")),
            MOSCOW_OFFICE = $(byTagAndText("div", "Москва")),
            SELECTED_OFFICE = $(byTagAndText("ymaps", "Москва, Россия")).parent();

    public AboutUsPage openAboutUsPage() {
        open("https://astondevs.ru/about-us");
        return this;
    }

    public void scrollToOfficesElement() {
        OFFICES.scrollTo();
    }

    public void chooseMoscowOffice() {
        MOSCOW_OFFICE.click();
    }

    public void verifyCorrectAddress(String correctAddress) {
        SELECTED_OFFICE.shouldHave(text(correctAddress));
    }
}
