package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmericanasCompras {
	
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\elthe\\Desktop\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		//Acessa site da loja
		driver.get("http://americanas.com.br");
		assertTrue("Título da Página difere do esperado", driver.getTitle().contentEquals("Americanas - Tudo. A toda hora. Em qualquer lugar.")); //Vereifica se o título da paágina é o título correto
		
		//Procura pelo produto PS4
		WebElement caixaDeBusca = driver.findElement(By.name("conteudo"));
		caixaDeBusca.click();		
		caixaDeBusca.sendKeys("PS4");
		WebElement btnSearchProduto = driver.findElement(By.id("h_search-btn"));
		btnSearchProduto.click();
		Thread.sleep(10000);
		
		//Seleciona o primeiro Produto
		WebElement produto = driver.findElement(By.xpath("//*[@id='content-middle']/div[6]/div/div/div/div[1]/div[1]/div/div[2]/a/section"));
		produto.click();
		Thread.sleep(10000);
		
		//Verifica se o CEP está dispoível para entrega
		WebElement inserirCep = driver.findElement(By.id("freight-field"));
		inserirCep.click();
		inserirCep.sendKeys("50740535");		
		WebElement btnProcuraCep = driver.findElement(By.id("freight-field-button"));
		btnProcuraCep.click();
		Thread.sleep(10000);			
		
		//Imprimrir valor do frete
		WebElement valorFrete = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/section/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/div/span[2]"));
		String valor = valorFrete.getText();		
		System.out.println(valor);
		Thread.sleep(5000);			
	
		//Clica em comprar
		WebElement btnCompra = driver.findElement(By.id("btn-buy"));
		btnCompra.click();
		Thread.sleep(10000);
		
		//Adiciona garantia de 12 meses
		WebElement bntGarantia = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/main/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/label"));
		bntGarantia.click();
		Thread.sleep(10000);
		
		//Continua a compra clicando em continuar
		WebElement btnContinuaCompra = driver.findElement(By.xpath("//*[@id=\"btn-continue\"]/div"));
		btnContinuaCompra.click();
		Thread.sleep(10000);
		
		//Verifica se a Cesta está vazia		
		WebElement itensCesta = driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/div[1]/section/ul"));
		String cesta = itensCesta.getText();
		if (cesta.isEmpty()){
			System.out.println("A cesta está vaiza.");
		}
		else{
			System.out.println("A Cesta não está vazia");
		}
		Thread.sleep(1000);

	}	

}
