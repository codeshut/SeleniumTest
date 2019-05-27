package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resize {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/dhawal/selenium jars/chromedriver/geckodriver");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	//WebDriverWait wait = new WebDriverWait(driver, 10L);
		
		driver.navigate().to("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resizeElement = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		
	//	driver.navigate().to("https://viralpatel.net/blogs/demo/jquery-resize-drag/");
		//driver.switchTo().frame(1);
	//	WebElement resizeElement = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", resizeElement);
		
		
		Actions actionsResize = new Actions(driver);
//		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")));
		actionsResize.dragAndDropBy(resizeElement, 300, 200).perform();
		
		//actionsResize.clickAndHold(resizeElement).moveByOffset(300, 0).release().build().perform();
		System.out.println("Done");

	}

}
