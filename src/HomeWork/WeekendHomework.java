package HomeWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WeekendHomework {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		checkBoxes();
		radioButtons();
		justButtons();
		Links();
		
	}
	
	public static void checkBoxes() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		driver.manage().window().maximize();
		
		WebElement checkOne = driver.findElement(By.xpath("//input[@id='Java']"));
		WebElement checkTwo = driver.findElement(By.xpath("//input[@id='JavaScript']"));
		WebElement checkThree = driver.findElement(By.xpath("//input[@id='C#']"));
		WebElement checkFour = driver.findElement(By.xpath("//input[@id='Python']"));
		
		checkOne.click();
		checkFour.click();
		
		System.out.println("Option 1 selected: " + checkOne.isSelected());
		System.out.println("Option 2 selected: " + checkTwo.isSelected());
		
		driver.close();
	}
	
	public static void radioButtons() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
		driver.manage().window().maximize();
		
		WebElement rButtonOne = driver.findElement(By.xpath("//input[@id='USA']"));
		WebElement rButtonTwo = driver.findElement(By.xpath("//input[@id='Canada']"));
		WebElement rButtonThree = driver.findElement(By.xpath("//input[@id='England']"));
		WebElement rButtonFour = driver.findElement(By.xpath("//input[@id='Japan']"));
		
		rButtonOne.click();
		rButtonTwo.click();
		
		System.out.println("Option 1 selected: " + rButtonOne.isSelected());
		System.out.println("Option 2 selected: " + rButtonTwo.isSelected());
		
		driver.close();
	}
	
	public static void justButtons() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/buttons");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(3);
		driver.manage().timeouts().implicitlyWait(dur);
		
		String expectedDoubleClick = "You have clicked \"Double Click Button\"";
		String expectedContextClick = "You have clicked \"Context Click Button\"";
		String expectedOneClick = "You have clicked \"Dynamic ID button\"";
		
		WebElement buttonOne = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		WebElement buttonTwo = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		WebElement buttonThree = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		Actions actions = new Actions(driver);
		
		actions.doubleClick(buttonOne).perform();
		String actualDoubleClick = driver.findElement(By.xpath("//p[@class='result']")).getText();
		if(expectedDoubleClick.equals(actualDoubleClick)){
			System.out.println("Double Click Message Validation PASSED");
		} else {
			System.out.println("Double Click Message Validation FAILED");
			System.out.println("Expected: " + expectedDoubleClick);
			System.out.println("Actual: " + actualDoubleClick);
		}
		
		actions.contextClick(buttonTwo).perform();
		String actualContextClick = driver.findElement(By.xpath("//p[@class='result']")).getText();
		if(expectedContextClick.equals(actualContextClick)){
			System.out.println("Context Click Message Validation PASSED");
		} else {
			System.out.println("Context Click Message Validation FAILED");
			System.out.println("Expected: " + expectedContextClick);
			System.out.println("Actual: " + actualContextClick);
		}
		
		buttonThree.click();
		String actualOneClick = driver.findElement(By.xpath("//p[@class='result']")).getText();
		if(expectedOneClick.equals(actualOneClick)){
			System.out.println("One Click Message Validation PASSED");
		} else {
			System.out.println("One Click Message Validation FAILED");
			System.out.println("Expected: " + expectedOneClick);
			System.out.println("Actual: " + actualOneClick);
		}
		
		driver.close();
	}
	
	public static void Links() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/links");
		driver.manage().window().maximize();
		
		String homeTab = driver.getWindowHandle();
		String homeURL = driver.getCurrentUrl();
		String actualURL;
		String homeTitle = driver.getTitle();
		String actualTitle;
		
		Duration dur = Duration.ofSeconds(3);
		driver.manage().timeouts().implicitlyWait(dur);
		
		WebElement linkOne = driver.findElement(By.xpath("//a[contains(@href, 'amazon.com')]"));
		linkOne.click();
		driver.switchTo().window(homeTab);
		actualURL = driver.getCurrentUrl();
		actualTitle = driver.getTitle();
		if (actualTitle.equals(homeTitle)&&actualURL.equals(homeURL)) {
			System.out.println("Return to Home tab from LINK 1 PASSED");
		} else {
			System.out.println("Return to Home tab from LINK 1 FAILED");
			System.out.println("Expected URL: " + homeURL + ", home title: " + homeTitle);
			System.out.println("Actual URL: " + actualURL + ", acutal title: " + actualTitle);
		}
		
		WebElement linkTwo = driver.findElement(By.xpath("//a[contains(@href, 'facebook.com')]"));
		linkTwo.click();
		driver.switchTo().window(homeTab);
		actualURL = driver.getCurrentUrl();
		actualTitle = driver.getTitle();
		if (actualTitle.equals(homeTitle)&&actualURL.equals(homeURL)) {
			System.out.println("Return to Home tab from LINK 2 PASSED");
		} else {
			System.out.println("Return to Home tab from LINK 2 FAILED");
			System.out.println("Expected URL: " + homeURL + ", home title: " + homeTitle);
			System.out.println("Actual URL: " + actualURL + ", acutal title: " + actualTitle);
		}
		
	}
}
