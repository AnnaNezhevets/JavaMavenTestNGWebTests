import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartPageTest {

    @Test
    public void testStartPage(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement nameWebSite = driver.findElement(By.xpath("//body/div[@id ='wrap']/div[@id = 'header']/h1"));
        String actualResult = nameWebSite.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
