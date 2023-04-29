package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AboutUsPage;
import pages.CareerPage;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

public class AstonTests extends TestBase {
    MainPage mainPage = new MainPage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    CareerPage careerPage = new CareerPage();

    @Test
    @DisplayName("Проверка элементов главного меню")
    void mainMenuElementsTest() {
        step("Открываем страницу https://astondevs.ru/", () ->
                mainPage.openMainPage());
        step("Главное меню должно содержать элементы \"Технологии Отрасли Услуги Проекты Компания Карьера\"", () ->
                mainPage.verifyMainMenu());
    }

    @Test
    @DisplayName("В перечне технологий содержится ссылка на \"1С-Битрикс\"")
    void technologyShouldHave1CTest() {
        step("Открываем страницу https://astondevs.ru/", () ->
                mainPage.openMainPage());

        step("Наводим курсор на элемент \"Технологии\"", () ->
                mainPage.hoverTechnologyElement());

        step("Ссылка \"1С-Битрикс\"  должна быть видима", () ->
                mainPage.verify1CBitrixVisible());
    }

    @Test
    @DisplayName("Форма \"Свяжитесь с нами\" имеет обязательные поля")
    void connectUsShouldHaveRequiredFieldsTest() {
        step("Открываем форму \"Свяжитесь с нами\" на странице https://astondevs.ru/", () ->
                mainPage.openMainPage().scrollToConnectUS());

        step("Кликаем \"Я хочу защитить свои данные\"", () ->
                mainPage.clickWantToSaveData());

        step("Кликаем \"Я даю согласие\"", () ->
                mainPage.ClickIAgree());

        step("Нажимаем кнопку \"Отправить\"", () ->
                mainPage.pressSendButton());

        step("Обязательные для заполнения поля должны быть подсвечены", () ->
                mainPage.verifyRequiredFields());
    }

    @Test
    @DisplayName("Адрес московоского офиса указан корректно")
    void companyAddressShouldBeCorrectTest() {
        step("Открываем форму \"Офисы\" на странице https://astondevs.ru/about-us", () ->
                aboutUsPage.openAboutUsPage().scrollToOfficesElement());

        step("Кликаем по офису \"Москва\"", () ->
                aboutUsPage.chooseMoscowOffice());

        step("Модальное окно д.б. с корректным адресом", () ->
                aboutUsPage.verifyCorrectAddress());
    }

    @Test
    @DisplayName("В разделе \"Карьера\" указана возможность удаленной работы")
    void isItPossibleToWorkRemotelyTest() {
        step("Открываем страницу \"Карьера\" сайта https://astondevs.ru", () ->
                careerPage.openCareerPage());

        step("Кликаем по кнопке \"Возможно ли работать удаленно?\"", () ->
                careerPage.clickButtonIsRemoteWorkPossible());

        step("Текст \"Практически все сотрудники могут работать удаленно\" д.б. видим ", () ->
                careerPage.verifyPossibilityRemoteWork());
    }
}
