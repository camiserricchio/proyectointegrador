package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8Test {
	String url = "http://automationpractice.pl/";
	WebDriver driver;
	String dirDatos = "..\\JavaNoProgramadores\\EducacionIT\\Datos\\";
	String nombreDocumento = "DatosLogin_08Jun2023.xlsx";
	String nombreHoja = "Hoja1";
	
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		driver.get (url);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio (driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider (name= "Datos Login Excel")
	public Object [][] obtenerDatosExcel () throws Exception {
		Object [][] datos = null;
		
		//Llenar la matriz datos con la informacion de un excel
		datos = DatosExcel.leerExcel(dirDatos + nombreDocumento, nombreHoja);
		
		return datos;
	
	}
	
	
	@DataProvider (name = "Datos Login")
	public Object [] [] obtenerDatos () {
		Object [] [] datos = new Object [3][2];
		
		datos [0][0] = "a@mail.com";
		datos [0][1] = "as8as5v";
		
		datos [1][0] = "b@mail.com";
		datos [1][1] = "asc8as6f";
		
		
		
		return datos;
	}
	
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
		
	}
}