import pageObject.MainPageObjects;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFAQ(int i) {
        driver.findElement(MainPageObjects.questions[i]).click();
    }

    public boolean checkAnswer(int i) {
        return driver.findElement((MainPageObjects.answers[i])).isDisplayed();
    }

    //в зависимости от значения (0; 1) клик на верхнюю или нижнюю кнопки Заказать.
    //int вместо boolean выбран сознательно на случай добавления новых кнопок в будущем
    public void clickOrder(int button) {
        if(button == 0) {
            driver.findElement(MainPageObjects.orderButtonTop).click();
        } else if(button == 1){
            driver.findElement(MainPageObjects.orderButtonBottom).click();
        }
    }
}
