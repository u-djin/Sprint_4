import pageObject.OrderRentPageObjects;

import org.openqa.selenium.WebDriver;

public class OrderRentPage {
    private WebDriver driver;

    public OrderRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean enterDate(String date) {
        driver.findElement(OrderRentPageObjects.dateInput).sendKeys(date);
        try {
            driver.findElement(OrderRentPageObjects.currentDateButton).click();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void enterRent(int i) {
        driver.findElement(OrderRentPageObjects.rentPeriodInput).click();
        driver.findElement(OrderRentPageObjects.rentList[i - 1]).click();
    }

    public void enterColor(String chosenColors) {
        for(int i = 0; i < chosenColors.length(); i++) {
            if(Character.getNumericValue(chosenColors.toCharArray()[i]) == 1) {
                driver.findElement(OrderRentPageObjects.colorList[i]).click();
            }
        }
    }

    public void courierComment(String comment) {
        driver.findElement(OrderRentPageObjects.commentInput).sendKeys(comment);
    }
}
