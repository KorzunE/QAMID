package ru.iteco.fmhandroid.test.helper;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.test.page.About;
import ru.iteco.fmhandroid.test.page.Main;
import ru.iteco.fmhandroid.test.page.News;
import ru.iteco.fmhandroid.test.page.Quotation;

public class MainHelper {
    Main mainPaige = new Main();
    News newsPage = new News();
    About aboutPage = new About();
    Quotation quotationPage = new Quotation();


    public void goToNews() {
        mainPaige.iconBurgerButton.check(matches(isDisplayed()));
        mainPaige.iconBurgerButton.perform(click());
        mainPaige.newsOfBurger.check(matches(isDisplayed()));
        mainPaige.newsOfBurger.perform(click());
        newsPage.pageOfNews.check(matches(isDisplayed()));
    }

    public void goToAbout() {
        mainPaige.iconBurgerButton.check(matches(isDisplayed()));
        mainPaige.iconBurgerButton.perform(click());
        mainPaige.newsOfBurger.check(matches(isDisplayed()));
        mainPaige.aboutOfBurger.perform(click());
        aboutPage.versionAboutPage.check(matches(isDisplayed()));
    }


    public void goToQuotation() {
        mainPaige.iconQuotation.check(matches(isDisplayed()));
        mainPaige.iconQuotation.perform(click());
        quotationPage.pageOfQuotation.check(matches(isDisplayed()));
    }


}
