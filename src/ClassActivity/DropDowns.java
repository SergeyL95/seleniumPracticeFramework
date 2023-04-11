package ClassActivity;

import java.net.PortUnreachableException;

import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		DropDownDemo();
	}
	
	public static void DropDownDemo() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		WebElement dropdown1 = driver.findElement(By.id("searchDropdownBox"));
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		Select letsSelect = new Select(dropdown1);
		letsSelect.selectByVisibleText("Home & Kitchen");
		letsSelect.selectByIndex(1);
		
		
	}
	
	public static void activityTwo() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		String expectedHomeTitle = "Amazon.com. Spend less. Smile more.";
		String actualHomeTitle;
		
		actualHomeTitle = driver.getTitle();
		if (expectedHomeTitle.equals(actualHomeTitle)) {
			System.out.println();
		}
		
	}
}
