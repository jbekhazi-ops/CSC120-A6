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

    @Test(timeout = TIMEOUT)
    public void testSetPrice(){
        comp.setPrice(700);
        assertEquals(700, comp.price);
    }
    
    @Test(timeout = TIMEOUT)
    public void testSetOS(){
        comp.setOS("new OS");
        assertEquals("new OS", comp.operatingSystem);
    }
    // first bug, the method setOS sets the OS to none instead of the new Os input. 

    @Test(timeout = TIMEOUT)
    public void testGetYear(){
        assertEquals(2017, comp.yearMade);
    }

    @Test(timeout = TIMEOUT)
    public void testBuy(){
        shop.buy(comp);
        int inventorySize = shop.inventory.size();
        assertEquals(comp, shop.inventory.get(inventorySize - 1));   
    }

    @Test(timeout = TIMEOUT)
    public void testDoubleBuy(){
        shop.buy(comp);
        int sizeBefore = shop.inventory.size();
        shop.buy(comp);
        int sizeAfter = shop.inventory.size();
        assertEquals(sizeBefore, sizeAfter); 
    }  


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSell(){
        shop.sell(comp);
    }

    @Test(expected = RuntimeException.class)
    public void testSellAnother(){
        shop.sell(comp);
        // ?? idk which one, we could also use this with the buy function perhaps 
    }

    @Test(timeout = TIMEOUT)
    public void testRefurbish2000(){
        comp.yearMade = 1999;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(0, comp.price);
    }

    @Test(timeout = TIMEOUT)
    public void testRefurbish2012(){
        comp.yearMade = 2011;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(250, comp.price);
    }

    @Test(timeout = TIMEOUT)
    public void testRefurbish2018(){
        comp.yearMade = 2017;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(550, comp.price);
    }

    @Test(timeout = TIMEOUT)
    public void testRefurbishElse(){
        comp.yearMade = 2019;
        shop.inventory.add(comp);
        shop.refurbish(comp, "None");
        assertEquals(1000, comp.price);
    }

    @Test(timeout = TIMEOUT)
    public void testRefurbishNewOs(){
        shop.inventory.add(comp);
        shop.refurbish(comp, "new OS");
        assertEquals("new OS", comp.operatingSystem);
    }  
    
    @Test(expected = RuntimeException.class)
    public void testRefurbishException(){
        shop.refurbish(comp, "new OS");
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testPrintInventory(){
        try{
            shop.inventory.add(comp);
            shop.printInventory();
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    @Test(expected = RuntimeException.class)
    public void testPrintInventoryRuntime(){
        try{
            shop.inventory.add(comp);
            shop.printInventory();
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testPrintEmptyInventory(){
        try{
            shop.printInventory();
        }
        catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

}

