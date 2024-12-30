package ru.iteco.fmhandroid.test.tests;



import static ru.iteco.fmhandroid.test.page.Data.validLogin;
import static ru.iteco.fmhandroid.test.page.Data.validPassword;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.test.AppActivity;
import ru.iteco.fmhandroid.test.helper.AboutPage;
import ru.iteco.fmhandroid.test.helper.AuthorizationHelper;
import ru.iteco.fmhandroid.test.helper.MainHelper;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    AuthorizationHelper authStep = new AuthorizationHelper();
    MainHelper mainSteps = new MainHelper();
    AboutPage aboutPageSteps = new AboutPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);



    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();
        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        authStep.login(validLogin, validPassword);

    }


    @Test
    public void checkPrivatePolicy() {
        mainSteps.goToAbout();
        aboutPageSteps.linkPrivacyPolicy();
    }

    @Test
    public void checkLinkUse() {
        mainSteps.goToAbout();
        aboutPageSteps.linkTermsOfUse();

    }
}
