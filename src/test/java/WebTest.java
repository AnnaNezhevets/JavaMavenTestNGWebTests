import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class WebTest {

    @Test
    public void testMenuStartTitle(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );

        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/']"));

        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

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
