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

class OrderPageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        OrderPage frame = GuiActionRunner.execute(() -> new OrderPage(UserServices.getUserInfo("tadas", "sadat")));
        window = new FrameFixture(frame);
        window.show();
    }


    @Test
    public void backButtonTest() {
        window.button("orderFoodButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Restaurants Page")));

    }

    @Test
    public void orderButtonTest() {
        window.button("cancelButton").click();
        System.out.println();
        Window[] windows = Window.getWindows();
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