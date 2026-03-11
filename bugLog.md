## Bug 1
Brief description:  the method setOS sets the OS to none instead of updating it to the new Os input. 

Failed unit test: testSetOS

## Bug 2
Brief description:  the buy function overwrites the computer we want to add to the inventory with a 2019 Macbook computer. We do not end up adding our own computer. 
Failed unit test: testBuy

## Bug 3
Brief description: The Buy function buys a computer without checking first if it already exists in the inventory. 
Failed unit test: testDoubleBuy

## Bug 4
Brief description:  The function can not handle a computer not in its inventory being sold. 
Failed unit test: testSell

## Bug 5
Brief description: A computer older than 2012 (but newer than 2000) should have a price of 250$, but refurbish gives it a price of 2500$  
Failed unit test: testRefurbish2012

## Bug 6
Brief description:  This function fails because the setOs function also fails and we debugged it earlier. (idk if it counts as its own error? or its caused because of an error above so we dont count it)
Failed unit test: testRefurbishSetOS

## Bug 7
Brief description:  Refurbish method is not flexible, mispellings of "None". changes the OS to None. It would be more efficient with an optional string
Failed unit test: testRefurbishNull()

## Bug 8
Brief description:  Since we are not catching the exception, we also run through a Runtime Error in the printInventory() function. 
Failed unit test: testPrintInventoryRuntime()

## Bug 9
Brief description:  printInventory() does not catch the IndexOutOfBoundError it produces which then disrupts the code.
Failed unit test: testPrintInventory()

## Bug 10
Brief description:  
Failed unit test: 