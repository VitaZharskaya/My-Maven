package Utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class UsefulMethods {

    //РАНДОМАЙЗЕРЫ
    public static String getRandomStr(int length) {
        return RandomStringUtils.random(length,
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    //пример константы с рандомайзером
    private static final String PROJECT_NAME = RandomStringUtils.randomAlphanumeric(8);//возможно это чужая библиотека, нужно проверить или найти другой рандомайзер


    // СКРОЛЛ элемента до конца страницы
    public static void scrollToEnd(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //скролл до определенного элемента
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //для вейтера. Когда элемент уже виден, но все еще скроллится и селениум не успевает на него нажать из-за скролла
    //прописываем метод, который ждет пока скролл остановится, и только потом ищет элемент
    // пример использования getWait(5).until(TestUtils.ExpectedConditions.elementIsNotMoving(By element));

    public static class ExpectedConditions {
        public static ExpectedCondition<WebElement> elementIsNotMoving(final By locator) {
            return new ExpectedCondition<>() {
                private Point location = null;

                @Override
                public WebElement apply(WebDriver driver) {
                    WebElement element;
                    try {
                        element = driver.findElement(locator);
                    } catch (NoSuchElementException e) {
                        return null;
                    }

                    if (element.isDisplayed()) {
                        Point location = element.getLocation();
                        if (location.equals(this.location)) {
                            return element;
                        }
                        this.location = location;
                    }

                    return null;
                }
            };
        }
    }

    // ВЕЙТЕР от Сергея Демьяненко
    private WebDriver driver;
    private Map<Integer, WebDriverWait> waitMap = new HashMap<>();
    protected WebDriverWait getWait(int seconds) {
        return waitMap.computeIfAbsent(seconds, duration -> new WebDriverWait(driver, Duration.ofSeconds(duration)));
    }

    //обычный эксплисит вейтер
    private WebDriverWait wait;  //переменная
    protected WebDriverWait getWaitExample() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));  //прописывается непосредственно в тесте
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text() = 'Rename']"))).click();
        return null; // return не нужен, внутри класса пример. Использонать отдельно от метода
    }

    // отложенная инициализация (элемент создается только в том случае, если его нет. Если есть, то вызывается уже созданный
    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return wait;
    }
}
