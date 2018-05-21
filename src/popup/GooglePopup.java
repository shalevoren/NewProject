package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class GooglePopup {
	
		//protected By email=By.cssSelector("#identifierId");
		//protected By nextBtn=By.cssSelector("#identifierNext");
		protected By forgetPsw=By.id(".uBOgn");
		protected WebDriver driver;
		protected int wait;
		protected int defaultWaitTime =10;
		public By defaultPopupFrame= By.cssSelector("#initialView");
		GooglePopup googlePopup;
		
		@FindBy(css="#identifierId")
		private WebElement email;
		
		@FindBy(css="#identifierNext")
		private WebElement nextBtn;
		
		public GooglePopup(WebDriver driver){
			
			this.driver=driver;
			//this.email=email;
			//this.nextBtn=nextBtn;
			//defaultPopupFrame = popup;
			
		}

		
		public By getForgetPsw() {
			return forgetPsw;
		}


		public void setForgetPsw(By forgetPsw) {
			this.forgetPsw = forgetPsw;
		}


		public int getWait() {
			return wait;
		}


		public void setWait(int wait) {
			this.wait = wait;
		}


		public int getDefaultWaitTime() {
			return defaultWaitTime;
		}


		public void setDefaultWaitTime(int defaultWaitTime) {
			this.defaultWaitTime = defaultWaitTime;
		}


		public By getDefaultPopupFrame() {
			return defaultPopupFrame;
		}


		public void setDefaultPopupFrame(By defaultPopupFrame) {
			this.defaultPopupFrame = defaultPopupFrame;
		}




		public WebElement getEmail() {
			return email;
		}


		public void setEmail(WebElement email) {
			this.email = email;
		}


		public WebElement getNextBtn() {
			return nextBtn;
		}


		public void setNextBtn(WebElement nextBtn) {
			this.nextBtn = nextBtn;
		}


		public boolean sendTextToInputField( String text){
		
			if ( text.contains("@")){
	driver.findElement(By.cssSelector("#identifierId")).sendKeys(text);
	driver.findElement(By.cssSelector("#identifierNext")).click();

			}else
			{
				driver.findElement(By.cssSelector("#password input")).sendKeys(text);
				driver.findElement(By.cssSelector("#passwordNext")).click();
				
				
			}
			//email.clear();
		//email.sendKeys(text);
	/*	if(sendEnter){
			elm.sendKeys(text);	
		}else{
			
			elm.sendKeys(Keys.TAB);
		}*/
			return false;

			
		}
		
		public boolean clickOnNextButton(){
	/*	if(!isDispaly()){
			WaitForPopup(2);
		}else*/ // #profileIdentifier
			if(driver.findElement(By.cssSelector("#headingSubtext")) != null){
			driver.findElement(By.cssSelector("#identifierNext")).click();
			//nextBtn.click();
			}else{
			driver.findElement(By.cssSelector("#passwordNext")).click();
			}
			return false;
		}
		
		
		public WebElement WaitForPopup(int time) {
			return WaitForPopup(defaultWaitTime);

			
		}
	/*	
		public boolean isDispaly(){
			
			
			try{
				
			WebDriverWait wait= new WebDriverWait(WebDriver driver, 3);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(defaultPopupFrame));
			if(driver.getTitle().equals(""))
			return true;
			}catch(Exception e){
				
			}
			return false;
		}
	*/
		
		
		
		
	}
