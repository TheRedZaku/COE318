package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
        System.out.println("""
                            .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. 
                           | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
                           | |   ______     | || |   _____      | || |      __      | || |     ______   | || |  ___  ____   | || |     _____    | || |      __      | || |     ______   | || |  ___  ____   | |
                           | |  |_   _ \\    | || |  |_   _|     | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | || |    |_   _|   | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | |
                           | |    | |_) |   | || |    | |       | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | || |      | |     | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | |
                           | |    |  __'.   | || |    | |   _   | || |   / ____ \\   | || |  | |         | || |   |  __'.    | || |   _  | |     | || |   / ____ \\   | || |  | |         | || |   |  __'.    | |
                           | |   _| |__) |  | || |   _| |__/ |  | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || |  | |_' |     | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |
                           | |  |_______/   | || |  |________|  | || ||____|  |____|| || |   `._____.'  | || | |____||____| | || |  `.___.'     | || ||____|  |____|| || |   `._____.'  | || | |____||____| | |
                           | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
                           | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
                            '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' """);
    } //this part is just for fun

  @Override
    public void display() {
        System.out.println("House holds: " + game.getHouseCards().toString() + "\nYou Hold: " + game.getYourCards().toString());
        //FIX THIS
    }

  @Override
    public boolean hitMe() {
        System.out.println("Would you like another card [Y/N]: ");
        return Character.toLowerCase(user.next().charAt(0)) == 'y';
        //FIX THIS
    }

  @Override
    public void gameOver() {
        if (game.score(game.getYourCards()) > 21 || game.score(game.getYourCards()) == game.score(game.getHouseCards())) {
            System.out.println("You Lost! House Holds: \n" + game.getHouseCards().toString() + "\nYou Hold: \n" + game.getYourCards().toString() +"\nScore: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
        } else if (game.score(game.getYourCards()) == 21 && game.score(game.getHouseCards()) > 21) {
            
        } else {
            System.out.println("You won! House Holds: \n" + game.getHouseCards().toString() + "\nYou Hold: \n" + game.getYourCards().toString() +"\nScore: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            
        }
        //FIX THIS
    }

}