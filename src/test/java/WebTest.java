import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.StyledEditorKit;

public class WebTest {

    public static final String URL = "https://www.99-bottles-of-beer.net/";

    @BeforeMethod
    public void beforeMethod(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/Пользователь/Downloads/chromedriver_win32/chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);
    }

    @Test
    public void testMenuStartTitle() {
        String expectedResult = "Welcome to 99 Bottles of Beer";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );

        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/']"));

        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//div[@id = 'main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    @Test
    public void testStartPage() {
       String expectedResult = "99 Bottles of Beer";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement nameWebSite = driver.findElement(By.xpath("//div[@id = 'header']/h1"));
        String actualResult = nameWebSite.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testIsThereSubmitNewLanguageOnlastLink() {
        String expectedResult = "Submit new Language";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        String actualResult = submitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testIsThereSubmitNewLanguageName() {
        String expectedResult = "Submit New Language";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        submitNewLanguage.click();

        WebElement subMenuSubmitNewLanguage = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = subMenuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testFirstPointOfMenu0_9() {
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement subMenuFirstSymbol = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));
        String actualResult = subMenuFirstSymbol.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testTeamOfWebsite90() {
        String[] expectedResultAuthors = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement submenuTeam = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));

        submenuTeam.click();

        WebElement h3OliverSchade = driver.findElement(By.xpath("//div[@id='main']/h3"));
        h3OliverSchade.getText();

        WebElement h3GregorScheithauer = driver.findElement(
                By.xpath("//div[@id='main']/h3[last()-1]"));
        h3GregorScheithauer.getText();

        WebElement h3StefanScheler = driver.findElement(By.xpath("//div[@id='main']/h3[last()]"));
        h3StefanScheler.getText();

        String[] actualResult = new String[]
                {h3OliverSchade.getText(), h3GregorScheithauer.getText(), h3StefanScheler.getText()};

        Assert.assertEquals(actualResult, expectedResultAuthors);

        driver.quit();
    }

    @Test
    public void testVerificationSubmitLanguage() {
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        ChromeDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//form[@id='addlanguage']//input[@type='submit']"));
        submitNewLanguage.click();

        WebElement actualResultError = driver.findElement(By.xpath("//div[@id='main']/p"));

        Assert.assertEquals(actualResultError.getText(), expectedResult);

        driver.quit();
    }

    @Test
    public void testValidationRequirenments() {
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        WebDriver driver = new ChromeDriver();

        driver.get(url);

       WebElement submitLanguage = driver.findElement(By.xpath("//form[@id='addlanguage']//input[@type='submit']"));

       submitLanguage.click();

        WebElement error = driver.findElement(By.xpath("//div[@id='main']/p"));
        error.getText();

        String newError = error.getText();

        if ((newError.contains(":")) && (newError.contains("-")) && (newError.contains("."))) {
            for (int i = 1; i < newError.length(); i++) {
                if (newError.charAt(i) == ' ')
                    newError = newError.substring(0, i + 1)
                            .concat(newError.substring(i + 1, i + 2).toUpperCase()).
                            concat(newError.substring(i + 2));
            }

            String actualResult = newError.replace('F', 'f');

            Assert.assertEquals(actualResult, expectedResult);
        }

        driver.quit();
    }

    @Test
    public void testValidationFistAndSecondNameOfColumns(){
        String[] expectedResultNameOfColumn = {"Language", "Author"};

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement browseLanguage = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));

        browseLanguage.click();

        WebElement language = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[@style='width: 40%;']"));

        WebElement author = driver.findElement(By.xpath("//table[@id='category']/tbody/tr/th[@style='width: 30%;']"));

        String[] actualResult = new String[] {language.getText(), author.getText()};

        Assert.assertEquals(actualResult, expectedResultNameOfColumn);

        driver.quit();
    }

    @Test
    public void testValidationEmptyComments(){
        String expectedResult = "";

        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        WebElement topList = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/toplist.html']"));

        topList.click();

        WebElement newComments = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='./newcomments.html']"));

        newComments.click();

        WebElement comments = driver.findElement(By.xpath("//div[@id='main']/p"));


        Assert.assertEquals(comments.getText(), expectedResult);

        driver.quit();
    }

    @Test
    public void testAttentionImportant(){
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT:";

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement important = driver.findElement(
                By.xpath("//div[@id='main']/ul/li/span[@style='background-color:red; color: white']/b"));

        String newImportant = important.getText().toUpperCase();
        if ((newImportant.contains("background-color:red; color: white")) && (newImportant.contains("b"))) {

            String actualResult = newImportant;

            Assert.assertEquals(actualResult, expectedResult);
        }


        driver.quit();
    }
}






