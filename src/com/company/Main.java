package com.company;
import java.util.Scanner; //needed to input things
import java.util.ArrayList; //needed for lists
public class Main {

    public static void main(String[] args) {
        Scanner scannername = new Scanner (System.in);
        System.out.println("how many players are playing 2-10?");
        while(retry.equals("yes")){
            int numberofPlayers = Integer.parseInt(scannername.nextLine());
            if(numberofPlayers < 2 || numberofPlayers > 10){
                System.out.println(" is an improper amount of players to play this game, please choose inbetween 2 and 10 players");
            } 
        }

        int fromzero = 0;
        int playernumber = 1;
        ArrayList<Integer> playerlist = new ArrayList<Integer>();
        while(fromzero < numberofPlayers){
            playerlist.add(playernumber);
            System.out.println("added player#" + playernumber + " to the list");
            playernumber = playernumber + 1;
            fromzero = fromzero + 1;
        }
        System.out.println("if the code got to here this is good!");

	// it's time to start coming up with some classes for this project
        //classes:              whos' doing what?:                      What's in them:
        //player/deck52cards    ...                                     ...
        //card                  ...                                     suit(♣♦♥♠),cardnumber,
        //main                  ...                                     ...
        //:thinking:            ...                                     ...
    }


    /*
    simplified process of game/code:

    decide dealer > Big blind player set  > Small blind player set
    private cards to each player > Small blind player one > Big blind one last > until each player has 2 cards > deck size changed
    bidding round > Small blind player (raise/bet half/ hold/all in) > Big blind (raise/bet/hold/all in) > everyone folds/player puts in all their chips/player matches amount by all other active players > bidding stops
    something happens
    Showdown > player's cards become public > winning hand player gets pit
    dealer changed > process restarts
     */










        /*
    the activities of this game consist of:
    each player that is *active* in the game is dealt 2 cards and 3 cards face up on the board are drawn and another one face down
    choosing one *player*() to be the min and choosing another player to be the not min that enters double the $ as the min player.
    when a player puts stuff in add values to the *pit*()
    the user continues to input and at some point cards are flipped and whoever has the best hand gets the pit.

     */


    /*
    here is what the code should look like:
    a player is targeted to be the dealer and that dictates who is the small blind (the person who pays half the minimum) and the Big blind (the person who when bets pays the entire minimum or raise it and I think when they do they become the small blind)
    Card Class -                    Cards will have their own rules and properties for each card
    Player Class value change -     player input (raise/bet/hold/all in/other actions) keep track of the betting for each player
                                    based on who has the highest bet change the target for the first choice of next turn
    Money pit value change-         players use their money/chips to add to the pit
    card Class reads hand -         finally the game's logic decides which player has the best hand using advanced intelligence techniques ((T H E   S H O W D O W N)I believe that this should be placed in the card class and it will read the values that corresponds to each player



    round is over reset blinds

     */
}
