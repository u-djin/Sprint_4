package pageObject;

import org.openqa.selenium.By;

public class MainPageObjects {

    // вопросы FAQ
    private static By quest_0 = By.id("accordion__heading-0");
    private static By quest_1 = By.id("accordion__heading-1");
    private static By quest_2 = By.id("accordion__heading-2");
    private static By quest_3 = By.id("accordion__heading-3");
    private static By quest_4 = By.id("accordion__heading-4");
    private static By quest_5 = By.id("accordion__heading-5");
    private static By quest_6 = By.id("accordion__heading-6");
    private static By quest_7 = By.id("accordion__heading-7");

    public static By[] questions = {quest_0, quest_1, quest_2, quest_3, quest_4, quest_5, quest_6, quest_7};

    //ответы FAQ
    private static By answ_0 = By.id("accordion__panel-0");
    private static By answ_1 = By.id("accordion__panel-1");
    private static By answ_2 = By.id("accordion__panel-2");
    private static By answ_3 = By.id("accordion__panel-3");
    private static By answ_4 = By.id("accordion__panel-4");
    private static By answ_5 = By.id("accordion__panel-5");
    private static By answ_6 = By.id("accordion__panel-6");
    private static By answ_7 = By.id("accordion__panel-7");

    public static By[] answers = {answ_0, answ_1, answ_2, answ_3, answ_4, answ_5, answ_6, answ_7};

    //кнопки newЗаказать
    public static By orderButtonTop = By.xpath(".//button[text()='Заказать' and parent::div[contains(@class,'Header')]]");
    public static By orderButtonBottom = By.xpath(".//button[text()='Заказать' and parent::div[contains(@class,'FinishButton')]]");

    //логотип Самоката
    public static By samokatLogo = By.cssSelector("img[alt='Scooter']");
}
