import org.openqa.selenium.By;
import pageObject.OrderPersonPageObjects;
import org.openqa.selenium.WebDriver;

public class OrderPersonPage {
    private WebDriver driver;

    public OrderPersonPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean enterName(String name) {
        driver.findElement(OrderPersonPageObjects.nameInput).sendKeys(name);
        try {
            driver.findElement(OrderPersonPageObjects.errorInput);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean enterSurname(String surname) {
        driver.findElement(OrderPersonPageObjects.surnameInput).sendKeys(surname);
        try {
            driver.findElement(OrderPersonPageObjects.errorInput);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean enterAddress(String address) {
        driver.findElement(OrderPersonPageObjects.addressInput).sendKeys(address);
        try {
            driver.findElement(OrderPersonPageObjects.errorInput);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public By enterMetro(String metro) {
        driver.findElement(OrderPersonPageObjects.metroInput).sendKeys(metro);
        try {
            driver.findElement(By.xpath(".//div[text()='" + metro + "']")).click();
        } catch (org.openqa.selenium.NoSuchElementException e) {}
        return OrderPersonPageObjects.metroFilled;
    }

    public boolean enterTelephone(String telephone) {
        driver.findElement(OrderPersonPageObjects.telephoneInput).sendKeys(telephone);
        try {
            driver.findElement(OrderPersonPageObjects.errorInput);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void pressNext() {
        driver.findElement(OrderPersonPageObjects.nextButton).click();
    }
}
