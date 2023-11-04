package WebPageAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityMethods.Parametrization;

public class DemoblazePractice {

	public static void main(String[] args) {
		
            DemoblazePractice.demoblazeLogin();
	
	
	}

	public static void demoblazeLogin() {

		// WebDriver setup......................................

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();

		// WebDriver interface methods..........................
		String pageTitle = driver.getTitle();
		String pageUrl = driver.getCurrentUrl();
//		String pageSource = driver.getPageSource();
		String pageWindowHandle = driver.getWindowHandle();

		System.out.println("page title is -" + pageTitle);
		System.out.println("page url is -" + pageUrl);
//		System.out.println("page source is -"+pageSource);
//it will fetch complete DOM structure i.e. page code (HTML,CSS,JS etc)
		System.out.println("page window handle is -" + pageWindowHandle);

		// login to the store or site......................

		WebElement loginWord = driver.findElement(By.linkText("Log in"));

		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofMillis(5000));
		eWait.until(ExpectedConditions.visibilityOf(loginWord));

		loginWord.click();
		// username...............
		WebElement usernameTextbox = driver.findElement(By.id("loginusername"));
		WebDriverWait eWait2 = new WebDriverWait(driver, Duration.ofMillis(5000));
		eWait2.until(ExpectedConditions.visibilityOf(usernameTextbox));
		String sheetUserName = Parametrization.sheetData("idAndPass", 2, 2);
		System.out.println("username is -" + sheetUserName);
		usernameTextbox.sendKeys(sheetUserName);

		// password..............
		WebElement passTextbox = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		String sheetPass = Parametrization.sheetData("idAndPass", 2, 3);
		System.out.println("password is -" + sheetPass);
		passTextbox.sendKeys(sheetPass);

		// login................
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginButton.click();

		// login check................
//		WebElement logoutText = driver.findElement(By.xpath("//a[text()='Log out']"));
//		WebDriverWait eWait3 = new WebDriverWait(driver, Duration.ofMillis(5000));
//		eWait3.until(ExpectedConditions.visibilityOf(logoutText));

		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("page title after login is -"+driver.getTitle());
		
		// closing the current window...................
		driver.close();

	}

}
