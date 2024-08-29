//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest
{
    private WebDriver driver;
    private LoginScreen loginPage;
    private Sessions sessionsPage;

    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\OneDrive - PERSEUS MANAGEMENT GROUP INC\\Training\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://abb2.qa.esignonline.net/Account/Login");
        driver.manage().window().maximize();
        loginPage = new LoginScreen(driver);
        sessionsPage = new Sessions(driver);
    }

    @Test
    public void LogintoeSign()
    {
        loginPage.enterUsername("ata.mohsin@constellation1.com");
        loginPage.enterPassword("Welcome123");
        loginPage.clickLoginButton();

        String actualURL = sessionsPage.getURLofHomePage();
        String expectedHomePageURL = "https://abb2.qa.esignonline.net/Session/Index";
        Assert.assertTrue(actualURL.startsWith(expectedHomePageURL));
    }

    @Test
    public void ValidateCorrectUserName()
    {
        LogintoeSign();
        boolean loginTestCasePassed = false;

            String actualUserName = sessionsPage.getUserName();
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WelcomeStatement")));
            String expectedUser = "Ata Ul Mohsin";
            Assert.assertEquals(actualUserName, expectedUser);
    }

    @Test
    public void SessiontoHomePageDirectionTest()
    {
        LogintoeSign();
        sessionsPage.GotoHomePagefromBreadCrumb();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}