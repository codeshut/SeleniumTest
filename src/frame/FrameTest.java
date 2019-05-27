package frame;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameTest {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver/chromedriver");

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");

		//switch to the desired frame (text area) using id attribute value
		driver.switchTo().frame("mce_0_ifr");
		
		//clear the default text from the text area
		driver.findElement(By.id("tinymce")).clear();
		
		//Enter the desired text
		driver.findElement(By.id("tinymce")).sendKeys("Test");

		//switch to main web page containing the frame
		driver.switchTo().defaultContent();
		
		//click on the link and wait till the page loads
		driver.findElement(By.linkText("Elemental Selenium")).click();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		//Get the reference of all opened browser windows. This will include the already opened window(s), if any
		Set<String> handles = driver.getWindowHandles();

		//loop through each window handle and verify the title
		for (String handle : handles) {
			if (driver.switchTo().window(handle).getTitle().contains("Receive a Free")) {
				System.out.println("Matched");
			}

		}

	}

}
