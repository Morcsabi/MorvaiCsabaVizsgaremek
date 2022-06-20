import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {

    WebDriver driver;

    private final By regTabButton = By.id("register-form-button");
    private final By regUsernameTextField = By.id("register-username");
    private final By regPasswordTextField = By.id("register-password");
    private final By regEmailTextField = By.id("register-email");
    private final By regButton = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    private final By regAlert = By.id("register-alert");

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegTab(){
        driver.findElement(regTabButton).click();
    }

    public void sendUsername(String username){
        driver.findElement(regUsernameTextField).sendKeys(username);

    }
    public void sendPassword(String password){
        driver.findElement(regPasswordTextField).sendKeys(password);
    }

    public void sendEmail(String email){
        driver.findElement(regEmailTextField).sendKeys(email);
    }
    public void clickRegButton(){
        driver.findElement(regButton).click();
    }

    public String getRegAlertText(){

        String regText = driver.findElement(regAlert).getText();

        return regText;
    }
}
