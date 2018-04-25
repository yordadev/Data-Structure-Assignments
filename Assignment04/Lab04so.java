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

package Assignment04;

import java.util.Scanner;

public class Lab04so {
    private static final boolean exit = false;
    
    public static void main(String[] args) {
        String userChoice;
        ManageListFile fileManager = new ManageListFile();
        ListADT customerList = new ListADT(100, true);
        ElementType aCustomer = new ElementType( );
        
        while(!exit){
            displayMenu();
            userChoice = getUserchoice();
            
            switch(userChoice){
                case "3":
                    fileManager.loadFromFile(aCustomer, customerList);
                
                default:
                    System.out.println("Please enter a proper value.");
                    
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a Sale | 2. Remove a Sale | "
                + "3. Load From File | 4. Save to File | "
                + "5. Generate Bills | 6. Generate Single Bills "
                + "7. Modify List Entry");
    }
    
    private static String getUserchoice() {
        String userChoice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a order number!");
        userChoice = sc.nextLine();
        
        return userChoice;
    }
}
