package assignment07;

/**
 *
 * @author Sean O'Connell
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
