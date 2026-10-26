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
        //prints out what cards you and the house are holding, as shown in the manual
    }

  @Override
    public boolean hitMe() {
        System.out.println("Would you like another card [Y/N]: ");
        return Character.toLowerCase(user.next().charAt(0)) == 'y';
        //Character.toLowerCase just makes it so that the userinput is case insensitive
    }

  @Override
    public void gameOver() {//have to call using game.-> since the ui does not have access to the cards directly
        if (game.score(game.getYourCards()) > 21 || (game.score(game.getYourCards()) == game.score(game.getHouseCards()) && game.score(game.getYourCards()) != 21)) {
            //If your score is more than 21 you lose
            //if you and the house tie and it isn't 21, you lose
            System.out.println("You Lose! Better Luck Next Time!");
            display();
            System.out.println("Score: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            //System.out.println("You Lost! House Holds: \n" + game.getHouseCards().toString() + "\nYou Hold: \n" + game.getYourCards().toString() +"\nScore: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
        } else if (game.score(game.getYourCards()) < 21 && game.score(game.getHouseCards()) > 21) {
            //if your score is less than 21 and the house is more than 21, you win
            System.out.println("You Win!");
            display();
            System.out.println("Score: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            //System.out.println("You won! House Holds: \n" + game.getHouseCards().toString() + "\nYou Hold: \n" + game.getYourCards().toString() +"\nScore: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
        } else if (game.score(game.getYourCards()) < 21 && game.score(game.getHouseCards()) == 21 || game.score(game.getYourCards()) < game.score(game.getHouseCards())){
            System.out.println("You Lose! Better Luck Next Time!");
            display();
            System.out.println("Score: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            //if you have a score LESS than 21, and the House has exactly 21, then you lose
            //System.out.println("You won! House Holds: \n" + game.getHouseCards().toString() + "\nYou Hold: \n" + game.getYourCards().toString() +"\nScore: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards())); 
        } else if (game.score(game.getYourCards()) == 21 && game.score(game.getHouseCards()) == 21){
            //What happens when you tie? Well in a real game, you split the bet, so I'm adding that functionality here
            System.out.println("You...Tied?");
            display();
            System.out.println("Score: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            //if your score IS 21 and the house IS 21, then it is just a tie for this, but it is technically a "win" for this program
        } else {
            System.out.println("You Win!");
            display();
            System.out.println("Score: " + game.score(game.getYourCards()) + " || House Score: " + game.score(game.getHouseCards()));
            //if your score IS 21 and the house is less than you, then you win
            
        }
        //prints out the output as shown in the lab manual, with a few tweaks
    }

}