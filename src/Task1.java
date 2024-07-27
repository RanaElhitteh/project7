import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void Setup() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void Log_in() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 2)
	public void verifiyTheWordProductIsThere() {
		WebElement TheMainNameOnTheWebSite= driver.findElement(By.xpath("//span[@data-test='title']"));
		boolean ExpectedResult=true;
		boolean ActualTheElementIsThere=TheMainNameOnTheWebSite.isDisplayed();
		Assert.assertEquals(ActualTheElementIsThere, ExpectedResult);
		
	}

	@Test(priority = 3,enabled=true)
	public void SortingItems() throws InterruptedException {
		Thread.sleep(1000);
		WebElement soso = driver.findElement(By.className("product_sort_container"));
		Select MySelctor = new Select(soso);
		MySelctor.selectByVisibleText("Price (low to high)");
		
		List<WebElement> ThePrices = driver.findElements(By.className("inventory_item_price"));
		
		 double TheHighstPrice= Double.parseDouble(ThePrices.get(ThePrices.size()-1).getText().replace("$", ""));
		
		 double TheLowstPrice= Double.parseDouble(ThePrices.get(ThePrices.size()-6).getText().replace("$", ""));
       System.out.println(TheHighstPrice*10);
       System.out.println(TheLowstPrice*10);
       
       boolean expecedValue =true;
        Assert.assertEquals(TheHighstPrice>TheLowstPrice,expecedValue);
		}
	
	
	
	

	}


