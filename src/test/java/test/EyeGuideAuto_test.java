package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import newpackage.*;


//import org.openqa.selenium.interactions.Actions;
import test.names;
import java.util.*;

//import javax.swing.JScrollPane;
public class EyeGuideAuto_test {
	// System.out.println("Test Case 1");
	WebDriver driver;
	//String fn=names.fn();
	//String ln=names.ln();
	//System.setProperty("webdriver.ie.driver","F:\\Browser IE driver files\\IEDriverServer.exe");
	//WebDriver driver = new InternetExplorerDriver();

	//public static WebDriver driver = new InternetExplorerDriver();

	//Login and Login as with terms and conditions acceptance
	@Test
	public void LoginandLoginas() throws InterruptedException{

		//WebDriver driver = new FirefoxDriver();
		//	DesiredCapabilities cap=new DesiredCapabilities();
		//	cap.setCapability("requireWindowFocus", true);

		System.setProperty("webdriver.chrome.driver","F:\\Browser Chrome Driver files\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","F:\\Browser Gecko Driver files\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver","F:\\Browser IE driver files\\IEDriverServer.exe");


		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.get("http://10.6.6.132:3000/login");
		Thread.sleep(2000);
		driver.findElement(By.name("phoneInput")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("phoneInput")).sendKeys("superadmin");
		driver.findElement(By.xpath("//div[@id='root']/div/div/div[4]/div[2]/div[2]/span/input")).sendKeys("super");
		driver.findElement(By.xpath("//div[@id='root']/div/div/div[5]/div/div[2]/button")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[3]/button[1]")).click();
		}catch(Exception e){
			System.out.println("Terms and Conditions already accepted");
		}
		Thread.sleep(3000);
		try {

			driver.findElement(By.xpath("//*[@class='ant-btn btnLoginAs']")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@class='ant-select-selection__rendered']/div[text()='Select an Organization']")).click();
			//s.sendKeys(m);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='ant-select-search__field']")).sendKeys("ABCD");
			//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ant-select-selection__placeholder"))).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".ant-select-dropdown-menu-item")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='ant-btn confirmBtn ant-btn-primary']")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			System.out.println("Logged in as User or Organization admin");
		}
	}


