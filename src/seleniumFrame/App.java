package seleniumFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		//Get the size/ total number of frames in a web page
		int size = driver.findElements(By.tagName("frame")).size();
		System.out.println(size);
		
		//Switch to third frame using index
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("INDEX")).click();
		
		//Switch to the parent webpage  
		driver.switchTo().defaultContent();
		
		//switch to the second frame using name attribute value
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("AbstractAnnotations")).click();
		
		//Switch to the parent webpage  
		driver.switchTo().defaultContent();
		
		//Take the reference of the first frame and store in a variable of type WebElement
		WebElement ele = driver.findElement(By.name("packageListFrame"));
		
		//switch to the frame using the reference
		driver.switchTo().frame(ele);
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		driver.close();
	}

}
