package com.company;
import java.util.Scanner; //needed to input things
import java.util.ArrayList; //needed for lists
public class Main {


    //currently this code creates two lists, one of integers based on the amount of players, and one with Players instead of integers and is ready to call to the methods
    public static void main(String[] args) {
        Scanner scannername = new Scanner (System.in);
        Deck gameDeck = new Deck();  //game deck is the object that will be modified in the cases of dealing and creating the community cards
        System.out.println("how many players are playing 2-10?");
        String retry = ("yes");
        while(retry.equals("yes")){
            int numberofPlayers = Integer.parseInt(scannername.nextLine());
            retry = "no";
            if(numberofPlayers < 2 || numberofPlayers > 10){
                System.out.println(" is an improper amount of players to play this game, please choose inbetween 2 and 10 players");
                retry = "yes";
            }
            if (retry.equals("no")){
                int fromzero = 0;
                int playernumber = 1;
                ArrayList<Player> playerlist = new ArrayList<Player>(); //the element value represents the objects of the player class
                ArrayList<Integer> intplayerlist = new ArrayList<Integer>();  //the element number represents the player player 1 is element 0
                while(fromzero < numberofPlayers){
                    playerlist.add(new Player(playernumber)); //i'm pretty sure I want to have each player be of the player class but it might work to have two list of players one for player class and one for main class to change the deciding factors for game things like the blinds and stuff
                    intplayerlist.add(playernumber); //the second list for main to get numbers that target other numbers or something...
                    System.out.println("added player#" + playernumber + " to the list");
                    playernumber = playernumber + 1;
                    fromzero = fromzero + 1;
                }
                System.out.println("now in the playerlist there are elements for " + (playernumber-1));
                System.out.println(playerlist); //this will print the list of players
                System.out.println(intplayerlist);// this will do the same but neither of these are necessary it's just for debugging purposes
                System.out.println("which player should start with the dealer button?");
                int gamestillgoing = 1;
                int isaDealer = (Integer.parseInt(scannername.nextLine())-1); //at the end of the hand this value will be changed automatically this is the rotation of the player status
                while(gamestillgoing == 1){
                    int b = -1;
                    int c = -2;
                    if(isaDealer<2){
                        c = numberofPlayers - 2;
                    }
                    if(isaDealer<1){ //1 is the second player in element language
                        b = numberofPlayers - 1;
                    }
                    int everyoneneedstobezero = 1;
                    int everybody = 0;
                    while (everybody < numberofPlayers){
                        intplayerlist.set(everybody,0);
                        everybody = everybody + 1;
                    }
                    intplayerlist.set(isaDealer,3); // 1 stands for small blind , 2 stands for big blind, 3 stands for the button. , 0 stands for other
                    intplayerlist.set((isaDealer + b),1);//sets the small blind to be 1
                    intplayerlist.set((isaDealer + c),2);//sets the big blind to be 2
                    System.out.println("the dealer button is in the position of player " + (isaDealer + 1) + " for this hand");
                    System.out.println("the small blind for this hand is player " + (isaDealer + b + 1));
                    int smallblind = (isaDealer + b + 1);
                    System.out.println("the big blind for this hand is player " + (isaDealer + c + 1));
                    System.out.println(intplayerlist);// this will do the same but neither of these are necessary it's just for debugging purposes
                    System.out.println("players, continue code from here");
                    isaDealer = isaDealer - 1; // moves the dealer button clockwise each hand ... don't let this become a negative!
                    if(isaDealer < 1){
                        isaDealer = numberofPlayers-1; //subtract 1 because elements do funny things
                        //include dealing of cards
                        String handloop = "yes";
                        int timesthrough = 0;
                        System.out.println(smallblind);



                        /*
                        We need two integers for the player class: Jamie's idea for identifying Players
                        int PlayerID; // this would be used to identify the player's element value (these values will be declared as the Players are declared)
                        int PlayerStat = intplayerlist(PlayerID); // this would be used to know what the player's current role is
                         */
                        //Player.deal(); // the order shoulden't matter, as long as each player gets cards and these cards remain private until showdown

                        System.out.println("Small blind player, choose your move" );
                        String action = scannername.nextLine();
                        if (action.equals("raise")){
                            System.out.println("Player " + 1 + " raises");
                            //
                            //call to the raises method for player
                            //(playerlist.get((smallblind))).raise(); // Player actually means the object name of the small blind player (there are two seperate lists for this :Thinking:)
                        }
                        else if (action.equals("bet")){
                            System.out.println("Player " + 1 + " bets");
                            //meaning giving money to the pit
                            //call to bet method for player
                            //Player.bet();
                        }
                        else if (action.equals("hold")){
                            System.out.println("Player " + 1 + " holds");
                            //meaning that this player is not gonna bet and can not win the pot and will be skipped over during this hand
                            //call to hold method for player
                            //Player.hold();
                        }
                        else if (action.equals("all in")){
                            System.out.println("Player " + 1 + " goes all in");
                            //meaning that this player is putting all their chips in the pit
                            //call to all in method for player
                            //Player.allin();
                        }
                        timesthrough = timesthrough + 1; //this is gonna be used to change the current player being called at
                        handloop = "yes";
                        //call to dealing method where : private cards to each player > Small blind player one > Big blind one last > until each player has 2 cards > deck size changed (this should require an automated process and should not be ai driven unless we want to add the possibility of the dealer having dealing errors)
                        //enter bidding round
                        //at the end of hand..
                    }
                    // let's just ignore this... System.out.println("the next player with the dealer button is player " + Math.sqrt(isaDealer) + 1); //because here values arn't being taken from the list the variable isaDealer can be modified to look like the player number
                }
            }
        }


	// it's time to start coming up with some classes for this project
        //classes:              whos' doing what?:                      What's in them:                                                     what we have:                                   what we need:
        //player                Luke/Marisa                             input for human players and methods used in the AI stuff and properties                                             player properties: is dealer?,is smallblind?, is bigblind?, player hand list,
        //deck52cards           Luke                                    the properties of the deck
        //card                  Luke                                    suit(♣♦♥♠),card number,
        //main                  Jamie                                   game logic                                                          initialization of new players declaring the first dealer and the big blind and small blind
        //moneypit              Luke                                    where money goes when a player raises,bets,or goes all in.
    }


    /*
    simplified process of game/code:

    decide dealer > Big blind player set  > Small blind player set ✓+
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
