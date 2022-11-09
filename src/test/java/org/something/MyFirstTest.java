package org.something;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {
    static {
        WebDriverManager.chromedriver ().setup ();
    }
    private WebDriver driver;

    @Test
    public void testExpedia() throws InterruptedException {
        driver.get ("https://www.expedia.com/");
        driver.findElement(By.xpath("//span[text()='Flights']")).click();
        Thread.sleep (3000);
        Assert.assertEquals(driver.getTitle(), "Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More");
    }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver ();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit ();
    }
}