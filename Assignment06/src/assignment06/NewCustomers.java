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

import java.util.Random;

/**
 *
 * @author Devitgg
 * PURPOSE: 
 *      Generate a random number to pretend as if customers are 
 *      walking in randomly. When selected from control menu will 
 *      randomly generate x amount of new  customers from 1-3 
 *      every time selected
 */
public class NewCustomers {

    public int GenerateNewCustomers() {
        int max = 3;
        int min = 1;
        int num;
        // create instance of Random class
        Random randomNum = new Random();
        num = min + randomNum.nextInt(max);
        int numberOfCustomers = num;
        return numberOfCustomers;
    }
}
