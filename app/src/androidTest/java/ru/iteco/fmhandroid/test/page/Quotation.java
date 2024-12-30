package ru.iteco.fmhandroid.test.page;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class Quotation {
    public ViewInteraction pageOfQuotation = onView(withId(R.id.our_mission_title_text_view));
}
