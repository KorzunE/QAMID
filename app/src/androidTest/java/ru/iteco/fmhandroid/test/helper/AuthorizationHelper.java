package ru.iteco.fmhandroid.test.helper;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import android.view.View;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.test.page.Login;
import ru.iteco.fmhandroid.test.page.Main;

public class AuthorizationHelper {
    Login loginPage = new Login();
    CustomActionsHelp customViewActions = new CustomActionsHelp();
    Main mainPaige = new Main();


    public void login(String login, String password) {
        loginPage.loginField.check(matches(isDisplayed()));
        loginPage.loginField.perform(click());
        loginPage.loginField.perform(replaceText(login));
        loginPage.passwordField.check(matches(isDisplayed()));
        loginPage.passwordField.perform(click());
        loginPage.passwordField.perform(replaceText(password), closeSoftKeyboard());
        loginPage.buttonSign.perform(click());

    }

    public void logoMainPage() {
        customViewActions.elementWaiting(withId(R.id.trademark_image_view), 10000);
        mainPaige.logoEnter.check(matches(isDisplayed()));
    }

    public void notRegisteredUser(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }


    public void logOut() {
        mainPaige.iconLogOut.check(matches(isDisplayed()));
        mainPaige.iconLogOut.perform(click());
        onView(isRoot()).perform(customViewActions.waitForElement(withText("Log out"), 10000));
        mainPaige.iconActionLogOut.check(matches(isDisplayed()));
        mainPaige.iconActionLogOut.perform(click());
        loginPage.pageAuthorization.check(matches(isDisplayed()));

    }

    public void appDownload() {

        customViewActions.elementWaiting(withId(R.id.splashscreen_image_view), 10000);
    }

    public void loadAuthPage() {

        customViewActions.elementWaiting(withId(R.id.enter_button), 10000);
    }

}
