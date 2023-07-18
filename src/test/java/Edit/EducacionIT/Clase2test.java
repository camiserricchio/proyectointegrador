package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2test {
	//URL:
	String url = "http://automationpractice.pl/index.php";
	@Test
	public void buscarPalabraFirefox() {
		//Paso 1 : Abrir el navegador
		WebDriver navegador = new FirefoxDriver();
		
		//Paso 2: Acceder a la pagina automationpactice.pl
		navegador.get(url);
		
		//Paso 3: Escribir la palabra buscar
		//Paso 3.1: Buscar al elemento que representa al campo de texto
		WebElement campoTexto = navegador.findElement(By.id("search_query_top"));
		
		//Paso 3.2: Escribir la palabra en ese elemento
		
		campoTexto.sendKeys("dress");
		
		//Paso 4: Hacer la búsqueda
		
		campoTexto.sendKeys(Keys.ENTER); // keys.Simula que presionamos la tecla 
	}
	
	@Test
	public void buscarPalabraChrome() {
		//Paso 1 : Abrir el navegador
		WebDriver navegador = new ChromeDriver();
		
		//Paso 2: Acceder a la pagina automationpactice.pl
		navegador.get(url);
		
		//objeto webdriver puede maximizar la ventana
		navegador.manage().window().maximize();
		
		//Borrar las cookies
		navegador.manage().deleteAllCookies();
		
		//Imprimir en consola el titulo de la pagina
		System.out.println(navegador.getTitle());
		
		// imprimir url
		
		System.out.println (navegador.getCurrentUrl());
		
		
		//Paso 3: Escribir la palabra buscar
		//Paso 3.1: Buscar al elemento que representa al campo de texto
		WebElement campoTexto = navegador.findElement(By.id("search_query_top"));
		
		//Paso 3.2: Escribir la palabra en ese elemento
		
		campoTexto.sendKeys("dress");
		
		
		//Paso 4: Hacer la búsqueda
		
		campoTexto.sendKeys(Keys.ENTER); // keys.Simula que presionamos la tecla 
		
		System.out.println(navegador.getTitle());
		
		navegador.close(); // cierra la pestaña
		navegador.quit(); //Cierra todas las pestañas
		
	}

}
