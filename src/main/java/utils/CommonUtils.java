package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	// Method to select an option from a dropdown by visible text
	public static void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	// Method to sort a list of numbers in descending order
	public static List<Double> sortNumbersAscending(List<Double> numbers) {
		Collections.sort(numbers);
		return numbers;
	}

	// Method to sort a list of numbers in descending order
	public static List<Double> sortNumbersDescending(List<Double> numbers) {
		Collections.sort(numbers, Collections.reverseOrder());
		return numbers;
	}

	// Method to sort a list of strings alphabetically in ascending order
	public static List<String> sortStringsAscending(List<String> items) {
		Collections.sort(items);
		return items;
	}

	// Method to sort a list of strings alphabetically in descending order
	public static List<String> sortStringsDescending(List<String> items) {
		Collections.sort(items, Collections.reverseOrder());
		return items;
	}

	public static List<String> convertWebElementsToStrings(List<WebElement> elements) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			textList.add(element.getText()); // Extract text and add to list
		}
		return textList;
	}

	public static List<String> sortList(List<String> strings) {
		Collections.sort(strings); // Sorts the list in ascending order
		return strings; // Returns the sorted list
	}

	public static List<String> sortListDescending(List<String> strings) {
		Collections.sort(strings, Collections.reverseOrder()); // Sorts the list in descending order
		return strings;
	}

	public static List<Double> convertWebElementListToDoubleList(List<WebElement> elements) {
		List<Double> prices = new ArrayList<>();

		// Loop through the WebElements, extract text, and convert to Double
		for (WebElement element : elements) {
			String text = element.getText().replace("$", "").trim(); // Remove $ or any other non-numeric characters
			try {
				Double price = Double.parseDouble(text); // Parse the string into a Double
				prices.add(price); // Add the parsed Double to the list
			} catch (NumberFormatException e) {
				// Handle the case where the text is not a valid number (optional)
				System.out.println("Error parsing price: " + text);
			}
		}

		return prices; // Return the list of Double values
	}

	public static void sortNumberListAscending(List<Double> prices) {
		Collections.sort(prices); // Sorts the list in ascending order by default
	}

	public static void sortNumberListDescending(List<Double> prices) {
		Collections.sort(prices, Collections.reverseOrder()); // Sorts the list in descending order
	}

	public static List<Double> convertStringListToDoubleList(List<String> stringList) {
		List<Double> doubleList = new ArrayList<>();

		// Iterate through the list and convert each string to a Double
		for (String str : stringList) {
			try {
				doubleList.add(Double.parseDouble(str)); // Attempt to parse each string
			} catch (NumberFormatException e) {
				// Handle the case where a string can't be parsed as a Double
				// You can log the error, or decide on a default value
				// Here we just skip invalid entries
				System.err.println("Invalid number format: " + str);
			}
		}

		return doubleList;
	}

	public static void removeProductFromCart(List<WebElement> productsNameInTheCart,
			List<WebElement> productRemoveButtons, String... productNames) {

		// Loop through the provided product names
		for (String productName : productNames) {
			// Iterate through all products in the cart
			for (int i = 0; i < productsNameInTheCart.size(); i++) {
				WebElement product = productsNameInTheCart.get(i);
				String productText = product.getText().trim();

				// Check if the product name matches the one to remove
				if (productText.equalsIgnoreCase(productName)) {
					// Click the REMOVE button corresponding to the matched product
					WebElement removeButton = productRemoveButtons.get(i);
					removeButton.click();
					// Optionally, you can add a small delay if needed to wait for the product to be removed
					try {
						Thread.sleep(500); // Sleep for 500ms to allow the removal to happen
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break; // Exit the loop once the product is removed
				}
			}
		}
	}

	public static List<String> convertToList(String... strings) {
		// Create a List to hold the strings
		List<String> list = new ArrayList<>();

		// Add all the passed strings to the list
		for (String str : strings) {
			list.add(str);
		}

		// Return the list
		return list;
	}

	public static double sumList(List<Double> doubleList) {
		double sum = 0.0;

		// Iterate through the list and accumulate the sum
		for (Double value : doubleList) {
			sum += value;
		}

		return sum;
	}

	// Utility method to locate product by name
	public static WebElement findProductByName(WebDriver driver, String productName) {
		return driver.findElement(By.xpath("//div[text()='" + productName + "']"));
	}

	// Utility method to find the "Add to Cart" button for a product
	public static WebElement findAddToCartButton(WebDriver driver, String productName) {
		WebElement product = findProductByName(driver, productName);
		return product.findElement(
				By.xpath(".//ancestor::div[@class='inventory_item_label']/following-sibling::div/descendant::button"));
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static Double getProductPrice(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            return null;  // No elements to process.
        }

        Pattern pricePattern = Pattern.compile("\\$?([0-9]+(?:\\.\\d{2})?)");
        Double commonPrice = null;

        for (WebElement element : elements) {
            String text = element.getText().trim();
            Matcher matcher = pricePattern.matcher(text);

            if (matcher.find()) {
                try {
                    Double price = Double.parseDouble(matcher.group(1));  // Extract and parse the price

                    if (commonPrice == null) {
                        commonPrice = price;  // First price found, set as common price
                    } else if (!commonPrice.equals(price)) {
                        return null;  // Prices differ, return null
                    }
                } catch (NumberFormatException e) {
                    return null;  // Return null if parsing fails
                }
            }
        }

        return commonPrice;  // Return common price, or null if inconsistent
    }
}
