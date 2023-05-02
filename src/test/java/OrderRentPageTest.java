import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.OrderPersonPageObjects;
import pageObject.OrderRentPageObjects;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderRentPageTest {
    private final String date;
    private final int rent;
    private final String colors;
    private final String comment;

    public OrderRentPageTest(String date, int rent, String colors, String comment) {
        this.date = date;
        this.rent = rent;
        this.colors = colors;
        this.comment = comment;
    }

    private OrderRentPage objRentPage;
    //private WebDriver driver = new ChromeDriver();
    private WebDriver driver = new FirefoxDriver();

    @Parameterized.Parameters(name = "{index} Дата={0}, Срок={1}, Цвет={2}, Комментарий={3}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {"08.05.2023", 2, "01", "без комментариев"},
                {"123fwftewt3t5", 7, "00", "с комментарием"},
                {"текст", 1, "11", ""},
                {"09.05.2024", 0, "10", ""}
        };
    }

    @Before
    public void openSite() {
        objRentPage = new OrderRentPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(OrderPersonPageObjects.nameInput).sendKeys("Янус");
        driver.findElement(OrderPersonPageObjects.surnameInput).sendKeys("Невструев");
        driver.findElement(OrderPersonPageObjects.addressInput).sendKeys("НИИЧаВо");
        driver.findElement(OrderPersonPageObjects.metroInput).sendKeys("Чистые пруды");
        driver.findElement(By.xpath(".//div[text()='Чистые пруды']")).click();
        driver.findElement(OrderPersonPageObjects.telephoneInput).sendKeys("1234567890123");
        driver.findElement(OrderPersonPageObjects.nextButton).click();
    }

    @Test
    public void dateTest() {
        assertTrue(objRentPage.enterDate(date));
    }

    @Test
    public void rentTest() {
        objRentPage.enterRent(rent);
    }

    @Test
    public void colorTest() {
        objRentPage.enterColor(colors);
    }

    @Test
    public void commentTest() {
        objRentPage.courierComment(comment);
    }

    @Test
    public void testAll() {
        dateTest();
        rentTest();
        colorTest();
        commentTest();
        driver.findElement(OrderRentPageObjects.orderButtonBottom).click();
        driver.findElement(OrderRentPageObjects.yesButton).click();
        assertTrue(driver.findElement(OrderRentPageObjects.orderMessage).getAttribute("class").contains("Order_Text"));
    }

    @After
    public void killDriver() {
        driver.quit();
    }
}