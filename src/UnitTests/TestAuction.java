/**
 * 
 */
package UnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AuctionDatabase.Auction;
import AuctionDatabase.Wine;
import AuctionDatabase.Offer;
import AuctionDatabase.TypeOfWine;
/**
 * @author Simon
 *
 */
public class TestAuction {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}


	/**
	 * Test method for {@link Auction#addOffer(Offer)}.
	 */
	@Test
	public void testAddOffer() {
		Auction a= new Auction(new Wine(456, TypeOfWine.red, "vino", 29.9, 5416));
		Offer f= new Offer(30.9);
		assertEquals(a.addOffer(f),"Offer added");
		
	}

	/**
	 * Test method for {@link Auction#getLastOffer()}.
	 */
	@Test
	public void testGetLastOffer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Auction#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Auction#Auction(Wine)}.
	 */
	@Test
	public void testAuctionWine() {
		fail("Not yet implemented");
	}
	/**
	 * Test method for {@link Auction#Auction(Wine, Offer)}.
	 */
	@Test
	public void testAuctionWineOffer() {
		fail("Not yet implemented");
	}

}
