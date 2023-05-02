import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.MainPageObjects;
import pageObject.OrderPersonPageObjects;

import static org.junit.Assert.assertTrue;

public class MainPageTest {

    private WebDriver driver = new ChromeDriver();
    //   private WebDriver driver = new FirefoxDriver();
    private MainPage objMainPage;

    @Before
    public void openSite() {
        objMainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.id("rcc-confirm-button")).click();
    }

    @Test
    public void FAQTest() {
        for (int i = 0; i < MainPageObjects.questions.length; i++) {
            objMainPage.clickFAQ(i);
            assertTrue(objMainPage.checkAnswer(i));
        }
    }

    @Test
    public void orderButtonTest() {
        for (int i = 0; i < 2; i++) {
            objMainPage.clickOrder(i);   //i = 0 - проверка верхней кнопки Заказать, i = 1 - проверка нижней кнопки Заказать
            assertTrue(driver.findElement(OrderPersonPageObjects.orderSection).getAttribute("class").contains("Order_Header"));
            driver.findElement(MainPageObjects.samokatLogo).click();
        }
    }

    @Test
    public void allTests() {
        FAQTest();
        orderButtonTest();
    }

    @After
    public void killDriver() {
        driver.quit();
    }
}
