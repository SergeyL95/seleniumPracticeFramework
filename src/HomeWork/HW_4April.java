package HomeWork;

import utils.Driver;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HW_4April {
	public static void main(String[] args) {
		
		//dragAndDropCase();
		testScroll();
		
	}
	
	public static void dragAndDropCase() {
		
		Driver.getDriver().get("http://practice.primetech-apps.com/practice/drag-and-drop");
		Driver.getDriver().manage().window().maximize();
		
		WebElement header = Driver.getDriver().findElement(By.xpath("//h3[text()='Drag And Drop']"));
		if (header.isDisplayed()) {
			System.out.println("Header Validation PASSED");
		} else {
			System.out.println("Header Validation FAILED");
		}

		Actions actions = new Actions(Driver.getDriver());
		
		WebElement textElement = Driver.getDriver().findElement(By.xpath("//a[@id='text']"));
		WebElement textAreaElement = Driver.getDriver().findElement(By.id("textarea"));
		WebElement numberElement = Driver.getDriver().findElement(By.id("Number"));
		WebElement dropZone = Driver.getDriver().findElement(By.id("dropzone"));
		
		actions.dragAndDrop(textElement, dropZone).perform();
		actions.dragAndDrop(textAreaElement, dropZone).perform();
		actions.dragAndDrop(numberElement, dropZone).perform();
		
		List<WebElement> removers = Driver.getDriver().findElements(By.xpath("//button[@class='btn btn-default btn-xs remove']"));

		Iterator<WebElement> it = removers.iterator();
		while(it.hasNext()) {
			WebElement elem = it.next();
			elem.click();
		}
		
		Driver.quitDriver();
		
	}
	
	public static void testScroll() {
		Driver.getDriver().get("https://markappliancerepair.com/");
		Driver.getDriver().manage().window().maximize();
		
		WebElement button = Driver.getDriver().findElement(By.linkText("Home"));
		
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", button);
	}
}
