package model.services;

import model.modules.ClientOrder;
import model.modules.FoodOrder;
import model.modules.Menu;
import model.modules.Restaurant;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserServicesTest {

    @Test
    public void checkLogInCredentialsErrorTest() throws SQLException {
        assertFalse(UserServices.checkLogInCredentials("login", "login"));
    }

    @Test
    public void checkLogInCredentialsPassTest() throws SQLException {
        assertTrue(UserServices.checkLogInCredentials("tadas", "sadat"));
    }

    @Test
    public void getAllLoginNamesTest() throws SQLException {
        List<String> loginNames = UserServices.getAllLoginNames();
        assertTrue(loginNames.size() > 0);
        for (String name : loginNames)
            assertFalse(name.equals(""));
    }

    @Test
    public void getUserInfoTest() throws SQLException {
        Map<String, Object> userInfo = UserServices.getUserInfo("tadas", "sadat");

        assertTrue(userInfo.get("ID").equals(9));
        assertTrue(userInfo.get("vardas").equals("Tadas"));
        assertTrue(userInfo.get("pavarde").equals("Viliusis"));
        assertTrue(userInfo.get("tl.numeris").equals("+37067896210"));
        assertTrue(userInfo.get("el.pastas").equals("tadas.viliusis@gmail.com"));
        assertTrue(userInfo.get("adresas").equals("Vilnius, Parko g.56"));
    }


    @Test
    public void getLoginInfoTest() throws SQLException {
        Map<String, Object> userInfo = UserServices.getLoginInfo("9");

        assertTrue(userInfo.get("ID").equals(5));
        assertTrue(userInfo.get("login").equals("tadas"));
        assertTrue(userInfo.get("password").equals("sadat"));
    }
}