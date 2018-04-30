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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author yordaDev
 * PURPOSE: 
 *      Loop through the store log, calculate the average wait time and 
 *      service time for each transaction.
 */
class CalcAvgWaitTime {

    public void forMePlease(File storeLog) throws FileNotFoundException {
        Scanner scan = new Scanner(storeLog);

        String[] tmp = new String[5];
        String[] waitTimes = new String[1000];
        String[] serviceTimes = new String[1000];

        long waitTime,
                serviceTime;
        int x = 0,
                waitSum = 0,
                serviceSum = 0;
        double averageWaitTime;

        while (scan.hasNextLine()) {
            tmp = scan.nextLine().split(":");
            waitTime = Long.parseLong(tmp[2]) - Long.parseLong(tmp[1]);
            serviceTime = Long.parseLong(tmp[3]) - Long.parseLong(tmp[2]);

            waitTimes[x] = Long.toString(waitTime);
            serviceTimes[x] = Long.toString(serviceTime);
            x++;
        }

        for (String time : waitTimes) {
            if (time != null) {
                waitSum = waitSum + Integer.parseInt(time);
            }
        }

        averageWaitTime = waitSum / waitTimes.length;
        System.out.println("The average wait time was: "
                + averageWaitTime + " Milliseconds!");

        for (String time : serviceTimes) {
            if (time != null) {
                waitSum = waitSum + Integer.parseInt(time);
            }
        }

        averageWaitTime = waitSum / waitTimes.length;
        System.out.println("The average service time was: "
                + averageWaitTime + " Milliseconds!");

        System.out.println("WORLDS FASTEST -- FAST FOOD RESTAURANT!");
    }
}
