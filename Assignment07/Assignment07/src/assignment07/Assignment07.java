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

package assignment07;

import java.util.Scanner;

/**
 *
 * @author yordaDev
 * 
 */
public class Assignment07 {
    private static boolean exit = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int          userNumber = 0,
                     userBase   = 0;
        int[] pokemonCollection = new int[500];
        Scanner kbd             = new Scanner(System.in);
        
        while(!exit){
            userNumber = GetUserNumber(userNumber, kbd);
            userBase   = GetUserBase(userBase, kbd);
            addToCollection(pokemonCollection, userNumber, userBase);
            promptToExit(kbd);
        }
        ProcessPokemon releasePokemon = new ProcessPokemon();
        releasePokemon.IntoTheWild(pokemonCollection);
        System.exit(0);
    }

    private static int GetUserNumber(int userNumber, Scanner kbd) {
        System.out.println("Enter a number.");
        userNumber = kbd.nextInt();
        if(userNumber == 0){
            System.out.println("Cant use zer0");
            userNumber = GetUserNumber(userNumber, kbd);
        }
        return userNumber;
    }

    private static int GetUserBase(int userBase, Scanner kbd) {
        System.out.println("Enter a base.");
        userBase = kbd.nextInt();
        if(userBase == 0){
            System.out.println("Cant use zer0");
            userBase = GetUserBase(userBase, kbd);
        }
        return userBase;
    }

    private static void promptToExit(Scanner kbd) {
        System.out.println("To exit, type 'exit' or any key..");
        String prompt = kbd.next();
        if(prompt.equals("exit")){
            exit = true;
        }
    }

    private static void addToCollection(int[] pokemonCollection, 
            int userNumber, int userBase) {
        for(int pokemon = 0; pokemon <= pokemonCollection.length; pokemon++){
            if(pokemonCollection[pokemon] == 0){
                pokemonCollection[pokemon] = userNumber;
                pokemonCollection[pokemon + 1] = userBase;
                return;
            }
        }
    }   
}
