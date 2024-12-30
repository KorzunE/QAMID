package ru.iteco.fmhandroid.test.tests;


import static ru.iteco.fmhandroid.test.page.Data.changeDescription;
import static ru.iteco.fmhandroid.test.page.Data.description;
import static ru.iteco.fmhandroid.test.page.Data.NameForChangeActive;
import static ru.iteco.fmhandroid.test.page.Data.NameForCreate;
import static ru.iteco.fmhandroid.test.page.Data.NameForDelete;
import static ru.iteco.fmhandroid.test.page.Data.NameForEdit;
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
import ru.iteco.fmhandroid.test.helper.ControlPageHelp;
import ru.iteco.fmhandroid.test.helper.MainHelper;
import ru.iteco.fmhandroid.test.helper.NewsHelper;

@RunWith(AllureAndroidJUnit4.class)
public class ControlTest {
    AuthorizationHelper authStep = new AuthorizationHelper();
    MainHelper mainSteps = new MainHelper();
    NewsHelper newsSteps = new NewsHelper();
    ControlPageHelp controlPanelSteps = new ControlPageHelp();
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
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    private View decorView;

    @Test
    public void createNews() {
        mainSteps.goToNews();
        newsSteps.clickEditNews();
        controlPanelSteps.clickCreateNews();
        controlPanelSteps.fillFieldsNews(description, NameForCreate);
        controlPanelSteps.clickDeleteNews(NameForCreate);

    }

    @Test
    public void deleteNews() {
        mainSteps.goToNews();
        newsSteps.clickEditNews();
        controlPanelSteps.clickCreateNews();
        controlPanelSteps.fillFieldsNews(description, NameForDelete);
        controlPanelSteps.clickDeleteNews(NameForDelete);
    }


    @Test
    public void editNews() {
        mainSteps.goToNews();
        newsSteps.clickEditNews();
        controlPanelSteps.clickCreateNews();
        controlPanelSteps.fillFieldsNews(description, NameForEdit);
        controlPanelSteps.clickEditButton(NameForEdit);
        controlPanelSteps.editCreatedNews(changeDescription);
        controlPanelSteps.clickDeleteNews(NameForEdit);
    }
    @Test
    public void changeStatus() {
        mainSteps.goToNews();
        newsSteps.clickEditNews();
        controlPanelSteps.clickCreateNews();
        controlPanelSteps.fillFieldsNews(description, NameForChangeActive);
        controlPanelSteps.clickEditButton(NameForChangeActive);
        controlPanelSteps.clickSwitch();
        controlPanelSteps.clickDeleteNews(NameForChangeActive);

    }

    @Test
    public void createEmptyNews() {
        mainSteps.goToNews();
        newsSteps.clickEditNews();
        controlPanelSteps.clickCreateNews();
        controlPanelSteps.fillNewsCategoryEmpty(description, NameForCreate);
        controlPanelSteps.checkInformationMessageEmptyCategory("Fill empty fields", decorView);

    }

}