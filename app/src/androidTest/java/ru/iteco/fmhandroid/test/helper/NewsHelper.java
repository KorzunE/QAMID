package ru.iteco.fmhandroid.test.helper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.test.page.Control;
import ru.iteco.fmhandroid.test.page.News;

public class NewsHelper {
    Control controlPanelPage = new Control();
    News newsPage = new News();

    public void clickEditNews() {
        onView(newsPage.buttonEditNews()).check(matches(isDisplayed()));
        onView(newsPage.buttonEditNews()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}