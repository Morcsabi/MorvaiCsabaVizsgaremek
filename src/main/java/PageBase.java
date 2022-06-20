import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {


    WebDriver driver;

    private final String url = "https://lennertamas.github.io/roxo/";
    private final By acceptTerms = By.id("terms-and-conditions-button");
    private final By closeTerms = By.className("CloseIcon");
    private final By overlayOnLandingPage = By.id("overlay");


    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.get(url);
    }

    public void clickAcceptTerms() {
        driver.findElement(acceptTerms).click();
    }

    public void clickCloseTerms() {
        driver.findElement(closeTerms).click();
    }

    public String getOverlayStyle() {

        String overlayStyle = driver.findElement(overlayOnLandingPage).getAttribute("style");

        return overlayStyle;
    }
}
