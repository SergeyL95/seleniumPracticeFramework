package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpathCSSpt {
	public static void main(String[] args) {
		
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		xpathCSSpt ptObj = new xpathCSSpt();
		ptObj.testCaseOne();
		
	}
	
	public static void testCaseOne() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		String firstName = "Patrick";
		String actualFirstName;
		String lastName = "Mahomes";
		String actualLastName;
		String regEmail = "chiefs@gmail.com";
		String actualEmail;
		String regPass = "Password123";
		String actualPass;
		String regAddress = "123 Chiefs, Kansas City, MO";
		String actualAddress;
		
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#email")).sendKeys(regEmail);
		driver.findElement(By.cssSelector("#password")).sendKeys(regPass);
		driver.findElement(By.cssSelector(".btn-enable")).click();
		driver.findElement(By.cssSelector("#address")).sendKeys(regAddress);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		actualFirstName = driver.findElement(By.cssSelector(".firstName")).getText();
		actualLastName = driver.findElement(By.cssSelector(".lastName")).getText();
		actualEmail = driver.findElement(By.cssSelector(".email")).getText();
		actualPass = driver.findElement(By.cssSelector(".password")).getText();
		actualAddress = driver.findElement(By.cssSelector(".address")).getText();
		
		if (firstName.equals(actualFirstName)) {
			System.out.println("First Name Verfication PASSED");
		} else {
			System.out.println("First Name Verfication FAILED");
			System.out.println("Expected First Name: " + firstName);
			System.out.println("Actual First Name: " + actualFirstName);
		}
		
		if (lastName.equals(actualLastName)) {
			System.out.println("Last Name Verfication PASSED");
		} else {
			System.out.println("Last Name Verfication FAILED");
			System.out.println("Expected Last Name: " + lastName);
			System.out.println("Actual Last Name: " + actualLastName);
		}
		
		if (regEmail.equals(actualEmail)) {
			System.out.println("Email Verfication PASSED");
		} else {
			System.out.println("Email Verfication FAILED");
			System.out.println("Expected Email: " + regEmail);
			System.out.println("Actual Email: " + actualEmail);	
		}
		
		if (regPass.equals(actualPass)) {
			System.out.println("Password Verfication PASSED");
		} else {
			System.out.println("Password Verfication FAILED");
			System.out.println("Expected Password: " + regPass);
			System.out.println("Actual Password: " + actualPass);
		}
		
		if (regAddress.equals(actualAddress)) {
			System.out.println("Address Verfication PASSED");
		} else {
			System.out.println("Address Verfication FAILED");
			System.out.println("Expected Address: " + regAddress);
			System.out.println("Actual Address: " + actualAddress);
		}
		
	}
}
