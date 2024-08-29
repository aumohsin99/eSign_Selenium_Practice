import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    private WebDriver driver;
    private WebDriverWait wait;

    private By currentDayLocator = By.id("currentDay");
    private By lastMonthLocator = By.id("lastMonth");
    //private By totalSessions = By.
    //
    // name()
    //private URLofPage =


    public Dashboard(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10)); // Initialize WebDriverWait

    }

    public String GetDashboardURL()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentDayLocator));
        return driver.getCurrentUrl();
        //return
    }


}