	//public class Teste extends Test_EyeGuide{
	@Test
	public void ProfileAddUpload() {//Add Profile & UPLOAD PROFILE
		System.out.println("Test Case 2");
		try {
			driver.findElement(By.xpath("//*[@class='anticon anticon-menu-unfold trigger']")).click();
		}catch(Exception e) {System.out.println("Trigger folded");}
		try {
			//			Thread.sleep(2000);
			//			driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/ul/li[2]/div/span/span")).click();
			//			Thread.sleep(2000);
			//			driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/span")).click();
			//Thread.sleep(2000);


			//			//Add Profile Start
			//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ant-menu-submenu ant-menu-submenu-inline']//div[@class='ant-menu-submenu-title' and @aria-owns='rosters$Menu']//i[@class='anticon anticon-table']"))).click();
			//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div > div.sidepaneB.ant-layout-sider > div > ul > li.ant-menu-submenu.ant-menu-submenu-inline > div"))).click();
			//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("anticon anticon-table"))).click();
			try {
				List<WebElement> e1 = driver.findElements(By.xpath("//*[@class='ant-menu-submenu-title']"));

				e1.get(0).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//ul[@id='rosters$Menu']/li/div[@class='ant-menu-submenu-title']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[@class='ant-menu-item ant-menu-item-selected']/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[@class='ant-menu-item']/a[starts-with(@href,'/profile/')]")).click();
				Thread.sleep(2000);
			}catch(Exception e) {
				Actions a =new Actions(driver);
				WebElement ty=driver.findElement(By.xpath("//i[@class='anticon anticon-table']"));
				a.moveToElement(ty).build().perform();
				Thread.sleep(2000);
				List<WebElement> sy=driver.findElements(By.xpath("//div[@class='ant-menu-submenu-title']"));
				List<WebElement> rr=driver.findElements(By.xpath("//a[text()='Profiles']"));
				JavascriptExecutor jss=(JavascriptExecutor)driver;
				jss.executeScript("arguments[0].click();", rr.get(0));
				System.out.println("Element located");
				Thread.sleep(2000);
			}

			///////UPLOAD CODE

			driver.findElement(By.cssSelector("div.ant-card-body:nth-child(2) > a:nth-child(2) > button:nth-child(1)")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".ant-btn-primary")).click();
			Thread.sleep(2000);
			WebElement we=driver.findElement(By.cssSelector("input.csv-input"));
			Thread.sleep(2000);
			we.sendKeys("F:\\eclipse\\File Handling\\demofile.csv");
			Thread.sleep(10000);
			driver.findElement(By.cssSelector(".buttonLeft > button:nth-child(1)")).click();
			Thread.sleep(2000);
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			List<WebElement> elements = driver.findElements(By.xpath("//*[@class='ant-select-arrow']"));
			for (int i=0; i<elements.size();i++){
				System.out.println("Radio button text:" + elements.get(i));
			}

			List<WebElement> elements1 = driver.findElements(By.xpath("//li[@class='ant-select-dropdown-menu-item']"));
			for (int i=0; i<elements1.size();i++){
				System.out.println("Radio button text:" + elements1.get(i));
			}
			System.out.println("List Printed");

			elements.get(0).click();

			driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item' and text()='First Name']")).click();
			Thread.sleep(5000);
			elements.get(1).click();
			//		
			//WebDriverWait wait1 = new WebDriverWait(driver, 10);

			JavascriptExecutor jse = (JavascriptExecutor) driver; // (driver is your browser webdriver object) 


			Thread.sleep(2000);
			WebElement es=driver.findElement(By.cssSelector("body > div:nth-child(10) > div > div > div > ul > li:nth-child(3)"));
			//wait1.until(ExpectedConditions.invisibilityOf(es));
			Thread.sleep(2000);
			jse.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
			jse.executeScript("arguments[0].scrollIntoView(true)", es);
			jse.executeScript("arguments[0].click()", es);

			Thread.sleep(5000);

			Thread.sleep(3000);

			driver.findElement(By.cssSelector("div.ant-row:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("body > div:nth-child(11) > div > div > div > ul > li:nth-child(4)")).click();

			Thread.sleep(2000);
			try {
				//			driver.manage().window().maximize();
				//			JavascriptExecutor jse = (JavascriptExecutor)driver;
				//			Thread.sleep(2000);
				//			jse.executeScript("window.scrollBy(0,250)", "");
				//Thread.sleep(2000);

				driver.findElement(By.cssSelector("div.ant-row:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
				Thread.sleep(3000);
				//	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/ul/li[5]")));
				driver.findElement(By.xpath("/html/body/div[7]/div/div/div/ul/li[5]")).click();
			}catch(Exception e) {
				e.printStackTrace();
			}



			Thread.sleep(2000);

			driver.findElement(By.cssSelector("div.ant-row:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[8]/div/div/div/ul/li[6]")).click();

			Thread.sleep(2000);

			driver.findElement(By.cssSelector("div.ant-row:nth-child(6) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[9]/div/div/div/ul/li[7]")).click();
			driver.findElement(By.cssSelector(".ant-btn-primary")).click();
			Thread.sleep(2000);
			try {
				try {
					driver.findElement(By.cssSelector("tr.rows:nth-child(1) > td:nth-child(1) > span:nth-child(1)")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/span/label/span/input")).click();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				try {
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[2]/td[1]/span")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[3]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/span/label/span/input")).click();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				try {
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[3]/td[1]/span")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[4]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/span/label/span/input")).click();
				}catch(Exception e) {
					e.printStackTrace();
				}
				try {
					driver.findElement(By.xpath("//*[@id=\"layout\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[4]/td[1]/span")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"layout\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[5]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/span/label/span/input")).click();
				}catch(Exception e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				try {
					driver.findElement(By.xpath("//*[@id=\"layout\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[5]/td[1]/span")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"layout\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div/table/tbody/tr[6]/td[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/span/label/span/input")).click();
				}catch(Exception e) {
					e.printStackTrace();
				}

				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[2]/div/button")).click();

			}catch(Exception e) {
				System.out.println("No duplicates");
				//e.printStackTrace();
			}
			Thread.sleep(2000);

			driver.findElement(By.cssSelector(".downloadBtn")).click();

			Thread.sleep(2000);
			System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Profiles Updated: ']"))).getText()+
					new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2][@class='ant-col-5 infoCol']"))).getText());
			System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Total Profiles Uploaded: ']"))).getText()+
					new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2][@class='ant-col-5']"))).getText());
			//Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[3]/div/div/div/button")).click();






