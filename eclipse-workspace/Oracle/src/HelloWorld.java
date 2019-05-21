import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://sidb5.gda.itesm.mx:7789/escolar/tesoreria_cursables.login");
		
		//WebElement inputSearch = driver.findElementById("lst-ib");
		//WebElement searchButton = driver.findElementByName("btnK");
		
		//inputSearch.sendKeys("Memo es puto");
		//searchButton.click();
		
		WebElement matricula = driver.findElementByName("p_matricula");
		WebElement contraseña = driver.findElementByName("p_password");
		//WebElement aceptar = driver.findElement(By.xpath("input[@value='Aceptar']"));
		WebElement aceptar = driver.findElementByXPath("//input[@value='Aceptar']");
		matricula.sendKeys("A01632947");
		contraseña.sendKeys("Me294?83");
		aceptar.click();
		
		WebElement consultar = driver.findElementByXPath("//input[@value='Consultar turno']");
		consultar.click();
		
		
		
	}
}
