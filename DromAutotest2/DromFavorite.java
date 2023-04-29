import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import java.net.URISyntaxException;


public class DromFavorite {
    private WebDriver driver;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = "https://www.drom.ru";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void formQA() throws InterruptedException, URISyntaxException {
        WebElement loginEnter = driver.findElement(By.cssSelector("[class='css-1h9spzo e1k6fwrt0']"));
        loginEnter.click();

        WebElement loginField = driver.findElement(By.cssSelector("[id='sign']"));
        loginField.sendKeys("dromtest");

        WebElement passwordField = driver.findElement(By.cssSelector("[id='password']"));
        passwordField.sendKeys("dromtest1");

        WebElement signButton = driver.findElement(By.cssSelector("[id='signbutton']"));
        signButton.click();

        WebElement transportUrl = driver.findElement(By.cssSelector("[data-ga-stats-name='topmenu_sales']"));
        transportUrl.click();

        WebElement transportButton = driver.findElement(By.cssSelector("a[class='css-xb5nz8 e1huvdhj1']:first-child"));
        transportButton.click();

        WebElement favorite = driver.findElement(By.cssSelector("[data-ftid='bull-page_bull-actions_favorite']"));
        favorite.click();
        Thread.sleep(2000);
    }

    @AfterEach
    public void end() {
        driver.quit();
    }
}