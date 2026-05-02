## Bug 1
Brief description: The Computer constructor incorrectly initializes the attribute memory to a value of 10, ignoring the provided parameter.

Failed unit test: testConstructorMemory()

## Bug 2
Brief description: The Computer constructor incorrectly initializes the attribute price to a value of 0, ignoring the provided parameter. 

Failed unit test: testConstructorPrice()

## Bug 3
Brief description:  the method setOS sets the OS to "none" instead of updating it to the new Os input. 

Failed unit test: testSetOS

## Bug 4
Brief description:  the buy function overwrites the computer we want to add to the inventory with a 2019 Macbook computer. We do not end up adding our own computer. 
Failed unit test: testBuy

## Bug 5
Brief description: The Buy function buys a computer without checking first if it already exists in the inventory. It ends up adding the same exact computer twice... which shouldn't be possible 
Failed unit test: testDoubleBuy

## Bug 6
Brief description:  The function can not throw an Runtime exception if a computer not in its inventory is being sold. 
Failed unit test: testSell

## Bug 7
Brief description: A computer older than 2012 (but newer than 2000) should have a price of 250$, but refurbish gives it a price of 2500$  
Failed unit test: testRefurbish2012

## Bug 8
Brief description:  Refurbish method is not flexible: does not take optional strings for the newOS parameter. If the user were to input null (so the user is trying to avoid inputing a newOS string), then refurbish() changes the OS to None instead of keeping the original value. This makes it harder for user interface. An overloaded method of refurbish that takes 1 parameter instead of 2 could be helpful to make newOS an optional parameter. 
Failed unit test: testRefurbishNull()

## Bug 9
Brief description : Refurbish method is not flexible. Different variations of "None" such as "none" change the OS to None instead of keeping the previous OS.
Failed unit test: testRefurbishMispelled()

## Bug 10
Brief description:  The method printInventory() gets interupted after looping through its last iteration because of the number of indices is higher than the length of the inventory. Correct syntax: i < this.inventory.size() 
The test testPrintInventoryException() catches an IndexoutofBounds exception, which means our method runs into one.
Failed unit test: testPrintInventoryException()



