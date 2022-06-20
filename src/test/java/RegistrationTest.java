import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    WebDriver driver;

    @BeforeEach
    public void Setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @BeforeEach
    public void navigateAndAcceptTerms(){
        PageBase roxoPageBase = new PageBase(driver);
        roxoPageBase.navigate();
        roxoPageBase.clickAcceptTerms();
    }

    @AfterEach
    public void quit()
    {
        driver.close();
        driver.quit();
    }

    @Test
    public void validLoginTest() {


        String username = "bobo";
        String password = "bobopass";
        String email = "bobo@bobo.com";
        Registration registration = new Registration(driver);
        registration.clickRegTab();
        registration.sendUsername(username);
        registration.sendPassword(password);
        registration.sendEmail(email);
        registration.clickRegButton();
        String actual = registration.getRegAlertText();

        Assertions.assertEquals("User registered!", actual);
    }

    @Test
    public void loginWithoutEmail(){
        String username = "bobo";
        String password = "bobopass";
        Registration registration = new Registration(driver);
        registration.clickRegTab();
        registration.sendUsername(username);
        registration.sendPassword(password);
        registration.clickRegButton();
        String actual = registration.getRegAlertText();

        Assertions.assertEquals("User registered!", actual);


    }
}
