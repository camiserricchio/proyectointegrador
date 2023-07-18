package Edit.EducacionIT;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase4Test {
	String url = "http://automationpractice.pl/index.php";
	
	@Test
	public void registrarUsuario () {
		// Abrir el navegador en URL indicada
		
		WebDriver driver = new FirefoxDriver ();
		driver.get(url);
		
		// Hacer clic en "Sing In"
		
		WebElement LnkSign = driver.findElement(By.partialLinkText("Sign"));
		
		LnkSign.click();
				
		// Escribir correo y hacer click en boton
		WebElement txtEmail = driver.findElement (By.name("email_create"));
		
		txtEmail.sendKeys("correo23may2023@gmail.com");
		
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		//Agregar Espera. En transicion de pagina se recomienda  explicita
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender2")));
				
		// Completar el formulario
		
		WebElement radTitle = driver.findElement(By.cssSelector("#id_gender2"));
		radTitle.click();
		
		WebElement txtFirtname = driver.findElement(By.id("customer_firstname"));
		txtFirtname.sendKeys("Noelia");
		
		WebElement txtLastName = driver.findElement(By.name("customer_lastname"));
		txtLastName.sendKeys("Rodriguez");
		
		String correoAutilizar = "correo" + Math.random() +"@gmail.com";
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.clear();
		email.sendKeys(correoAutilizar);
		
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.sendKeys("contraseñasecreta");
		
		Select listDays = new Select(driver.findElement(By.id("days")));
		listDays.selectByVisibleText("18  ");
		
		Select listMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		listMonths.selectByValue("6");
		
		Select listYears = new Select(driver.findElement(By.cssSelector("#years")));
		listYears.selectByIndex(30);
		
		WebElement chkNewsLater = driver.findElement(By.name("newsletter"));
		chkNewsLater.click();
		
		WebElement chkOptin = driver.findElement(By.id("optin"));
		chkOptin.click();
		
		// Hacer click en "register"
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		
		
	}
}
	
	
	
