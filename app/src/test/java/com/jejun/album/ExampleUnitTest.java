package com.jejun.album;

import com.jejun.album.object.Album;
import com.jejun.album.user.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class MyClassTest {

        @Rule
        public ActivityTestRule<Album> mActivityRule = new ActivityTestRule(LoginActivity.class);

        @Test
        public void myClassMethod_ReturnsTrue() { }
    }
}