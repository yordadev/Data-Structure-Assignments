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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class ManageListFile {
    
    public void loadFromFile(ElementType aCustomer, ListADT customerList){
        try {
            FileReader fr = new FileReader("customerlist.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedReader cnter = new BufferedReader(fr);

            String sCurrentLine;
            
            //lets count how many elements are in the file
            int cnt = 0;
            while ((sCurrentLine = cnter.readLine()) != null) {
                cnt++;
            }
            cnt = cnt / 6;
            for(int x = 0; x <= cnt; x++){
                String  name,
                        address,
                        cityStateZip,
                        type,
                        phoneNumber,
                        quantity;
                
                
                name = br.readLine();
                address = br.readLine();
                cityStateZip = br.readLine();
                phoneNumber = br.readLine();
                quantity = br.readLine();
                type = br.readLine();
                
                int number = Integer.parseInt(phoneNumber);
                int intQuantity = Integer.parseInt(quantity);
               
                aCustomer.Set(name, address, cityStateZip, number, 
                            intQuantity, type);
                
                customerList.Add(aCustomer);
            }
            br.close();
        } catch (IOException e) {

                System.out.println("err... something went wrong.");

        } 
    }   
    
    public void saveToFile(ElementType aCustomer, ListADT customerList) 
            throws FileNotFoundException{
        
        customerList.Reset();
        while(!customerList.AtEnd()){
            if(!customerList.IsEmpty()){
               try (PrintWriter writer = new PrintWriter("customerlist.txt")) {
                    aCustomer = customerList.Retrieve();
                    writer.println(aCustomer.GetKey());
                    writer.println(aCustomer.getAddress());
                    writer.println(aCustomer.getCityStateZip());
                    writer.println(aCustomer.getPhoneNumber());
                    writer.println(aCustomer.getQuantity());
                    writer.println(aCustomer.getType());
                } 
            } 
        }
        
    }
}
