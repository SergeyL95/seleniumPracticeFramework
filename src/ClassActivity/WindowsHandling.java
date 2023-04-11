package ClassActivity;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandling {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//LetsHandle();
		ClassActivity2();
	}

	public static void LetsHandle() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		driver.manage().window().maximize();
		
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window ID: " + mainWindow);
		
		driver.findElement(By.id("newTab")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		//with loop
		for (String windowId : windowIds) {
			System.out.println("Window ID: " + windowId);
		}
		//with iterator
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		System.out.println("First window: " + firstWindowId);
		String secondWindowId = ids.next();
		System.out.println("Second window: " + secondWindowId);
		
		driver.switchTo().window(secondWindowId);
		String newTabTextOnSecondWindow = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		
		driver.close(); //will close the current window only
	}
	
	public static void ClassActivity2() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		driver.manage().window().maximize();
		
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String> ids = windowIds.iterator();
		String firstWindowId = ids.next();
		String secondWindowId = ids.next();
		
		if (mainWindowId.equals(firstWindowId)) {
			System.out.println("Main window ID test PASSED");
		} else {
			System.out.println("Main window ID test FAILED");
		}
		
		driver.switchTo().window(secondWindowId);
		WebElement newTabButton = driver.findElement(By.id("newTab"));
		if(newTabButton.isDisplayed()) {
			System.out.println("Second tab navigation test PASSED");
		} else {
			System.out.println("Second tab navigation test FAILED");
		}
		
		driver.close();
		driver.switchTo().window(firstWindowId);
		String curentWindow = driver.getWindowHandle();
		
		if (mainWindowId.equals(curentWindow)) {
			System.out.println("Returned to main test PASSED");
		} else {
			System.out.println("Returned to main test FAILED");
		}
		
	}
	
	public static void isItDynamic() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
	}
}
