import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {

    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameLocator = By.id("UserName");
    private By passwordLocator = By.id("Password");
    private By signinButtonLocator = By.id("login-button");

    // Constructor
    public LoginScreen(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    // Actions
    public void enterUsername(String usernameValue) {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        username.clear(); // Clear the field before entering text
        username.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        password.clear(); // Clear the field before entering text
        password.sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        WebElement signinButton = wait.until(ExpectedConditions.elementToBeClickable(signinButtonLocator));
        signinButton.click();
    }
}
