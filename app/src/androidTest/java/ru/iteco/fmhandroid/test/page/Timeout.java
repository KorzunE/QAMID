package ru.iteco.fmhandroid.test.page;

import android.os.SystemClock;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeoutException;

public class Timeout {
    private  final int SLEEP_IN_A_LOOP_TIME = 1000;

    public  class TimedViewInteraction {

        private final ViewInteraction wrappedViewInteraction;

        public TimedViewInteraction(ViewInteraction wrappedViewInteraction) {
            this.wrappedViewInteraction = wrappedViewInteraction;
        }


        public TimedViewInteraction perform(final ViewAction... viewActions) {
            wrappedViewInteraction.perform(viewActions);
            return this;
        }
    }

    public  TimedViewInteraction onViewWithTimeout(long timeoutInMillis, @NonNull final Matcher<View> viewMatcher) {

        final long startTime = System.currentTimeMillis();
        final long endTime = startTime + timeoutInMillis;

        do {
            try {
                return new TimedViewInteraction(Espresso.onView(viewMatcher));
            } catch (Exception ex) {
            }

            SystemClock.sleep(SLEEP_IN_A_LOOP_TIME);
        }
        while (System.currentTimeMillis() < endTime);

        throw new PerformException.Builder()
                .withCause(new TimeoutException("Timeout occurred when trying to find: " + viewMatcher.toString()))
                .build();
    }
}
