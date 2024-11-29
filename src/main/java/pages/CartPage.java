package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class CartPage {
	
WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(@class,'shopping_cart_link')]")
	private WebElement cartIcon;
	
	@FindBy (css = "div[class='cart_quantity']")
	private List<WebElement> noOfItemInCartPage;
	
	@FindBy (className = "inventory_item_name")
	private List<WebElement> productsNameInTheCart;
	
	@FindBy (className = "inventory_item_price")
	private List<WebElement> productPricesInTheCart;
	
	@FindBy (xpath = "//button[text()='REMOVE']")
	private List<WebElement> productRemoveButtons;
	
	@FindBy (linkText = "CHECKOUT")
	private WebElement checkoutButton;
	
	@FindBy (xpath = "//a[text()='Continue Shopping']")
	private WebElement continueShoppingButton;
	

	public void clickOnCartIcon() {
		cartIcon.click();
	}
	
	public int getNoOfItemInCartPage() {
		return noOfItemInCartPage.size();
	}
	
	public String getProductName() {
		return productsNameInTheCart.get(0).getText();
	}
	
	public List<String> getListOfProductNames() {
		return CommonUtils.convertWebElementsToStrings(productsNameInTheCart);
	}
	
	public List<String> getListOfProductPrices() {
		return CommonUtils.convertWebElementsToStrings(productPricesInTheCart);
	}
	
	public void removeProductFromTheCart(String product) {
		CommonUtils.removeProductFromCart(productsNameInTheCart, productRemoveButtons, product);
	}
	
	public void clickOnCheckout() {
		checkoutButton.click();
	}
	
	public void clickOnContinueShoppingButton() {
		continueShoppingButton.click();
	}
}
