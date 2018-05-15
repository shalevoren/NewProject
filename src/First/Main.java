package First;



import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import popup.GooglePopup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	static ChromeDriver driver;
	
			@BeforeClass
			public static void setUpBeforeClass() throws Exception {
				System.setProperty("webdriver.chrome.driver", "C:/javatesters/workspace/selenium/chromedriver.exe");
				
				//WebDriver driver = new ChromeDriver();
				
				//To Maximize Browser Window 
				//driver.manage().window().maximize(); 
			}
			
			
			@Test
			public void WixText() throws Exception{
				 
			File file = new File("C:/workspace/automationfw/NewProject/src/resources/wix.properties");
			FileInputStream	fileInput = null;
			
			try{
				
				fileInput =  new FileInputStream(file);
			}catch(FileNotFoundException e){
				e.printStackTrace();		
			}
			
			Properties envProps= new Properties();
			
			try{
				envProps.load(fileInput);
			}catch(IOException e){
			e.printStackTrace();
		}
			
			String URL = envProps.getProperty("URL");
			/*System.setProperty("webdriver.chrome.driver", "C:/javatesters/workspace/selenium/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			//To Maximize Browser Window 
			driver.manage().window().maximize();*/
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			
			////screen shot page option
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File ("C:\\Failure.png"));
			
			String my_handle= driver.getWindowHandle();
			driver.findElement(By.cssSelector("#wm-signin-link")).click();

			waitForLoad(driver);
			
			driver.findElement(By.cssSelector(".social-button.google-button")).click();	

		while (driver.getWindowHandles().size()<2){
				
				Thread.sleep(2000);
			}
			
			java.util.Set<String> handles=driver.getWindowHandles();
			for(String windowsHandle : handles)
			{		
				if(!windowsHandle.equals(my_handle)){
					
					driver.switchTo().window(windowsHandle);
					break;
				}
			}
			

			waitForLoad(driver);
			 GooglePopup googlepopup = new GooglePopup(driver);

			 
			 googlepopup.sendTextToInputField(envProps.getProperty("Email"));
			// googlepopup.clickOnNextButton();
			 waitForLoad(driver);
			 googlepopup.sendTextToInputField(envProps.getProperty("PasswordG"));
			 //driver.findElement(By.cssSelector("#identifierNext")).click();
			// googlepopup.clickOnNextButton();

		/*	driver.findElement(By.cssSelector("#input_0")).sendKeys(envProps.getProperty("Email"));
			driver.findElement(By.cssSelector("#input_1")).sendKeys(envProps.getProperty("Password", "Q1w2e3r4"));
			driver.findElement(By.cssSelector(".login-btn")).click();
			
			System.out.println("URL is"+ envProps.getProperty("URL"));
			System.out.println("User name is: "+envProps.getProperty("Email"));
			System.out.println("The password is: "+ envProps.getProperty("Password"));*/

			}

			public static void waitForLoad(WebDriver driver){
				
				sleep(1000);
				
			}

			private static void sleep(long  millis) {
				try {
					Thread.sleep(millis);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	

