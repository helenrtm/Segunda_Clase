import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon2 {

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

        String detalleProd1 = driver.findElement(By.xpath("//*[@id=\'search\']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/h2/a/span")).getText();

        System.out.println("Detalle de la zapatilla #1: "+  (detalleProd1));

        String precioProd1 = driver.findElement(By.xpath("//*[@id=\'search\']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]")).getText();

        System.out.println("Precio de la zapatilla #1: "+  (precioProd1));

        String precioProd2 = driver.findElement(By.xpath("//*[@id=\'search\']/div[1]/div[2]/div/span[3]/div[2]/div[4]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]\n")).getText();

        System.out.println("Precio de la zapatilla #2: "+  (precioProd2));

        double p1 = Double.parseDouble(precioProd1);
        double p2 = Double.parseDouble(precioProd2);

        if (p1==p2){
            System.out.println ("Los precios son iguales, puede llevar el de su preferencia, precio: " + precioProd1);
            if (p1>p2){
                System.out.println ("La mejor opción de compra el el producto # 2, precio: " + precioProd2);
            }
        }

        System.out.println ("La mejor opción de compra el el producto # 2, precio: " + precioProd2);



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.close();

    }


}
