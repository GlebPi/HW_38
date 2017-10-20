package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";

		String url = "http://facebook.com/";
		String email_address = "glebsergeich@gmail.com";
		String password = "lkbysqGS1984P7";

	     if (System.getProperty("os.name").toUpperCase().contains("MAC"))     driverPath = "./resources/webdrivers/mac/geckodriver.sh";
	else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "./resources/webdrivers/pc/geckodriver.exe";
	else throw new IllegalArgumentException("Unknown OS");
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		driver.get(url);

		Thread.sleep(2000); // Pause in milleseconds (1000 – 1 sec)
		
		String title = driver.getTitle();
		String copyright = driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div[1]")).getText();
		
		driver.findElement(By.id("email")).sendKeys(email_address);
		driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("u_0_2")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).click();

        Thread.sleep(2000);
        String friends = driver.findElement(By.xpath("//li[3]/a[1]/span[1]")).getText();
        
        Thread.sleep(2000);
        driver.findElement(By.id("userNavigationLabel")).click();
        //driver.findElement(By.xpath("/html/body/div[28]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span")).click();
      
        Thread.sleep(2000);
		driver.quit();
        
		System.out.println("Browser is: Firefox");
        System.out.println("Title of the page: " + title);
        System.out.println("Copyright: " + copyright);
        System.out.println("You have " + friends + " friends");
	}
}