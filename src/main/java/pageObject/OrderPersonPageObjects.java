package pageObject;

import org.openqa.selenium.By;

public class OrderPersonPageObjects {

    // поля для заполнения заказа
    public static By nameInput = By.cssSelector("input[placeholder='* Имя']"); //имя
    public static By surnameInput = By.cssSelector("input[placeholder='* Фамилия']");  //фамилия
    public static By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");    //адрес доставки
    public static By metroInput = By.xpath(".//input[@class='select-search__input']");  //станция метро
    public static By metroFilled = By.xpath(".//input[@placeholder='* Станция метро']/parent::div/parent::div/parent::div");   //индикатор выбранного поля
    public static By telephoneInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");   //номер телефона
    public static By errorInput = By.xpath(".//div[contains(@class,'Order_Form')]//div[contains(@class,'ErrorMessage') and contains(@class,'Input_Visible')]");   //индикатор неверно заполненного поля

    public static By nextButton = By.xpath(".//button[contains(@class,'Button_Button') and contains(@class,'Button_Middle')]");    //кнопка перехода на следующий этап заказа
}
