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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuPageTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @BeforeEach
    protected void onSetUp() {
        MenuPage frame = GuiActionRunner.execute(() -> new MenuPage(UserServices.getUserInfo("tadas", "sadat"), 1, "Vilnius, Zirmunu g. 12"));
        window = new FrameFixture(frame);
        window.show();
    }


    @Test
    public void addsubtractAmountTest() {
        window.label("costLabel").requireText("Suma: 0.00");
        window.label("„Copycat Pink“ gerimasamountLabel").requireText("0");

        window.button("„Copycat Pink“ gerimas+").click();

        window.label("costLabel").requireText("Suma: 2.00");
        window.label("„Copycat Pink“ gerimasamountLabel").requireText("1");

        window.button("„Copycat Pink“ gerimas-").click();

        window.label("costLabel").requireText("Suma: 0.00");
        window.label("„Copycat Pink“ gerimasamountLabel").requireText("0");

    }

    @Test
    public void backButtonTest() {
        window.button("backButton").click();
        assertTrue(Arrays.stream(Window.getWindows())
                .filter(Window::isVisible)
                .anyMatch(window -> window instanceof JFrame && ((JFrame) window).getTitle().equals("Restaurants Page")));

    }

    @AfterEach
    void tearDownEach() {
        if (window != null) {
            window.cleanUp();
        }
    }
}