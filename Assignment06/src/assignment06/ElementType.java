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

/**
 *
 * @author Devitgg
  * PURPOSE: 
 *      A object to hold the information containing each customer in lines 
 *      information.
 */

public class ElementType {

    int  registerNum,
         desiredMealNumber,
         orderTime;
    long arrivalTime,
         startServiceTime;

    public void Set(int register, int desiredMeal, int wait) {
        registerNum = register;
        desiredMealNumber = desiredMeal;
        arrivalTime = System.currentTimeMillis();
        orderTime = wait;
    }

    public void SetClone(int clonedRegister, long clonedArrival,
            long clonedStart, int desiredMeal, int wait) {
        registerNum = clonedRegister;
        arrivalTime = clonedArrival;
        startServiceTime = clonedStart;
        desiredMealNumber = desiredMeal;
        orderTime = wait;
    }

    public int GetKey() {
        return registerNum;
    }

    public int GetOrderTime() {
        return orderTime;
    }

    public long GetArrivalTime() {
        return arrivalTime;
    }

    public long GetServiceTime() {
        return startServiceTime;
    }

    public int mealNum() {
        return desiredMealNumber;
    }

    public void setServiceTime() {
        startServiceTime = System.currentTimeMillis();
    }

    public ElementType Clone() {
        ElementType clonedItem;
        clonedItem = new ElementType();
        clonedItem.SetClone(registerNum, arrivalTime,
                startServiceTime, desiredMealNumber, orderTime);
        return clonedItem;
    }
}