			///////UPLOAD CODE
String fn=test.names.fn();
String ln=test.names.ln();

			driver.findElement(By.xpath("//div[@class='ant-card-body']//a[starts-with(@href,'/profile/add')]//button[@class='ant-btn ant-btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='ant-input fill' and @placeholder='e.g. Johnny']")).sendKeys(fn);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='ant-input fill' and @placeholder='e.g Thomas']")).sendKeys(ln);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".ant-calendar-picker-input")).click();
			Thread.sleep(3000);

			driver.findElement(By.cssSelector(".ant-calendar-today > div:nth-child(1)")).click();
			//			Thread.sleep(3000);
			//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
			//			Thread.sleep(3000);
			//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[1]/div/span/a[1]")).click();
			//			Thread.sleep(3000);
			//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
			//			Thread.sleep(3000);
			//			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[4]/td[2]/div")).click();
			//			Thread.sleep(2000);
			//			driver.findElement(By.cssSelector(".ant-btn-primary")).click();
			//			Thread.sleep(2000);
			WebElement w=driver.findElement(By.xpath("//*[@class='ant-select-selection-selected-value' and @title=' ,Select Gender, ']"));
			//			Select s=new Select(w);
			//			s.selectByVisibleText("Male");
			w.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[text()='Female']")).click();
			Thread.sleep(5000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']"))).click();
			System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']"))).getText());
			//Thread.sleep(5000);

			//Add Profile End
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='anticon anticon-filter']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='ant-input' and @placeholder='e.g. Johnny']")).sendKeys(fn);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='ant-input' and @placeholder='e.g. Thomas']")).sendKeys(ln);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[@class='ant-modal-footer']//div//button[@class='ant-btn ant-btn-primary']")).click();
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ProfileEdit() throws Exception{//Edit Profile
		driver.findElement(By.xpath("//div/a[starts-with(@href,'/profile/edit/')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Football']")).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary']"))).click();
		System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-message']"))).getText());
		Thread.sleep(3000);
	}

	@Test
	public void ShareTest() throws Exception{//SHARE TEST

		System.out.println("Test Case 4");
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/ul/li[2]/ul/li[1]/ul/li[2]/a")).click();
			Thread.sleep(5000);
			WebElement we=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/span/div/label/span/input"));
			we.click();
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/button[1]")).click();
		}catch(Exception e) {
			Actions a =new Actions(driver);
			WebElement r=driver.findElement(By.xpath("//i[@class='anticon anticon-table']"));
			a.moveToElement(r).build().perform();
			Thread.sleep(2000);
			List<WebElement> k=driver.findElements(By.xpath("//div[@class='ant-menu-submenu-title']"));
			a.moveToElement(k.get(0)).build().perform();
			Thread.sleep(5000);
			List<WebElement> u=driver.findElements(By.xpath("//a[starts-with(@href,'/test/')]"));
			JavascriptExecutor jses=(JavascriptExecutor) driver;
			jses.executeScript("arguments[0].click();",u.get(0));
			Thread.sleep(2000);
			List<WebElement> v=driver.findElements(By.xpath("//*[@class='ant-checkbox-input']"));
			v.get(0).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
		}
		//CATCH NEEDED AND PUT ABOVE
		//String email="ppatharetest@gmail.com";
		for(int i=1;i<=2;i++){
			String r="ppatharetest"+i+"@gmail.com";
			driver.findElement(By.xpath("//*[@placeholder='Enter First Name']")).sendKeys(test.names.fn());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@placeholder='Enter Last Name']")).sendKeys(test.names.ln());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@placeholder='Enter email']")).sendKeys(r);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@placeholder='Re-enter email']")).sendKeys(r);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Add']")).click();
			Thread.sleep(2000);
		}
		//		WebElement ele = driver.findElement(By.xpath("//div[@class='ant-modal-content']/div[@class='ant-modal-footer']/div//button[@class='ant-btn ant-btn-primary']"));
		//		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//		executor.executeScript("arguments[0].click();", ele);

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-modal-content']/div[@class='ant-modal-footer']/div//button[@class='ant-btn ant-btn-primary']"))).click();
		System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ant-message"))).getText());
		Thread.sleep(5000);
	}

	@Test
	public void TestEdit() throws Exception {
		driver.findElement(By.xpath("//a[starts-with(@href,'/viewtest/')]")).click();
		Thread.sleep(2000);
		//	driver.findElement(By.xpath("//*[@class='anticon anticon-left']")).click();
		List<WebElement> elements1 = driver.findElements(By.xpath("//a[starts-with(@href,'/profile/view/')]"));
		for (int i=0; i<elements1.size();i++){
			System.out.println("View Elements:" + elements1.get(i));
		}
		elements1.get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(2000);
		List<WebElement> elements2=driver.findElements(By.xpath("//*[@class='ant-radio-input']"));
		//		for(int i=0;i<=elements2.size();i++) {
		//			System.out.println("View Radio buttons"+i);
		//		}
		WebElement e1=elements2.get(0);
		WebElement e2=elements2.get(1);
		if(e1.isSelected()) {
			e2.click();
		}
		else if(e2.isSelected()) {
			e1.click();
		}

		List<WebElement> elements3=driver.findElements(By.xpath("//*[@class='ant-btn ant-btn-primary']"));
		elements3.get(2).click();
		System.out.println("Test edited Successfully");

		Thread.sleep(5000);
	}

	@Test
	public void UserEdit() throws Exception {
		driver.findElement(By.xpath("//*[@href='/user']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@href,'/user/edit/')]")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@class='ant-select-selection__rendered']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[text()='Organization Admin']")).click();
			Thread.sleep(2000);
		}catch(Exception e) {
			driver.findElement(By.xpath("//*[@class='ant-select-selection__rendered']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ant-select-selection__placeholder' and text()='Select Organization']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item' and text()='ABCDE']")).click();
		}
		//driver.findElement(By.xpath("//div[text()='Select Organization']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//li[text()='"+m+"']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@class='ant-card-body']")).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ant-btn.ant-btn-primary"))).click();
		System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ant-message"))).getText());
		System.out.println("Test Passed");
	}

	@Test
	public void UserUpload() throws Exception{
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/a[2]/button")).click();
		Thread.sleep(3000);
		WebElement we=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/input"));
		Thread.sleep(3000);
		we.sendKeys("F:\\eclipse\\File Handling\\demo.csv");
		Thread.sleep(3000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".downloadBtn"))).click();
		System.out.println(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ant-message"))).getText());
		//driver.findElement(By.cssSelector(".downloadBtn")).click();
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/div[1]/div/div/span[2]/span[1]/a")).click();
		//		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/span[1]/i")).click();
		//		WebElement wes=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[5]/div[3]/div/div/div[1]/label/span[1]/input"));
		//		wes.click();
		//		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[3]/div/button[2]")).click();
		Thread.sleep(5000);
	}
	@AfterTest
	public void CloseDriver(){//Driver close
		System.out.println("Test Case 5");
		driver.close();
	}
}



