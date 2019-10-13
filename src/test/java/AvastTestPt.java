import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class AvastTestPt {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		Path path = FileSystems.getDefault().getPath("src/main/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", path.toString());
		driver = new FirefoxDriver();
	}

	@Test
	public void testAvastPt() {
		driver.get("https://www.avast.com/pt-br/lp-business-aff-secureline-45");
		WebElement cookies = driver.findElement(By.className("js-close"));
		if (cookies.isDisplayed())
			cookies.click();
		// driver.findElement(By.id("1year5pcs")).click();
		String price = driver.findElement(By.className("smb-abox_price_discounted")).getText();
		driver.findElement(By.className("smb-abox_btn-box-wrapper")).findElement(By.tagName("a")).click();
		String cartPrice = driver.findElement(By.className("av_streetPrice")).getText();
		Assert.assertEquals(price, cartPrice);

	}
	@AfterClass
	public static void cleanUp() {
		if (driver != null) {
			driver.close();

		}
	}

}
