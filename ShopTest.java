import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.None;

import java.util.ArrayList;
import javax.management.RuntimeErrorException;
// what it is that you are checking for, we need to find the wrong thing
// we need to identify 10 bugs

public class ShopTest {
    Computer comp;
    ResaleShop shop;


    @Before
    public void setup(){
        this.comp = new Computer("2017 MacBook Pro", "Intel", 256, 16, "High Sierra", 2017, 800);
        this.shop = new ResaleShop();
    }

    private static final int TIMEOUT = 2000;
    // add your tests here 



    /** FAILS
     * Test for the memory parameter in the constructor of the Computer Class
     */
    @Test(timeout = TIMEOUT)
    public void testConstructorMemory(){
        Computer comp = new Computer("description", "processorType", 2, 10, "operatingSystem", 2018, 500);
        assertEquals(10, comp.memory);
    }


    /** FAILS
     * Test for the price parameter in the constructor of the Computer Class
     */
    @Test(timeout = TIMEOUT)
    public void testConstructorPrice(){
        Computer comp = new Computer("description", "processorType", 2, 10, "operatingSystem", 2018, 500);
        assertEquals(500, comp.price);
    }

    /** PASSES
     * Test for the setPrice() method in the Computer class
     * Checks if setPrice sets the price attribute to the expected value.
     */
    @Test(timeout = TIMEOUT)
    public void testSetPrice(){
        comp.setPrice(700);
        assertEquals(700, comp.price);
    }
    
    /** FAILS
     * Test for the SetOs() method in the Computer class
     * Checks if setOs() sets the OS attribute to the given value.
     */
    @Test(timeout = TIMEOUT)
    public void testSetOS(){
        comp.setOS("new OS");
        assertEquals("new OS", comp.operatingSystem);
    }


    /** PASSES
     * Test for the getYear() method in the Computer class
     */
    @Test(timeout = TIMEOUT)
    public void testGetYear(){
        assertEquals(2017, comp.yearMade);
    }

    /** FAILS
     *  Checks whether the buy() method is the ResaleShop class adds the correct computer to the inventory
     */
    @Test(timeout = TIMEOUT)
    public void testBuy(){
        shop.buy(comp);
        int inventorySize = shop.inventory.size();
        assertEquals(comp, shop.inventory.get(inventorySize - 1));   
    }

    /** FAILS
     * Checks whether method buy() in the ResaleShop class checks if the computer already exists in the inventory before buying again
     */
    @Test(timeout = TIMEOUT)
    public void testDoubleBuy(){
        shop.buy(comp);
        int sizeBefore = shop.inventory.size();
        shop.buy(comp);
        int sizeAfter = shop.inventory.size();
        assertEquals(sizeBefore, sizeAfter); 
    }  


    /** FAILS 
     * Checks whether the method sell() can throw an exception if we are trying to sell a computer that is not in its inventory 
     */
    @Test(expected = RuntimeException.class)
    public void testSell2(){
        shop.sell(comp);
    }


    /** PASSES
     * Checks if the second "if" statement of refurbish() behaves as expected 
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbish2000(){
        comp.yearMade = 1999;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(0, comp.price);
    }

    /** FAILS
     * Checks if the first "else if" statement of refurbish() behaves as expected 
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbish2012(){
        comp.yearMade = 2011;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(250, comp.price);
    }

    /** PASSES
     * Checks if the second "else if" statement of refurbish() behaves as expected 
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbish2018(){
        comp.yearMade = 2017;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(550, comp.price);
    }

    /** PASSES
     * Checks if the "else" statement of refurbish() behaves as expected 
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbishElse(){
        comp.yearMade = 2019;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(1000, comp.price);
    }


    /** FAILS
     * Checks whether newOS is an optional parameter, and if user inputs null, then the current OS should remain unchanged.
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbishNull(){
        shop.inventory.add(comp);
        shop.refurbish(comp, null);
        // compare old OS of comp to new OS, it is supposed to not change 
        assertEquals("High Sierra", comp.operatingSystem);
    } 

    /** FAILS
     * Checks if the refurbish() method in ResaleShop class can accept variations of the spelling of "None"
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbishMispelled(){
        shop.inventory.add(comp);
        shop.refurbish(comp, "none");
        // compare old OS of comp to new OS, it is supposed to not change 
        assertEquals("High Sierra", comp.operatingSystem);
    }  

    /** PASSES
     * Test for refurbish() method from ResaleShop class. Compares old OS of comp to new OS, it is supposed to not change if input is "None" 
     */
    @Test(timeout = TIMEOUT)
    public void testRefurbishNone(){
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals("High Sierra", comp.operatingSystem);
    }  
    
    /**Passes
     * Checks if refurbish() throws a RuntimeException if the computer is not in the inventory
     */
    @Test(expected = RuntimeException.class)
    public void testRefurbishException(){
        shop.refurbish(comp, "new OS");
    }

    /** FAILS
     * Checks if method runs into an IndexOutofBounds Exception
     */
    @Test(timeout = TIMEOUT)
    public void testPrintInventoryException(){
        try{
            shop.inventory.add(comp);
            shop.printInventory();
        }
        catch(IndexOutOfBoundsException e){
            fail("Method has an IndexOutofBound exception");
        }
    }




}

