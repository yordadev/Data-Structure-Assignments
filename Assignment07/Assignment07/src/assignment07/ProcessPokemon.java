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

/**
 *
 * @author yordaDev
 */
class ProcessPokemon {
    int[] freedWillies = new int[250];
    
    void IntoTheWild(int[] pokemonCollection) {
        int position = 0;
        for(int pokemon = 0; pokemon < pokemonCollection.length; 
                pokemon = pokemon + 2){
            if(pokemonCollection[pokemon] != 0){
                int userNumber = pokemonCollection[pokemon],
                    userBase = pokemonCollection[pokemon + 1];
                    ShootIliveRecursively(userNumber, userBase, position);
                    position++;
            }
        }
        displayYourWhalesAndPokemen(pokemonCollection, freedWillies);
    }

    private void ShootIliveRecursively(int userNumber, 
            int userBase, int position) {
        int remainder = userNumber % userBase,
            quote     = userNumber / userBase;
        if(quote != 0){
            ShootIliveRecursively(quote, userBase, position);
        }
        freedWillies[position] = remainder;
        freedWillies[position + 1] = 1337; // to stay parrel with pokemonColl..
                                           // and because its 1337 sauce.
    }

    private void displayYourWhalesAndPokemen(int[] pokemonCollection, 
            int[] freedWillies) {
        for(int notZero = 0; notZero < freedWillies.length; 
                notZero++){
            if(freedWillies[notZero] != 1337 && freedWillies[notZero] != 0){
                switch(freedWillies[notZero]){
                    // this ones for A
                    case 10: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was A (10)");
                             break;
                    // this ones for B    
                    case 11: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was B (11)");
                            break;
                    // this ones for C   
                    case 12: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was C (12)");
                            break;
                    // this ones for D    
                    case 13: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was D (13)");
                            break;
                    // this ones for E    
                    case 14: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was E (14)");
                            break;
                    // this ones for F    
                    case 15: 
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was F (15)");
                            break;
                    // this ones for 1-9    
                    default:
                        System.out.println("For your number: " +
                            pokemonCollection[notZero] + 
                            " and base: " + pokemonCollection[notZero + 1] 
                            + "\n The Remainder was " + freedWillies[notZero]);
                            break;   
                }
            }
        }
    }
}
