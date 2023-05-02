package pageObject;

import org.openqa.selenium.By;

public class OrderRentPageObjects {

    //элементы ввода даты
    public static By dateInput = By.cssSelector("input[placeholder='* Когда привезти самокат']");   //поле ввода
    public static By currentDateButton = By.xpath(".//div[@tabindex=0 and contains(@class,'react-datepicker__day--selected')]");    //ячейка текущей даты в календаре
    public static By previousMonthButton = By.xpath(".//button[@aria-label='Previous Month']");

    //элементы поля срока аренды
    public static By rentPeriodInput = By.xpath(".//div[@class='Dropdown-placeholder']");
    private static By rent1Day = By.xpath(".//div[text()='сутки']");
    private static By rent2Day = By.xpath(".//div[text()='двое суток']");
    private static By rent3Day = By.xpath(".//div[text()='трое суток']");
    private static By rent4Day = By.xpath(".//div[text()='четверо суток']");
    private static By rent5Day = By.xpath(".//div[text()='пятеро суток']");
    private static By rent6Day = By.xpath(".//div[text()='шестеро суток']");
    private static By rent7Day = By.xpath(".//div[text()='семеро суток']");

    public static By[] rentList = {rent1Day, rent2Day, rent3Day, rent4Day, rent5Day, rent6Day, rent7Day};

    //цвет самоката
    private static By blackColorButton = By.id("black");
    private static By greyColorButton = By.id("grey");
    public static By[] colorList = {blackColorButton, greyColorButton};

    //поле для комментария
    public static By commentInput = By.cssSelector("input[placeholder='Комментарий для курьера']");

    //кнопки
    public static By backButton = By.linkText("Назад");
    public static By orderButtonBottom = By.xpath(".//button[text()='Заказать' and parent::div[contains(@class,'Order_Buttons')]]");
    public static By noButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[text()='Нет']");
    public static By yesButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[text()='Да']");

    public static By orderMessage = By.xpath(".//div[contains(@class,'Order_Text')]");
    public static By orderButton = By.xpath(".//button[text()='Посмотреть статус']");
}
