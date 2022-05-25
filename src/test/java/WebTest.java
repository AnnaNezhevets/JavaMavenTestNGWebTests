import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void testIsThereSubmitNewLanguageOnlastLink(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
           By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        String actualResult = submitNewLanguage.getText();

      Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testIsThereSubmitNewLanguageName() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        submitNewLanguage.click();

        WebElement subMenuSubmitNewLanguage = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
        );

        String actualResult = subMenuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testFirstPointOfMenu0_9() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement subMenuFirstSymbol = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));
        String actualResult = subMenuFirstSymbol.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    @Test
    public void testTeamOfWebsite90(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";
        String[] expectedResultAuthors = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuTeam = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));

        submenuTeam.click();

        WebElement h3OliverSchade = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3"));
        h3OliverSchade.getText();

        WebElement h3GregorScheithauer = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));
        h3GregorScheithauer.getText();

        WebElement h3StefanScheler = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));
        h3StefanScheler.getText();

        String[] actualResult = new String[]
                {h3OliverSchade.getText(), h3GregorScheithauer.getText(), h3StefanScheler.getText()};

        Assert.assertEquals(actualResult, expectedResultAuthors);

        driver.quit();
       }
    }





