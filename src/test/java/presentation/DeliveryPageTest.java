package presentation;

import model.modules.FoodOrder;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeliveryPageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        DeliveryPage frame = GuiActionRunner.execute(() ->
                new DeliveryPage(
                        UserServices.getUserInfo("tadas", "sadat"),
                1,
                        List.of(new FoodOrder(1, "DRINK", 1, 2)), "RESTAURANT")
        );
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void backButtonTest() {
        window.button("backButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Menu Page")));

    }

    @Test
    public void proceedButtonTest() {
        window.button("proceedButton").click();

        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Checkout Page")));

    }

    @AfterEach
    void tearDownEach() {
        if (window != null) {
            window.cleanUp();
        }
    }
}