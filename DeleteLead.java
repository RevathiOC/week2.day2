package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String findLeadId = driver.findElement(By.xpath(
				"//div[text()='Lead ID']/../../../../../../../following::div//div[1]/div[1]/table/tbody/tr[1]/td[1]/div/a"))
				.getText();
		System.out.print("FindLeadid: " + findLeadId);
		driver.findElement(By.xpath(
				"//div[text()='Lead ID']/../../../../../../../following::div//div[1]/div[1]/table/tbody/tr[1]/td[1]/div/a"))
				.click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(findLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed()) {
			System.out.print("As expected no record is displayed for the deleted lead");
		} else {
			System.out.print("Lead id record is present");
		}
		driver.close();

	}
}
