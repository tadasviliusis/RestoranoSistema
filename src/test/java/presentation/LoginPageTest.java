package presentation;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.core.matcher.DialogMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginPageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        LoginPage frame = GuiActionRunner.execute(() -> new LoginPage());
        window = new FrameFixture(frame);
        window.show();
    }



    @Test
    public void failedLoginTest() {
        window.textBox("nameField").enterText("login");
        window.textBox("passwordField").enterText("nigol");
        window.button("loginButton").click();
        window.label("errorLabel").requireVisible();
    }

    @Test
    public void successLoginTest() {

        window.textBox("nameField").enterText("tadas");
        window.textBox("passwordField").enterText("sadat");
        window.button("loginButton").click();

        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Main Page")));

    }


    @AfterEach
    void tearDownEach() {
        if (window != null) {
            window.cleanUp();
        }
    }
}