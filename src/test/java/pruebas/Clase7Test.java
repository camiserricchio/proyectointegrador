package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase7Test {
	String url = "http://automationpractice.pl/";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get (url);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio (driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correodealguien@gmail.com");
		login.escribirPassword("nadiesabe123");
		login.hacerClicEnLogin();
	}
	
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
		
	}
}
