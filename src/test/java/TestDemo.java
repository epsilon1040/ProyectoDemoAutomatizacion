import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.junit.*;
//import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import static Pruebas.Driver.*;
import junit.framework.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 *
 * @author 1415506
 */
public class TestDemo {
    
    public TestDemo() {
    }
    
    WebDriver driver;
    
    
    @BeforeClass
    public static void setUpClass() {
       // chrome();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
      URL serverurl = new URL("https://boya678:6db6a871-5bfd-456f-b8b1-c0195cb26b2d@ondemand.saucelabs.com:443/wd/hub");
            DesiredCapabilities capabilities =new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            driver = new RemoteWebDriver(serverurl,capabilities);
       driver.get("http://18.217.78.140:8080/WsDemo/");
    }
    
    //@Ignore
    @Test
    public void registrarDatos() throws InterruptedException {
        Thread.sleep(2000);
        WebElement datoInicial = driver.findElement(By.id("temperatura"));
        datoInicial.sendKeys("32");
        Thread.sleep(2000);
                
        Select ConversionOrigen = new Select(driver.findElement(By.name("fUnidad")));
        ConversionOrigen.selectByIndex(1);
        Thread.sleep(2000);

        Select ConversionDestino = new Select(driver.findElement(By.name("tUnidad")));
        ConversionDestino.selectByIndex(2);
        Thread.sleep(2000);
      
        //WebElement btnConvertir = driver.findElement(By.xpath("//*[@id=\'frmBuscar\']/button"));
        WebElement btnConvertir = driver.findElement(By.xpath("//*[@id=\'frmBuscar\']/div[4]/div/button"));
        btnConvertir.click();
        Thread.sleep(2000);
        
        WebElement resultado = driver.findElement(By.id("resultado"));
        Thread.sleep(2000);
        System.out.println("salida es" +  resultado.getText());
        Assert.assertEquals("La temperatura es = 89.6", resultado.getText());
        
    }
    //@Ignore
    @Test
    public void registroVacio() throws InterruptedException {
        Thread.sleep(2000);
        WebElement datoInicial = driver.findElement(By.id("temperatura"));
        datoInicial.sendKeys("0");
        Thread.sleep(2000);
                
        Select ConversionOrigen = new Select(driver.findElement(By.name("fUnidad")));
        ConversionOrigen.selectByIndex(0);
        Thread.sleep(2000);

        Select ConversionDestino = new Select(driver.findElement(By.name("tUnidad")));
        ConversionDestino.selectByIndex(0);
        Thread.sleep(2000);
      
        //WebElement btnConvertir = driver.findElement(By.xpath("//*[@id=\'frmBuscar\']/button"));
        WebElement btnConvertir = driver.findElement(By.xpath("//*[@id=\'frmBuscar\']/div[4]/div/button"));
        btnConvertir.click();
        Thread.sleep(3000);
        
        WebElement resultado = driver.findElement(By.id("resultado"));
        
        System.out.println("salida vacia es" +  resultado.getText());
        Assert.assertEquals("", resultado.getText());
        
    }
    
       @After
    public void tearDown() throws InterruptedException{
        driver.close();        
        
    }
  
}
