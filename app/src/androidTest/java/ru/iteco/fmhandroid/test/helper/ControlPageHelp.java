package ru.iteco.fmhandroid.test.helper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.RecyclerViewActions;
import android.view.View;
import org.hamcrest.Matchers;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.test.page.Control;

public class ControlPageHelp {
    Control controlPanelPage = new Control();
    CustomActionsHelp customViewActions = new CustomActionsHelp();

    public void clickCreateNews() {
        controlPanelPage.ButtonCreateNews.check(matches(isDisplayed()));
        controlPanelPage.ButtonCreateNews.perform(click());
    }


    public void clickDeleteNews(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        customViewActions.clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(controlPanelPage.ButtonAgreement()).perform(click());

    }

    public void clickEditButton(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        customViewActions.clickChildViewWithId(R.id.edit_news_item_image_view)));

    }

    public void clickSwitch() {
        controlPanelPage.switchAction.check(matches(isDisplayed()));
        controlPanelPage.switchAction.perform(click());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }

    public void fillFieldsNews(String description, String titleName) {
        onView(controlPanelPage.ButtonChoseCategory()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChoseCategory()).perform(click());
        onView(controlPanelPage.categoryAnnouncement()).check(matches(isDisplayed()));
        onView(controlPanelPage.categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    public void fillNewsCategoryEmpty(String description, String titleName) {
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));//
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());//
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    public void checkInformationMessageEmptyCategory(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void editCreatedNews(String description) {
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}
