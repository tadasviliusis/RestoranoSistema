package presentation;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationPageTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        RegistrationPage frame = GuiActionRunner.execute(() -> new RegistrationPage());
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void emptyFieldTest() throws InterruptedException {
        window.button("registerButton").click();
        window.label("emptyFieldError").requireVisible();
    }

    @Test
    public void tlNumberFieldErrorTest() {
        window.button("registerButton").click();
        window.label("tlNumberError").requireVisible();
    }

    @Test
    public void emailFieldErrorTest() {
        window.button("registerButton").click();
        window.label("emailError").requireVisible();
    }

    @Test
    public void loginErrorTest() {
        window.textBox("nameField").enterText("tadas");
        window.button("registerButton").click();
        window.label("loginError").requireVisible();
    }

    @Test
    public void passwordErrorTest() {
        window.textBox("passwordField").enterText("tadas");
        window.textBox("passwordConfirmField").enterText("sadat");
        window.button("registerButton").click();
        window.label("passwordError").requireVisible();
    }

    @Test
    public void backButtonTest() {
        window.button("backButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Login Page")));

    }

    @AfterEach
    void tearDownEach() {
        if (window != null) {
            window.cleanUp();
        }
    }
}
