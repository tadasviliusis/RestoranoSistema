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

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainPageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        MainPage frame = GuiActionRunner.execute(() -> new MainPage(UserServices.getUserInfo("tadas", "sadat")));
        window = new FrameFixture(frame);
        window.show();
    }


    @Test
    public void orderButtonTest() {
        window.button("orderButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Order Page")));

    }

    @Test
    public void historyButtonTest() {
        window.button("historyButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Order History Page")));

    }

    @Test
    public void profileButtonTest() {
        window.button("profileButton").click();
        System.out.println();
        Window[] windows = Window.getWindows();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Profile Page")));

    }


    @AfterEach
    void tearDownEach() {
        if (window != null) {
            window.cleanUp();
        }
    }
}