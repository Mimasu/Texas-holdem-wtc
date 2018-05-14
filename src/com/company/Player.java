package com.company;
import java.util.Scanner; //needed to input things
import java.util.ArrayList; //needed for lists
/**
 * Created by JIrvine on 4/12/2018.
 */
public class Player extends MoneyPit{
    Scanner scannername = new Scanner (System.in);
    int playername; //no longer used
    int PlayerID; // this would be used to identify the player's element value (these values will be declared as the Players are declared)
    int PlayerStat; // this would be used to know what the player's current role is
    String hasplayerfolded; // this will be used to declare if the defined player has folded
    String potmatch; // this will be used to declare if the defined player has matched the amount each player put in the pot, if player is not active set this to be yes
    String playeractive;
    int chipsLeft;
    public Player(int playername){
        //PlayerStat = intplayerlist(PlayerID); //this part is required for defining what a player can actually do
        hasplayerfolded = ("no");
        chipsLeft = 100;
        playeractive = "yes";
        potmatch = "no";

    }
    public void test(){
        System.out.println(playername);

    }
    public void raise(){
        System.out.println(playername);
        int raise = Integer.parseInt(scannername.nextLine());
        if(raise < pot){
            System.out.println("you must raise above the pot");
        }
    }
    public void bet(){
        System.out.println("how much?");
        int bet = Integer.parseInt(scannername.nextLine());
        chipsLeft = chipsLeft - bet;
        if(bet == pot){
            potmatch = ("yes");
        }else if (bet < pot || bet > pot){
            potmatch = ("no");
        }

    }
    public void fold(){
        playeractive = "no";

    }
    public void allin(){
        System.out.println(playername);

    }
}
