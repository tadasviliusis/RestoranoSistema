package presentation;

import model.services.UserServices;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProfilePageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        ProfilePage frame = GuiActionRunner.execute(() -> new ProfilePage(UserServices.getUserInfo("tadas", "sadat")));
        window = new FrameFixture(frame);
        window.show();
    }


    @Test
    public void editButtonTest() {
        assertFalse(window.textBox("nameField").isEnabled());
        assertFalse(window.textBox("lastNameField").isEnabled());
        assertFalse(window.textBox("tlNumberField").isEnabled());
        assertFalse(window.textBox("addressField").isEnabled());
        assertFalse(window.textBox("emailField").isEnabled());

        window.button("editButton").click();

        assertTrue(window.textBox("nameField").isEnabled());
        assertTrue(window.textBox("lastNameField").isEnabled());
        assertTrue(window.textBox("tlNumberField").isEnabled());
        assertTrue(window.textBox("addressField").isEnabled());
        assertTrue(window.textBox("emailField").isEnabled());

        window.button("saveButton").click();

        assertFalse(window.textBox("nameField").isEnabled());
        assertFalse(window.textBox("lastNameField").isEnabled());
        assertFalse(window.textBox("tlNumberField").isEnabled());
        assertFalse(window.textBox("addressField").isEnabled());
        assertFalse(window.textBox("emailField").isEnabled());
    }

    @Test
    public void emptyFieldTest() {
        window.button("editButton").click();
        window.textBox("nameField").setText("");
        window.button("saveButton").click();
        window.label("emptyFieldError").requireVisible();
    }

    @Test
    public void emailErrorTest() {
        window.button("editButton").click();
        window.textBox("emailField").setText("");
        window.button("saveButton").click();
        window.label("emailError").requireVisible();
    }

    @Test
    public void tlNumberTest() {
        window.button("editButton").click();
        window.textBox("tlNumberField").setText("");
        window.button("saveButton").click();
        window.label("tlNumberError").requireVisible();
    }

    @Test
    public void backButtonTest() {
        window.button("backButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Main Page")));

    }

    @Test
    public void logOffButtonTest() {
        window.button("logOffButton").click();
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