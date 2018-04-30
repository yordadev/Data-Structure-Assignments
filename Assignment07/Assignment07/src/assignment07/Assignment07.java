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
