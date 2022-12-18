import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {
    static {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testStaticDropDown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

            for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
            }
        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");



//        dropdown.getFirstSelectedOption().getText();
//        dropdown.selectByVisibleText("AED");
//        dropdown.selectByValue("INR");
    }
//
//    @Test
//    public void testDropdown() {
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        driver.findElement(By.id("divpaxinfo")).click();
//        driver.findElement(By.id("hrefIncAdt")).click();
//        driver.findElement(By.id("btnclosepaxoption")).click();
//
//    }

    @Test
    public void AutoSuggestiveDropdown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option: options) {
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }

    }
}
