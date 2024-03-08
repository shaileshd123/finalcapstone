package testbase;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\Downloads\\xyzBank_SeleniumProject-main (1)\\xyzBank_SeleniumProject-main\\XYZ_Bank\\src\\main\\resources\\com\\axis\\qa\\config\\config.properties");
			prop.load(ip);
			prop.getProperty("url");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\eclipse-workspace\\BCG1\\src\\test\\resources\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}  else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\eclipse-workspace\\BCG1\\src\\test\\resources\\msedgedriver.exe");

			WebDriver driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
	}

//	@AfterMethod
//	public void teardownBrowser() {
//		driver.quit();
//	}
}
