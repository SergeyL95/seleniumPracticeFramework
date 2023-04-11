package HomeWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisaplayedAndEnabled {
	public static void main(String[] args) {
		String projectDir = System.getProperty("user.dir");
		String driverPath = projectDir + "/drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		radioButtonsWork();
		checkBoxes();
		amazonTask();
	}
	
	public static void radioButtonsWork() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		WebElement rb1 = driver.findElement(By.cssSelector("input[id=USA]"));
		WebElement rb2 = driver.findElement(By.cssSelector("input[id=Canada]"));
		WebElement rb3 = driver.findElement(By.cssSelector("input[id=England]"));
		WebElement rb4 = driver.findElement(By.cssSelector("input[id=Japan]"));
		
		rb1.click();
		
		if (rb1.isDisplayed()==true && rb1.isEnabled()==true) {
			System.out.println("\nRadio Button 1 is Displayed and Enabled");
			if(rb1.isSelected()==true) {
				System.out.println("Radio Button 1 is Selected");
			} else {
				System.out.println("Radio Button 1 isn't Selected");
			}
		} else {
			rb1.click();
			if(rb1.isSelected()==true) {
				System.out.println("Radio Button 1 is Selected");
			} else {
				System.out.println("Radio Button 1 isn't Selected");
			}
		}
		
		if (rb2.isDisplayed()==true && rb2.isEnabled()==true) {
			System.out.println("\nRadio Button 2 is Displayed and Enabled");
			if(rb2.isSelected()==true) {
				System.out.println("Radio Button 2 is Selected");
			} else {
				System.out.println("Radio Button 2 isn't Selected");
			}
		} else {
			rb2.click();
			if(rb2.isSelected()==true) {
				System.out.println("Radio Button 2 is Selected");
			} else {
				System.out.println("Radio Button 2 isn't Selected");
			}
		}
		
		if (rb3.isDisplayed()==true && rb3.isEnabled()==true) {
			System.out.println("\nRadio Button 3 is Displayed and Enabled");
			if(rb3.isSelected()==true) {
				System.out.println("Radio Button 3 is Selected");
			} else {
				System.out.println("Radio Button 3 isn't Selected");
			}
		} else {
			rb3.click();
			if(rb3.isSelected()==true) {
				System.out.println("Radio Button 3 is Selected");
			} else {
				System.out.println("Radio Button 3 isn't Selected");
			}
		}
		
		if (rb4.isDisplayed()==true && rb4.isEnabled()==true) {
			System.out.println("\nRadio Button 4 is Displayed and Enabled");
			if(rb4.isSelected()==true) {
				System.out.println("Radio Button 4 is Selected");
			} else {
				System.out.println("Radio Button 4 isn't Selected");
			}
		} else {
			rb4.click();
			if(rb4.isSelected()==true) {
				System.out.println("Radio Button 4 is Selected");
			} else {
				System.out.println("Radio Button 4 isn't Selected");
			}
		}
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
		
		if (checkOne.isDisplayed()==true) {
			System.out.println("\nCheck box 1 is Displayed");
			if (checkOne.isEnabled()==true) {
				System.out.println("Check box 1 is Enabled");
				if (checkOne.isSelected()==true) {
					System.out.println("Check box 1 is Selected");
				} else {
					checkOne.click();
					System.out.println("Check box 1 is Selected");
				}
			} else {
				System.out.println("Check box 1 isnt Enabled");
			}
		} else {
			System.out.println("\nCheck box 1 is Displayed");
		}
		
		if (checkTwo.isDisplayed()==true) {
			System.out.println("\nCheck box 2 is Displayed");
			if (checkTwo.isEnabled()==true) {
				System.out.println("Check box 2 is Enabled");
				if (checkTwo.isSelected()==true) {
					System.out.println("Check box 2 is Selected");
				} else {
					checkTwo.click();
					System.out.println("Check box 2 is Selected");
				}
			} else {
				System.out.println("Check box 2 isnt Enabled");
			}
		} else {
			System.out.println("\nCheck box 2 is Displayed");
		}
		
		if (checkThree.isDisplayed()==true) {
			System.out.println("\nCheck box 3 is Displayed");
			if (checkThree.isEnabled()==true) {
				System.out.println("Check box 3 is Enabled");
				if (checkThree.isSelected()==true) {
					System.out.println("Check box 3 is Selected");
				} else {
					checkThree.click();
					System.out.println("Check box 3 is Selected");
				}
			} else {
				System.out.println("Check box 3 isnt Enabled");
			}
		} else {
			System.out.println("\nCheck box 3 is Displayed");
		}
		
		if (checkFour.isDisplayed()==true) {
			System.out.println("\nCheck box 4 is Displayed");
			if (checkFour.isEnabled()==true) {
				System.out.println("Check box 4 is Enabled");
				if (checkFour.isSelected()==true) {
					System.out.println("Check box 4 is Selected");
				} else {
					checkFour.click();
					System.out.println("Check box 4 is Selected");
				}
			} else {
				System.out.println("Check box 4 isnt Enabled");
			}
		} else {
			System.out.println("\nCheck box 4 is Displayed");
		}
		
	}
	
	public static void amazonTask() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("http://amazon.com");
		driver.manage().window().maximize();
		
		Duration dur = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(dur);
		
		String expectedTextSign = "Sign in";
		String expectedTextReg = "Create account";
		String error1 = "Enter your name";
		String error2 = "Enter your email or mobile phone number";
		String error3 = "Minimum 6 characters required";
		
		
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		String actualTextSign = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		
		if (actualTextSign.equals(expectedTextSign)) {
			System.out.println("Navigation to 'Sign In' Page Verified");
		} else {
			System.out.println("Navigation to 'Sign In' Page FAILED");
		}
		
		driver.navigate().back();
		driver.navigate().forward();
		
		WebElement actualField = driver.findElement(By.xpath("//input[@id='ap_email']"));
		if (actualField.isDisplayed()) {
			System.out.println("Navigation to 'Sign In' Page Verified");
		} else {
			System.out.println("Navigation to 'Sign In' Page FAILED");
		}
		
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		
		String actualTextReg = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if (actualTextReg.equals(expectedTextReg)) {
			System.out.println("Navigation to 'Create Account' Page Verified");
		} else {
			System.out.println("Navigation to 'Create Account' Page FAILED");
		}
		
		driver.navigate().back();
		
		actualField = driver.findElement(By.xpath("//input[@id='ap_email']"));
		if (actualField.isDisplayed()) {
			System.out.println("Navigation to 'Sign In' Page Verified");
		} else {
			System.out.println("Navigation to 'Sign In' Page FAILED");
		}
		
		driver.navigate().forward();
		
		actualTextReg = driver.findElement(By.xpath("//h1[@class='a-spacing-small']")).getText();
		if (actualTextReg.equals(expectedTextReg)) {
			System.out.println("Navigation to 'Create Account' Page Verified");
		} else {
			System.out.println("Navigation to 'Create Account' Page FAILED");
		}
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		String actualErrorMes1 = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]")).getText();
		String actualErrorMes2 = driver.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]")).getText();
		String actualErrorMes3 = driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']/div/div")).getText();
		
		if (error1.equals(actualErrorMes1) && error2.equals(actualErrorMes2) && error3.equals(actualErrorMes3)) {
			System.out.println("Error Messages Verified");
		} else {
			System.out.println("Error Messages FAILED");
		}
		
		
	}
	
	
}
