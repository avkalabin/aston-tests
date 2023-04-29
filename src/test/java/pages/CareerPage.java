package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CareerPage {

    public void openCareerPage() {
        open("https://astondevs.ru/career");
    }

    public void clickButtonIsRemoteWorkPossible() {
        $(withText("Часто задаваемые вопросы")).scrollTo();
        $(byTagAndText("p", "Возможно ли работать удаленно?")).click();
    }

    public void verifyPossibilityRemoteWork() {
        $(withText("Практически все сотрудники могут работать удаленно")).shouldBe(visible);
    }
}
