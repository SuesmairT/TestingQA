import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name") //1234A@mail.com
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorButton;

    public void enterValueToUsername(String usernameValue) {
        usernameInputField.sendKeys(usernameValue);
    }

    public void enterValueToPasswordInputField(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnTheLoginButton(){
        loginButton.click();
    }

    public String getErrorMessageText(){
        return errorButton.getText();
    }

    public boolean usernameInputFiledIsDisplayed(){
        return usernameInputField.isDisplayed();
    }

}