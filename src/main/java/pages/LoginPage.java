package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "login_logo")
	private WebElement loginLogo;
	
	@FindBy(id = "user-name")
	private WebElement userNameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	@FindBy(tagName =   "h3")
	private WebElement warningMsg;
	
	public void enterUsername(String username) {
		userNameField.clear();
		userNameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}

	public String getLoginWarningMessage() {
		return warningMsg.getText();
	}
	
	public boolean loginLogoIsDisplayed() {
		return loginLogo.isDisplayed();
	}
}
