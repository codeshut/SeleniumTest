package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver/chromedriver");

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");

		// switch to the frame containing the web elements
		driver.switchTo().frame(0);

		// store the references of web elements which user want to drag and drop
		WebElement dragSource = driver.findElement(By.id("draggable"));
		WebElement dropTarget = driver.findElement(By.id("droppable"));

		// implicit wait to wait until web element is dragged and dropped
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//invoke Actions class. It accepts the instance of WebDriver
		Actions actionsDrag = new Actions(driver);
		
		//perform drag and drop gesture
		actionsDrag.dragAndDrop(dragSource, dropTarget).perform();
		System.out.println("Done Dragging and dropping");		

		
		driver.navigate().to("https://jqueryui.com/resizable/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement resizeElement = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

		Actions actionsResize = new Actions(driver);
		
		//provide the x and y offset values
		actionsResize.dragAndDropBy(resizeElement, 	100, 50).perform();
		
		System.out.println("Done Resizing");
		
	
		driver.navigate().to("https://jqueryui.com/slider/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement slideElement = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		Actions actionsSlide = new Actions(driver);
		
		actionsSlide.dragAndDropBy(slideElement, 	100, 0).perform();
		
		System.out.println("Done Sliding");

	}

}
