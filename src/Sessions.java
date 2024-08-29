import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sessions {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loggedInUserHeaderLocator = By.id("WelcomeStatement");
    private By loggedInUserNameLocator = By.tagName("strong");
    private By HomePageLinkLocator = By.partialLinkText("Home");

    public Sessions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    public String getUserName() {
        try
        {
            // Wait until the element is visible
            WebElement loggedInUserHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserHeaderLocator));
            WebElement loggedInUserName = loggedInUserHeader.findElement(loggedInUserNameLocator);
            return loggedInUserName.getText();
        }
        catch (Exception e)
        {
            // Print the stack trace for debugging
            e.printStackTrace();
            return null;
        }
    }

    public String getURLofHomePage()
    {
        WebElement loggedInUserHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserNameLocator));
        return driver.getCurrentUrl();
    }

    public void GotoHomePagefromBreadCrumb()
    {
     WebElement homePageLink = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLinkLocator));
     homePageLink.click();
    }
}
