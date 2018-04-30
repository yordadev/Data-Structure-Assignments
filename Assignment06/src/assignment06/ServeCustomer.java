/*
 MIT License
Copyright (c) 2017 yordaDev - https://github.com/yordadev
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package assignment06;

/*
 *
 * @author yordaDev
 * PURPOSE: 
 *      Handle the act as a cashier and serve each customer in the line
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServeCustomer {

    public static void EachCustomer(Store McFelica, ElementType customer,
            QueueADT theQueue, File storeLog) throws InterruptedException,
            IOException {

        while (!theQueue.IsEmpty()) {
            // tell the customer to approach the throne 
            customer = theQueue.Dequeue();

            //take the customers order...
            System.out.println("Serving customer at register "
                    + customer.GetKey() + ". Please wait...");

            customer.setServiceTime();

            // wait while customer is ordering...
            Thread.sleep(customer.GetOrderTime());

            // customer has been served, log the transaction to file
            BufferedWriter bw = null;
            try {
                // APPEND MODE SET HERE
                bw = new BufferedWriter(new FileWriter(storeLog, true));
                // register:arrivalTime:serviceTime:timeFinished:mealNumber
                bw.write(customer.GetKey()
                        + ":" + customer.GetArrivalTime()
                        + ":" + customer.GetServiceTime()
                        + ":" + System.currentTimeMillis()
                        + ":" + customer.mealNum());
                bw.newLine();
                bw.flush();
            } catch (IOException ioe) {
                System.out.println("Contact your IT Professional. Tell them,"
                        + "something broke. reeeee");
            } finally {
                bw.close();
            }

            System.out.println("Receipt Printed.");
        }
    }
}

