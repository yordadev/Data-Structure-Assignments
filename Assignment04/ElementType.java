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

public class ElementType {
    private String customerName;
    private String streetAddress;
    private String cityStateZip;
    private int phoneNumber;
    private int quantity;
    private String type;
    
    public void Set(String newName, String newAddress,
            String newCityStateZip, int newPhoneNumber, int newQuantity,
            String newType){
        customerName = newName;
        streetAddress = newAddress;
        cityStateZip = newCityStateZip;
        phoneNumber = newPhoneNumber;
        quantity = newQuantity;
        type = newType;
    }
    
    public String GetKey( ) {
        return customerName;
    }
    
    public String getAddress( ) {
        return streetAddress;
    }
    
    public String getCityStateZip(){
        return cityStateZip;
    }
    
    public int getPhoneNumber(){
        return phoneNumber;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getType(){
        return type;
    }
    public ElementType Clone( ) {
        ElementType clonedItem;
        clonedItem = new ElementType( );
        clonedItem.Set(customerName, streetAddress, cityStateZip, 
                phoneNumber, quantity, type);
        return clonedItem;
    }
}
