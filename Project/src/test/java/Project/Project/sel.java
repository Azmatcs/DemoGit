package Project.Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sel {
	WebDriver driver;
	

	@BeforeClass
	void setup() {

		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://staging-web.wise.live/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}

	@Test
	void Login() {
		driver.findElement(By.xpath("//span[normalize-space()='Continue with Mobile']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys("1111100000");
		driver.findElement(By.xpath("//span[normalize-space()='Get OTP']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='one-time-code']")).sendKeys("0000");
		driver.findElement(By.xpath("//span[normalize-space()='Verify']")).click();

		String ActualInstutueName = driver.findElement(By.xpath("//span[text()='Testing Institute']")).getText();
		Assert.assertEquals(ActualInstutueName, "Testing Institute");
	}

	@Test(priority = 1)
	void ClassRoom() {
		driver.findElement(By.xpath("//div[normalize-space()='Group course']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Classroom for Automated testing']")).click();
		String ActualClassRoomName = driver.findElement(By.xpath("//div[text()='Classroom for Automated testing']")).getText();
		Assert.assertEquals(ActualClassRoomName, "Classroom for Automated testing");
	}
	
	@Test (priority = 2)
	void ScheduleSession() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='#livesessions']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Sessions']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Add session']")).click();
	
		
	}

}
