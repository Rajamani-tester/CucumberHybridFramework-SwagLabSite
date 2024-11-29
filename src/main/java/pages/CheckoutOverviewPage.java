package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class CheckoutOverviewPage {
	
WebDriver driver;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "inventory_item_name")
	private List<WebElement> productNames;
	
	@FindBy (className = "inventory_item_price")
	private List<WebElement> productPrices;
	
	@FindBy (className = "subheader")
	private WebElement checkoutOverviewHeading;
	
	@FindBy (linkText = "FINISH")
	private WebElement finishButton;
	
	public String getCheckoutOverviewHeading() {
		return checkoutOverviewHeading.getText();
	}
	
	public String getProductName() {
		return productNames.get(0).getText();
	}
	
	public Double getProductPrice() {
		return CommonUtils.getProductPrice(productPrices);
	}
	
	public int getNoOfProduct() {
		return productNames.size();
	}
	
	public void clickOnFinishButton() {
		finishButton.click();
	}

}
