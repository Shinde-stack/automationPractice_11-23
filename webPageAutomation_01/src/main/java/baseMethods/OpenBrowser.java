package baseMethods;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void launchEdge(String urlToOpen) {

//1. set the system property		
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources" + File.separator + "msedgedriver.exe");

		// "E:\\2.practice projects\\1.automation practice project_01\\webPageAutomation_01\\src\\main\\resources\\msedgedriver.exe"

		// 2.upcast constructor of edge driver class to the web driver interface

		WebDriver driver = new EdgeDriver();
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.manage().window().maximize();

		
	}

	public static void launchChrome(String urlToOpen) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.manage().window().maximize();

	}

}
