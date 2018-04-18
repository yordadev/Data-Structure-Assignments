/*
 MIT License
Copyright (c) 2017 Devitgg
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

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Devitgg
 *
 * PURPOSE: Software to log transactions for cashiers, automatically generates a
 * random number of customers entering the restaurant and generates a random
 * desired meal. Then on close or exit program it displays the average wait time
 * and service time for the transactions in the log file.
 */
public class Assignment06 {

    private static boolean exit = false;

    public static void main(String[] args) throws InterruptedException,
            IOException {
        // lets initalize our variables
        String userInput = null;
        int numCustomers,
                mealMax = 10,
                mealMin = 1,
                desiredMeal,
                registerMax = 2,
                registerMin = 1,
                register,
                minTime = 2000, // 2 second min for each order
                maxTime = 4000, // 4 seconds max for each order
                howFastIsCustomer;

        //create instances
        Scanner scan = new Scanner(System.in);
        Store McFelica = new Store();
        File storeLog = new File("storelog.txt");
        ElementType customer = new ElementType();
        QueueADT theQueue = new QueueADT(10); //capacity of McFelica is 10
        ServeCustomer process = new ServeCustomer();
        Random randomNum = new Random();
        CalcAvgWaitTime calc = new CalcAvgWaitTime();

        //loop through till bye felica
        while (!exit) {
            // display menu to end user
            controlMenu(McFelica);

            // get input from user
            userInput = getUserInput(userInput, scan);

            // decide what the user wants
            switch (userInput) {
                case "1": // open store
                    //open the store
                    if (!McFelica.GetStatus()) {
                        //stores closed, lets open it
                        McFelica.ChangeStoreStatus(true);
                        System.out.println("\n   Store is now open!");
                        break;
                    }

                    // Let the user know it's already open... 
                    System.out.println("Store is already open, bro.");
                    break;

                case "2": // close store
                    if (McFelica.GetStatus()) {
                        if (McFelica.RegisterOneStatus()
                                || McFelica.RegisterTwoStatus()) {
                            System.out.println("\n   YOU LEFT A REGISTER ON!");
                            break;
                        } else {
                            // store is good to close, all registers are closed
                            McFelica.ChangeStoreStatus(false);
                            System.out.println("\n    Store is now closed!\n");
                            calc.forMePlease(storeLog);
                            break;
                            
                            
                        }
                    }

                    // Let the user know it's already open... 
                    System.out.println("Store is already closed, bro.");
                    break;

                case "3": //open register
                    // make sure stores open...
                    if (McFelica.GetStatus()) {
                        // user wants to open a cash register.. 
                        // lets find out which one..
                        System.out.println("\n Which register, would you "
                                + "like to open? 1 or 2..");
                        userInput = getUserInput(userInput, scan);

                        // check and open a register
                        switch (userInput) {
                            case "1":
                                if (!McFelica.RegisterOneStatus()) {
                                    McFelica.ChangeRegisterStatus(1, true);
                                    System.out.println("\n   Register One "
                                            + "Open!");
                                    break;
                                }
                                System.out.println("\n   Register One is "
                                        + "already open");
                                break;

                            case "2":
                                if (!McFelica.RegisterTwoStatus()) {
                                    McFelica.ChangeRegisterStatus(2, true);
                                    System.out.println("\n   Register Two"
                                            + " Open!");
                                    break;
                                }
                                System.out.println("\n   Register Two is"
                                        + " already open");
                                break;

                            default:
                                // kick the user back.. 
                                System.out.println("\n   Err.. You a new"
                                        + " manager or something? "
                                        + "Try again 1 or 2..");
                                break;
                        }
                        break;
                    } else {
                        System.out.println("err...your store isnt even open?");
                        break;
                    }

                case "4": // close register
                    if (McFelica.GetStatus() && McFelica.RegisterOneStatus()) {
                        // user wants to close a cash register.. 
                        // lets find out which one..
                        System.out.println("\n Which register, would you like "
                                + "to close?");
                        userInput = getUserInput(userInput, scan);

                        // check and open a register
                        switch (userInput) {
                            case "1":
                                if (McFelica.RegisterOneStatus()) {
                                    McFelica.ChangeRegisterStatus(1, false);
                                    System.out.println("\n   Register One"
                                            + " Closed!");
                                    break;
                                }
                                System.out.println("\n   Register One is "
                                        + "already closed");
                                break;
                            case "2":
                                if (McFelica.RegisterTwoStatus()) {
                                    McFelica.ChangeRegisterStatus(2, false);
                                    System.out.println("\n   Register Two "
                                            + "Closed!");
                                    break;
                                }
                                System.out.println("\n   Register Two is "
                                        + "already closed");
                                break;
                            default:
                                // kick the user back.. 
                                System.out.println("\n   Err.. You a new "
                                        + "manager or something? "
                                        + "Try again 1 or 2..");
                                break;
                        }
                        break;
                    } else {
                        System.out.println("\n   err...try again..");
                        break;
                    }
                case "5": // new customers
                    if (McFelica.GetStatus() && McFelica.RegisterOneStatus()
                            || McFelica.GetStatus()
                            && McFelica.RegisterTwoStatus()) {
                        // new customer arrives at store
                        NewCustomers groupOfCustomers = new NewCustomers();

                        // returned number in group
                        numCustomers = groupOfCustomers.GenerateNewCustomers();

                        // print how many people just walked in
                        System.out.println(numCustomers + " customers "
                                + "just walked in!");

                        // they have an important decision, they must pick 
                        // a register if more then 1 are open... whatever
                        // will they decide?
                        while (numCustomers > 0) {

                            // lets check how many registers are open
                            if (McFelica.RegisterTwoStatus()) {
                                // two registers are open
                                // first let the customer pick a register
                                register = registerMin
                                        + randomNum.nextInt(registerMax);

                                // now let the customer pick a meal
                                desiredMeal = mealMin
                                        + randomNum.nextInt(mealMax);

                                // how fast is this customer?
                                howFastIsCustomer = minTime
                                        + randomNum.nextInt(maxTime);

                                customer.Set(register, desiredMeal,
                                        howFastIsCustomer);

                                // place the customer in line
                                theQueue.Enqueue(customer);
                                numCustomers--;

                            } else {
                                // only one is open
                                // let the customer pick a meal
                                desiredMeal = mealMin
                                        + randomNum.nextInt(mealMax);

                                // how fast is this customer?
                                howFastIsCustomer = minTime
                                        + randomNum.nextInt(maxTime);

                                customer.Set(1, desiredMeal,
                                        howFastIsCustomer);

                                // place the customer in line
                                theQueue.Enqueue(customer);
                                numCustomers--;
                            }

                        }
                        break;
                    } else {
                        System.out.println("err...try again..reeeee");
                        break;
                    }
                case "6":
                    // check if registers are closed 
                    if (!McFelica.RegisterOneStatus()
                            && !McFelica.RegisterTwoStatus()) {
                        exit = true;
                        calc.forMePlease(storeLog);
                        System.out.println("Byeeeee.");
                        break;
                    }
                    System.out.println("Err..you forgot to close"
                            + " the registers!");
                    break;
                default:
                    System.out.println("Invalid ..err.. iunno what to do!");
                    break;
            }

            // peek head out of break room, see if customers in line waiting..
            if (!theQueue.IsEmpty()) {
                ServeCustomer.EachCustomer(McFelica, customer,
                        theQueue, storeLog);
            }
        }
        System.exit(0);
    }

