import pageObject.OrderRentPageObjects;

import org.openqa.selenium.WebDriver;

public class OrderRentPage {
    private WebDriver driver;

    public OrderRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //попытка задавать дату от текущей
    /*
    public boolean enterDate_1(int diff) {
        int currentDate = Integer.parseInt(driver.findElement(OrderRentPageObjects.currentDateButton).getText());
        driver.findElement(By.xpath(".//div[@tabindex='-1' and text()='" + Integer.toString(currentDate + diff) + "' and not(contains(@class,'day--outside-month'))]")).click();
    }   */


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

    //этот метод был написан в предположении, что выбирается ЖЕЛАЕМЫЙ цвет самоката.
    //в этом случае цвет должен был бы выбираться радиокнопками, а не чекбоксами, потому что требуется только один вариант
    //однако даже в DOM страницы соответствующий div имеет класс Order_Checkboxes, так что чекбоксы были выбраны намеренно
    //поэтому я решил, что в заказе укзываются ДОПУСТИМЫЕ цвета и самокат будет одного из выбранных цветов
    //метод решил не удалять, а закомментировать, раз уже написал
    /*
    public boolean enterColor(int i) {
        boolean radiobuttonCheck;
        for(int j = 0; j < OrderRentPageObjects.colorList.length; j++) {
            driver.findElement(OrderRentPageObjects.colorList[j]).click();
        }
        driver.findElement(OrderRentPageObjects.colorList[OrderRentPageObjects.colorList.length - 1]).click();
        try {
            driver.findElement(OrderRentPageObjects.colorIsChosen);
            radiobuttonCheck = false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            radiobuttonCheck = true;
        }
        driver.findElement(OrderRentPageObjects.colorList[i]).click();
        return  radiobuttonCheck;
    }   */

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
