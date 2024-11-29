package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className  = "product_label")
	private WebElement productPageHeading;
	
	@FindBy (className = "inventory_item_name")
	private List<WebElement> productElements;
	
	@FindBy (className = "inventory_item_price")
	private List<WebElement> priceElements;
	
	@FindBy (xpath = "//button[text()='Open Menu']")
	private WebElement menuTab;
	
	@FindBy (xpath = "//button[text()='Close Menu']")
	private WebElement closeMenu;
	
	@FindBy (linkText = "Logout")
	private WebElement logoutOption;
	
	@FindBy (className = "product_sort_container")
	private WebElement productSortDropdown;
	
	@FindBy (xpath = "//span[contains(@class,'shopping_cart_badge')]")
	private WebElement cartItemCount;
	
	public String getProductPageHeading() {
		return productPageHeading.getText();
	}
	
	public List<String> getAllDisplayedProductNames() {
		return CommonUtils.convertWebElementsToStrings(productElements);
	}
	
	public List<Double> getAllDisplayedProductPrices() {
		return CommonUtils.convertWebElementListToDoubleList(priceElements);
	}
	
	public void selectSortOptionInDropdown(String option) {
		CommonUtils.selectDropdownByVisibleText(productSortDropdown, option);
	}
	
	public String getCartItemCount() {
		return cartItemCount.getText();
	}
	
	public void openMenuTab() {
		menuTab.click();
	}
	
	public void closeMenuTab() {
		CommonUtils.waitForElementToBeClickable(driver, closeMenu, 5).click();
	}
	
	public void clickOnLogout() {
		logoutOption.click();
	}
	
	public void addToCartByProductName(WebDriver driver,String productName) {
		CommonUtils.findAddToCartButton(driver, productName).click();
	}
	
	public boolean closeButtonIsEnabled() {
		return closeMenu.isEnabled();
	}
	
}
