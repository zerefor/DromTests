import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import java.net.URISyntaxException;

public class SortingTest {
    private WebDriver driver;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        String url = "https://auto.drom.ru";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void formQA() throws InterruptedException, URISyntaxException {
        WebElement advancedFilterButton = driver.findElement(By.cssSelector("[class='css-1hfjy5z eakkndi0']:first-child"));
        advancedFilterButton.click();

        WebElement checkBoxUnsold = driver.findElement(By.cssSelector("[for='sales__filter_unsold']"));
        checkBoxUnsold.click();

        WebElement mileageArea = driver.findElement(By.cssSelector("[placeholder='от, км']"));
        mileageArea.sendKeys("1000");

        WebElement stampPlaceholder = driver.findElement(By.cssSelector("[placeholder='Марка']"));
        stampPlaceholder.click();
        stampPlaceholder.sendKeys("Toyota");
        Thread.sleep(1000);
        WebElement stampChoose = driver.findElement(By.cssSelector("[aria-label='Марка']"));
        stampChoose.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement modelPlaceholder = driver.findElement(By.cssSelector("[placeholder='Модель']"));
        modelPlaceholder.click();
        modelPlaceholder.sendKeys("Harrier");
        Thread.sleep(1000);
        WebElement modelChoose = driver.findElement(By.cssSelector("[aria-label='Модель']"));
        modelChoose.sendKeys(Keys.ENTER);
    }

    @AfterEach
    public void end() {
        driver.quit();
    }
}