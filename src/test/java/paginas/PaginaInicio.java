package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Atributos: Elementos web de la pagina que voy a probar
	@FindBy (partialLinkText = "Sign")
	WebElement lnkSignIn;
	
	// Constructor
	public PaginaInicio (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones: cada accion que necesitemos hacer en la prueba
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	 
	
}
