package tests.steps;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikiSteps {
    @Step("Tap the search field")
    public void searchWikiClick() {
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
    }

    @Step("Input value 'Appium'")
    public void sendKeys(String key) {
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).setValue(key);
    }

    @Step("Check to displaying results")
    public void assertResultsExist() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Step("Language = EN")
    public void assertLanguageIsEN() {
        $$(byClassName("android.widget.TextView")).first().shouldHave(text("EN"));
    }

    @Step("the Continue or the Started on the last page Wiki")
    public void clickForwardButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
    }

    @Step("Check text in the header")
    public void checkPrimaryText(String text) {
        $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(Condition.text(text));
    }

    @Step("Tap add language")
    public void addNewLanguage() {
        $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
    }

    @Step("Tap add language in the Language list")
    public void addNewLanguageInTheLanguageList() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_title")).last().click();
    }

    @Step("ChooseLanguage")
    public void chooseLanguage() {
        $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']")).click();
    }

    @Step("Check Language")
    public void checkLanguage() {
        $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']"))
                .shouldHave(attribute("text", "Русский"));
    }

    @Step("tap Back button")
    public void tapbackButton() {
        $(AppiumBy.className("android.widget.ImageButton")).click();
    }

    @Step("Check the Languages list new size")
    public void checkListSize() {
        $(AppiumBy.id("org.wikipedia.alpha:id/languagesList"))
                .$$(AppiumBy.id("org.wikipedia.alpha:id/option_label")).shouldHave(size(2));
    }
}
