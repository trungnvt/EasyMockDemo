/**
 * 
 */
package fsoft.trungnvt.easyMock.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import fsoft.trungnvt.easyMock.Portfolio;
import fsoft.trungnvt.easyMock.Stock;
import fsoft.trungnvt.easyMock.service.StockService;

/**
 * @author TrungNVT
 *
 */
public class PortfolioTest extends TestCase {

	Portfolio portfolio;
	StockService stockService;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		 //Create a portfolio object which is to be tested	
		portfolio = new Portfolio();
		
		//Create the mock object of stock service
		stockService = EasyMock.createMock(StockService.class);
		
		portfolio.setStockService(stockService);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link fsoft.trungnvt.easyMock.Portfolio#getMarketValue()}.
	 */
	public void testGetMarketValue() {
		//Create a list of stocks to be added to the portfolio
	      List<Stock> stocks = new ArrayList<Stock>();
	      Stock googleStock = new Stock("1","Google", 10);
	      Stock microsoftStock = new Stock("2","Microsoft",100);
	      
	      stocks.add(googleStock);
	      stocks.add(microsoftStock);
	      
	      //add Stock to the porfolio
	      portfolio.setStocks(stocks);
	      
	      //Mock the behavior of stock service to return the value of various stocks
	      EasyMock.expect(stockService.getPrice(googleStock)).andReturn(50.00);
	      EasyMock.expect(stockService.getPrice(microsoftStock)).andReturn(1000.00);
	      
	      //activate the mock
	      EasyMock.replay(stockService);
	      
	      double marketValue = portfolio.getMarketValue();
	      assertEquals(100500.0, marketValue);
	      
	} 

}
