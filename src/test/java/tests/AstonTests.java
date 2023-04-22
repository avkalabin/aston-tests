package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AstonTests extends TestBase {

    @Test
    @DisplayName("Проверка элементов главного меню")
    void mainMenuElementsTest() {
        step("Открываем страницу https://astondevs.ru/", () ->
                open("https://astondevs.ru/"));
        step("Главное меню должно содержать элементы \"Технологии Отрасли Услуги Проекты Компания Карьера\"", () ->
                $(".MainNav-module--list--X5WUN").shouldHave(text("Технологии Отрасли Услуги Проекты Компания Карьера")));
    }

    @Test
    @DisplayName("В перечне технологий содержится ссылка на \"1С-Битрикс\"")
    void technologyShouldHave1CTest() {
        step("Открываем страницу https://astondevs.ru/", () -> {
            open("https://astondevs.ru/");
            $(byTagAndText("h1", "ИТ-решения для развития бизнеса")).click();
        });

        step("Наводим курсор на элемент \"Технологии\"", () ->
                $("li[tabindex = 'Технологии']").hover());

        step("Ссылка \"1С-Битрикс\"  должна быть видима", () ->
                $(byLinkText("1С-Битрикс")).shouldBe(visible));
    }

    @Test
    @DisplayName("Форма \"Свяжитесь с нами\" имеет обязательные поля")
    void connectUsShouldHaveRequiredFieldsTest() {
        step("Открываем форму \"Свяжитесь с нами\" на странице https://astondevs.ru/", () -> {
            open("https://astondevs.ru/");
            $(byTagAndText("h2", "Свяжитесь с нами")).scrollTo();
        });

        step("Кликаем \"Я хочу защитить свои данные\"", () ->
                $("input[name='nda']").parent().click());

        step("Кликаем \"Я даю согласие\"", () ->
                $("input[name='personalData']").parent().click(usingJavaScript().offsetX(222)));

        step("Нажимаем кнопку \"Отправить\"", () ->
                $(byTagAndText("button", "Отправить")).click());

        step("Обязательные для заполнения поля должны быть подсвечены", () -> {
            $(byTagAndText("div", "Укажите название компании")).shouldBe(visible);
            $(byTagAndText("div", "Введите телефон")).shouldBe(visible);
            $(byTagAndText("div", "Введите корпоративную почту")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Адрес московоского офиса указан корректно")
    void companyAddressShouldBeCorrectTest() {
        step("Открываем форму \"Офисы\" на странице https://astondevs.ru/about-us", () -> {
            open("https://astondevs.ru/about-us");
            $(byTagAndText("div", "Офисы")).scrollTo();
        });

        step("Кликаем по офису \"Москва\"", () ->
                $(byTagAndText("div", "Москва")).click());

        step("Модальное окно д.б. с корректным адресом", () -> {
            $(byTagAndText("ymaps", "Москва, Россия")).parent()
                    .shouldHave(text("Пресненская набережная, д.6, стр. 2, БЦ «Башня Империя», 3 подъезд, 50 этаж, офис 5008"));
        });
    }

    @Test
    @DisplayName("В разделе \"Карьера\" указана возможность удаленной работы")
    void isItPossibleToWorkRemotelyTest() {
        step("Открываем страницу \"Карьера\" сайта https://astondevs.ru", () -> {
            open("https://astondevs.ru/career");
        });

        step("Кликаем по кнопке \"Возможно ли работать удаленно?\"", () -> {
            $(withText("Часто задаваемые вопросы")).scrollTo();
            $(byTagAndText("p", "Возможно ли работать удаленно?")).click();
        });

        step("Текст \"Практически все сотрудники могут работать удаленно\" д.б. видим ", () ->
                $(withText("Практически все сотрудники могут работать удаленно")).shouldBe(visible));
    }

}
