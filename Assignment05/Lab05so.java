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

package lab05so;

import java.util.Scanner;

/**
 * 
 * @author yordaDev
 * 
 */
public class Lab05so {
    // private class constant to unleash the kraken
    //      from the program.
    private static boolean EXIT = false;
    
    private static void changeEXIT(){
        EXIT = true;
    }
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // first lets create an empty stack to hold the
        //      remainders
        StackADT reStack        = new StackADT();
        Scanner scan            = new Scanner(System.in);
        RemainderObj remainder  = new RemainderObj();
        int lifeDecision = 1;
        
        while(!EXIT){
            // Now lets ask the user for a number and a base
            
            int userNum = 0;
            int userBase = 0;
            userNum = getUserNumber(scan);
            userBase = getUserBase(scan);
            
            int newRemainder = 0;
            
            if(userNum != 0){
            // calculate the remainder of the division 
            //      of the number by the base
            
            newRemainder = theRemainderFromUserNum(userNum, userBase, newRemainder);
            
            // push the remainder onto the stack of remainders, ez.
            remainder.Set(newRemainder, userNum, userBase);
            reStack.Push(remainder);
            
            
            // replace number by the integer quotient of
            }else{
                // let them know they broke it
                System.out.println("You done broked it. Integers only ploxx.");              
            }
            
            // ask to do another number or finish
            lifeDecision = continueOrNot(lifeDecision, scan);
            
            // lets see the response and do what they want
            switch(lifeDecision){
                case 0:
                    popEmBopEm(reStack, remainder);
                    changeEXIT();
                    break;
                   
                default:
                    break;
            }
        }
        
    }

    private static int getUserNumber(Scanner scan) {
        // Ask for a non offending input... we only like accept int 
        // business here  
        System.out.print("Enter a integer number, ploxx.."
                + "\n--->"); 

        // error catch for them pesky users....
        while (!scan.hasNextInt()) 
        {   
            // Read and discard offending non-int input
            scan.next(); // 
            // Ask for a non offending input... we only like accept int 
            // business here
            System.out.print("Enter a integer number, ploxx.."
                    + "\n--->"); 
        }

        // finally .. user gave me a integer...
        int input = scan.nextInt(); // Get the integer
        
        return input;
    }

    private static int getUserBase(Scanner scan) {
        // Ask for a non offending input... we only like accept int 
        // business here  
        System.out.print("Enter a base number (2-16), ploxx.."
                + "\n--->"); 
        
        // error catch for them pesky users....
        while (!scan.hasNextInt()) 
        {   
            // Read and discard offending non-int input
            scan.next(); // 
            // Ask for a non offending input... we only like accept int 
            // business here
            System.out.print("Enter a base number (2-16), ploxx.."
                    + "\n--->"); 
        }

        // finally .. user gave me a integer...
        int input = scan.nextInt(); // Get the integer
        
        // GREAT, now lets return it.
        return input;
    }

    private static int theRemainderFromUserNum(
            int userNum, int userBase, int remainder) {
        // aweomse we got this far, lets find the remainder
        // between the userNum and userBase
        remainder = userNum % userBase;
        System.out.println(remainder);
        // GREAT, now lets return it.
        return remainder;
    }

    private static int continueOrNot(int lifeDecision, Scanner scan) {
        // Ask if they want to continue or not
        System.out.print("\nWould you like to try again, or are you done?"
                + "\n\n"
                + "y or n \n--->"); 
        // lets get the response
        String input = scan.next(); 
        
        switch(input){
            case "y":
                lifeDecision = 1;
                break;
            case "n":
                lifeDecision = 0;
                break;
                
        }
        // great decision...
        return lifeDecision;
    }

    private static void popEmBopEm(StackADT reStack, RemainderObj remainder) {
        while(!reStack.IsEmpty()){
            //lets grab the orginal numbers given
            int number = remainder.GetUserNum();
            int base   = remainder.GetUserBase( );
            // great now we can POP that "stack" 
            remainder = reStack.Pop( );
            // poof !
            
            // finally lets convert the values 10-15 as
            //  A-F!!!!!!!!!
            switch(remainder.GetKey()){
                
                // this ones for A
                case 10: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was A (10)");
                    break;
                // this ones for B    
                case 11: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was B (11)");
                    break;
                // this ones for C   
                case 12: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was C (12)");
                    break;
                // this ones for D    
                case 13: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was D (13)");
                    break;
                // this ones for E    
                case 14: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was E (14)");
                    break;
                // this ones for F    
                case 15: 
                    System.out.println("For your number: " + number + 
                            " and base: " + base + "\n" + 
                            "The Remainder was F (15)");
                    break;
                // this ones for 1-9    
                default:
                    System.out.println("For your number: " + number + 
                               " and base: " + base + "\n" + 
                               "The Remainder was " + remainder.GetKey());
                       break;   
            }
        }
    }
    
}
