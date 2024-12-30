package ru.iteco.fmhandroid.test.tests;


import static ru.iteco.fmhandroid.test.page.Data.notRegisteredLogin;
import static ru.iteco.fmhandroid.test.page.Data.validLogin;
import static ru.iteco.fmhandroid.test.page.Data.validPassword;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import ru.iteco.fmhandroid.test.AppActivity;
import ru.iteco.fmhandroid.test.helper.AuthorizationHelper;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    AuthorizationHelper authStep = new AuthorizationHelper();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;


    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();

        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Test
    public void successAuthorization() {
        authStep.login(validLogin, validPassword);
        authStep.logoMainPage();
        authStep.logOut();

    }

    @Test
    public void logOut() {
        authStep.login(validLogin, validPassword);
        authStep.logoMainPage();
        authStep.logOut();

    }

    @Test
    public void NotValidAuthorization() {
        authStep.login(notRegisteredLogin, validPassword);
        authStep.notRegisteredUser("Something went wrong. Try again later.", decorView);

    }


}
