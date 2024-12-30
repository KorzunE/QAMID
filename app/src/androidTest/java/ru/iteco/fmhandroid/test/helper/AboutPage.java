package ru.iteco.fmhandroid.test.helper;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.test.page.About;

public class AboutPage {
    About aboutPage = new About();

    public void linkPrivacyPolicy() {
        aboutPage.linkPrivacyPolicyLink.check(matches(isDisplayed()));
        aboutPage.linkPrivacyPolicyLink.perform(click());
        aboutPage.policyInformation.check(matches(isDisplayed()));
    }

    public void linkTermsOfUse() {
        aboutPage.linkTermsOfUseLink.check(matches(isDisplayed()));
        aboutPage.linkTermsOfUseLink.perform(click());
        aboutPage.termsInformation.check(matches(isDisplayed()));
    }


}