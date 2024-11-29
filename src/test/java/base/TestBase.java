package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class TestBase {
	
	 static WebDriver driver;
	 static Properties properties;
	 
	 //Load properties from the config file
	 static {
		 try {
			 FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
	            properties = new Properties();
	            properties.load(fis);
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 }
	 
	
	@Before
	public void setup() {
		
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver.path"));
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", properties.getProperty("edge.driver.path"));
			driver = new EdgeDriver();
			
		}else if(browserName.equals("brave")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("brave.driver.path"));
			ChromeOptions braveOption = new ChromeOptions();
			braveOption.setBinary(properties.getProperty("brave.binary.path"));
			driver = new ChromeDriver(braveOption);
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void tearDown() {
		driver.quit();
}
}
