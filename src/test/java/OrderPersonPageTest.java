import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


@RunWith(Parameterized.class)
public class OrderPersonPageTest {
    private final String testType;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String telephone;
    private final boolean errorInput;
    private final boolean metroResult;

    public OrderPersonPageTest(String testType, String name, String surname, String address, String metro, String telephone, boolean errorInput, boolean metroResult) {
        this.testType = testType;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.telephone = telephone;
        this.errorInput = errorInput;
        this.metroResult = metroResult;
    }

    private OrderPersonPage objOrderPage;
    private WebDriver driver = new ChromeDriver();
    //   private WebDriver driver = new FirefoxDriver();

    @Parameterized.Parameters(name = "{index} [{0}] Имя={1}, Фамилия={2}, Адрес={3}, Метро={4}, Телефон={5}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Positive", "Ванька", "Жуков", "На деревню дедушке", "Чеховская", "18863542512", false, true},
                {"Negative", "Пётр 1", "The Great", "Русь", "Адмиралтейская", "-", true, false},
        };
    }

    @Before
    public void openSite() {
        objOrderPage = new OrderPersonPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    @Test
    public void nameTest(){
        assertFalse(objOrderPage.enterName(name));
    }

    @Test
    public void surnameTest(){
        assertFalse(objOrderPage.enterSurname(surname));
    }

    @Test
    public void addressTest(){
        assertFalse(objOrderPage.enterAddress(address));
    }

    @Test
    public void metroStationTest() {
        By metroFilled = objOrderPage.enterMetro(metro);
        assertTrue(metroResult == driver.findElement(metroFilled).getAttribute("class").contains("Order_Filled"));
    }

    @Test
    public void telephoneTest(){
        assertFalse(objOrderPage.enterTelephone(telephone));
    }

    @Test
    public void allTests() {
        nameTest();
        surnameTest();
        addressTest();
        metroStationTest();
        telephoneTest();
    }

    @After
    public void killDriver() {
        driver.quit();
    }
}