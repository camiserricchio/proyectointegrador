package Edit.EducacionIT;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase5Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	String dirEvidencias = "..\\JavaNoProgramadores\\EducationIT\\Evidencias\\";
	String nombreDocumento = "Documento de Envidencias.docx";
	File screen;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test (description = "CO01 - Buscar palabra en AutomationPractice", priority = 1)
	public void buscarPalabra() throws IOException {
		// Captura de evidencia : Pagina Principal
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PaginaPrincipal.jpg"));
		
		
		// Escribir palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		//Captura de evidencia: Palabra a Buscar
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_PalabraABuscar.jpg"));
		
		// Hacer la búsqueda
		WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		btnBuscar.click();
		
		//Capturad de Evidencia: Resultado de Busqueda
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_ResultadoDeBusqueda.jpg"));
		
		// Chequear que el título cambió a "Search - My Store"
				String tituloEsperado = "Search - My Store";
				String tituloActual = driver.getTitle(); // devuelve el titulo
				
				Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	
	
	@Test	
	public void irAContactanos () throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencia
				CapturaEvidencia.escribirTituloEnDocumento(
						dirEvidencias + nombreDocumento, 
						"Documento de Evidencias AutomationPractice", 
						20);
				CapturaEvidencia.capturarPantallaEnDocumento(
						driver,
						dirEvidencias + "img.jpg",
						dirEvidencias + nombreDocumento,
						"Pantalla inicial del Sistema");

		//Hacer click en Contact Us
		WebElement btnContact = driver.findElement(By.id("contact-link"));
		btnContact.click();
		
		// Captura de Evidencia
				CapturaEvidencia.capturarPantallaEnDocumento(
						driver,
						dirEvidencias + "img.jpg",
						dirEvidencias + nombreDocumento,
						"Pantalla Luego de hacer clic en Contact Us");
		
		//Completar formulario
		Select SelSubject = new Select(driver.findElement(By.id("id_contact")));
		SelSubject.selectByVisibleText("Customer service");
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correodealguien@gmail.com");
		WebElement txtOrder = driver.findElement(By.id("id_order"));
		txtOrder.sendKeys("1543KJM");
		//Adjuntar archivo
		WebElement FilAdjunto = driver.findElement(By.cssSelector("#fileUpload"));
		FilAdjunto.sendKeys("C:\\Users\\Asus\\Downloads\\Pedidpo Stickers Cami.pdf");
		WebElement txtMessage = driver.findElement(By.id("message"));
		txtMessage.sendKeys("Hola");
		
		// Captura de Evidencia
				CapturaEvidencia.capturarPantallaEnDocumento(
						driver,
						dirEvidencias + "img.jpg",
						dirEvidencias + nombreDocumento,
						"Pantalla Despues de completar el Formulario");
		
		//Hacer clic en el boton
		WebElement btnSend = driver.findElement(By.name("submitMessage"));
		btnSend.click();
		
		// Captura de Evidencia
				CapturaEvidencia.capturarPantallaEnDocumento(
							driver,
							dirEvidencias + "img.jpg",
							dirEvidencias + nombreDocumento,
							"Pantalla Luego de hacer clic en Send");
			}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
		
	}
