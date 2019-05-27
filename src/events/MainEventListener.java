package events;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainEventListener {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver wrapper used to register the events
		EventFiringWebDriver eventFire = new EventFiringWebDriver(driver);
		
		//Create object of EventListener class 
		EventListener eventListener = new EventListener();
		
		//register the events in EventListener class. This will invoke the methods in EventListener class when a certain event occur		
		eventFire.register(eventListener);
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		eventFire.get("https://www.google.com/");
		
		eventFire.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		
		eventFire.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(eventFire.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"))));
		
		eventFire.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
		eventFire.navigate().back();
		
		eventFire.quit();
		
		
		

	}

}