    private static void controlMenu(Store McFelica) {
        if (McFelica.GetStatus()) {
            if (!McFelica.RegisterOneStatus()
                    && !McFelica.RegisterTwoStatus()) {
                System.out.println(
                        "\n=================================================="
                        + "\n\n 2. Close Store | "
                        + "3. Open Cash Register |"
                        + "6. Bye Felica the Program \n\n             "
                        + "Register 1 Open: " + McFelica.RegisterOneStatus()
                        + " | "
                        + "Register 2 Open: " + McFelica.RegisterTwoStatus()
                );
            } else {
                System.out.println(
                        "\n=================================================="
                        + "\n\n 2. Close Store | "
                        + "3. Open Cash Register |"
                        + "4. Close Cash Register |"
                        + "5. New Customers |"
                        + "6. Bye Felica the Program | \n\n             "
                        + "Register 1 Open: " + McFelica.RegisterOneStatus()
                        + " | "
                        + "Register 2 Open: " + McFelica.RegisterTwoStatus()
                );
            }
        } else {
            System.out.println(
                    "==================================================\n"
                    + "1. Open Store | "
                    + "6. Bye Felica the Program"
            );
        }
    }

    private static String getUserInput(String userInput, Scanner scan) {
        userInput = scan.nextLine();
        return userInput;
    }
}
