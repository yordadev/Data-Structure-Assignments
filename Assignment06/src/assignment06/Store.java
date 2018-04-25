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

/**
 *
 * @author yordaDev
 *
 * PURPOSE: 
 *      Handle the stores conditions
 */
public class Store {

    private boolean status = false;
    private boolean registerOne = false;
    private boolean registerTwo = false;

    public boolean GetStatus() {
        return status;
    }

    public boolean RegisterOneStatus() {
        return registerOne;
    }

    public boolean RegisterTwoStatus() {
        return registerTwo;
    }

    public boolean ChangeRegisterStatus(int register, boolean status) {
        switch (register) {
            case 1:
                registerOne = status;
                return true;
            case 2:
                registerTwo = status;
                return true;
            default:
                return false;
        }
    }

    public void ChangeStoreStatus(boolean statusChange) {
        status = statusChange;
    }
}
