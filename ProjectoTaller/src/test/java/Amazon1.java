import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon1 {

    public static void main(String[] args) {
        /*
         * tc 1
         *
         * */
        WebDriver driver = null;
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        //abrimos el browser
        driver.get("https://www.amazon.com/");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //seleccionamos el textbox de busqueda y colocamos un criterio

        String localizadorXpath = "//*[@id=\'twotabsearchtextbox\']";

        WebElement inputBusqueda = null;

        //driver al colocarle un xpath se convierte en un webelemnt
        inputBusqueda = driver.findElement(By.xpath(localizadorXpath));
        inputBusqueda.sendKeys("zapatillas");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputBusqueda.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String numuno = "//*[@id=\'search\']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/span/a/div/img";

       WebElement numsel = driver.findElement(By.xpath(numuno));
        numsel.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String mensajeObtenido = driver.findElement(By.id("title")).getText();

        System.out.println("Detalle de la zapatilla: "+  (mensajeObtenido));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String mensajeprecio = driver.findElement(By.id("priceblock_ourprice")).getText();

        System.out.println("El precio  es:"+ (mensajeprecio));




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            driver.close();

    }


}
