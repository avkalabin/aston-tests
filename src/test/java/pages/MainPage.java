package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement MAIN_MENU = $(".MainNav-module--list--X5WUN"),
            TECHNOLOGY_ELEMENT = $("li[tabindex = 'Технологии']"),
            NDA_INPUT = $("input[name='nda']").parent(),
            PERSONAL_DATA_INPUT = $("input[name='personalData']").parent();


    public MainPage openMainPage() {
        open("https://astondevs.ru/");
        return this;
    }

    public void verifyMainMenu(String value) {
        MAIN_MENU.shouldHave(text(value));
    }

    public void hoverTechnologyElement() {
        TECHNOLOGY_ELEMENT.hover();
    }

    public void verify1CBitrixVisible() {
        $(byLinkText("1С-Битрикс")).shouldBe(visible);
    }

    public void scrollToConnectUS() {
        $(byTagAndText("h2", "Свяжитесь с нами")).scrollTo();
    }

    public void clickWantToSaveData() {
        NDA_INPUT.click();
    }

    public void ClickIAgree() {
        PERSONAL_DATA_INPUT.click(usingJavaScript().offsetX(222));
    }

    public void pressSendButton() {
        $(byTagAndText("button", "Отправить")).click();
    }

    public void verifyRequiredFields() {
        $(byTagAndText("div", "Укажите название компании")).shouldBe(visible);
        $(byTagAndText("div", "Введите телефон")).shouldBe(visible);
        $(byTagAndText("div", "Введите корпоративную почту")).shouldBe(visible);
    }

}
