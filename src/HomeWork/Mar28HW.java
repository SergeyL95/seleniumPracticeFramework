package HomeWork;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mar28HW {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//testCaseOne();
		//testCaseTwo();
		//testCaseThree();
		//testCaseFour();
		//testCaseFive();
		testCaseSix();
	}
	
	public static void testCaseOne() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select letsSelect = new Select(dropDown);
		
		List<WebElement> allOptions = new ArrayList<WebElement>();
		allOptions = letsSelect.getOptions();
		
		if (allOptions.size()==58) {
			System.out.println("Options amount PASSED");
		} else {
			System.out.println("Options amount FAILED");
			System.out.println("Expected amount: 58");
			System.out.println("Actual amount: " + allOptions.size());
		}
		
		for (int i = 0; i < allOptions.size(); i++) {
			System.out.println("\n" + allOptions.get(i).getText());
		}
	}
	
	public static void testCaseTwo() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		String expectedHomeTitle = "Amazon.com. Spend less. Smile more.";
		String actualHomeTitle;
		
		actualHomeTitle = driver.getTitle();
		if (expectedHomeTitle.equals(actualHomeTitle)) {
			System.out.println("Page Title Verification PASSED");
		} else {
			System.out.println("Page Title Verification FAILED");
			System.out.println("Expected Title: " + expectedHomeTitle);
			System.out.println("Actual Title: " + actualHomeTitle);
		}
		
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select letsSelect = new Select(dropDown);
		String dropdownValue = letsSelect.getFirstSelectedOption().getText();
		String expectedValue = "All Departments";
		
		if (dropdownValue.equals(expectedValue)){
			System.out.println("Default Dropdown Value PASSED");
		} else {
			System.out.println("Default Dropdown Value PASSED");
			System.out.println("Expected Value: " + expectedValue);
			System.out.println("Actual Value: " + dropdownValue);
		}
		
		letsSelect.selectByVisibleText("Home & Kitchen");
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("coffee mug" + Keys.ENTER);
		
		String expectedSearchTitle = "Amazon.com : coffee mug";
		String actualSearchTitle = driver.getTitle();
		if(expectedSearchTitle.equals(actualSearchTitle)) {
			System.out.println("Search Title PASSED");
		} else {
			System.out.println("Search Title PASSED");
			System.out.println("Expected Title: " + expectedSearchTitle);
			System.out.println("Actual Title: " + actualSearchTitle);
		}
		
		WebElement dropDown2 = driver.findElement(By.id("searchDropdownBox"));
		Select letsSelect2 = new Select(dropDown2);
		
		String expectedDep = "Home & Kitchen";
		String actualDep = letsSelect2.getFirstSelectedOption().getText();

		if (expectedDep.equals(actualDep)) {
			System.out.println("Current Department PASSED");
		} else {
			System.out.println("Current Department FAILED");
			System.out.println("Expected Department: " + expectedDep);
			System.out.println("Actual Department: " + actualDep);
		}
	}
	
	public static void testCaseThree() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alert")).click();
		
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.accept();
	}
	
	public static void testCaseFour() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("confirm")).click();
		
		Alert handleAlert = driver.switchTo().alert();
		String textAlert = handleAlert.getText();
		String expectedAlert = "Do you wish to continue or cancel?";
		
		if (textAlert.equals(expectedAlert)) {
			System.out.println("Alert text PASSED");
			handleAlert.accept();
		} else { 
			System.out.println("Alert text FAILED");
			System.out.println("Expected text: " + expectedAlert);
			System.out.println("Actual text: " + textAlert);
			handleAlert.dismiss();
		}
	}
	
	public static void testCaseFive() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("prompt")).click();
		
		String name = "Prime Tech";
		
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.sendKeys(name + Keys.ENTER);
		handleAlert.accept();
		
		String textDemo = driver.findElement(By.id("demo")).getText();
		String expectedText = "Hello " + name + "! How are you today?";
		
		if (textDemo.equals(expectedText)) {
			System.out.println("Demo text PASSED");
		} else { 
			System.out.println("Demo text FAILED");
			System.out.println("Expected text: " + expectedText);
			System.out.println("Actual text: " + textDemo);
		}
	}
	
	public static void testCaseSix() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("prompt")).click();
		
		String name = "Prime Tech";
		
		Alert handleAlert = driver.switchTo().alert();
		handleAlert.dismiss();
		
		String textDemo = driver.findElement(By.id("demo")).getText();
		String expectedText = "User cancelled the prompt.";
		
		if (textDemo.equals(expectedText)) {
			System.out.println("Demo text PASSED");
		} else { 
			System.out.println("Demo text FAILED");
			System.out.println("Expected text: " + expectedText);
			System.out.println("Actual text: " + textDemo);
		}
	}
}
