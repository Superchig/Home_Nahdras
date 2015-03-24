package main;

import combat.CombatAI;
import combat.CombatMechanics;
import combat.CombatMob;
import dataManagement.ReadObjects;
import dataManagement.WriteObjects;


import java.util.Scanner;

// Ha! Jack! I think I've found it! We can use serialization to save.


public class App {

    // I don't know how to use anonymous classes
    public static CombatMob pl = new CombatMob(200, 200, 100, 100);

    private static CombatMob trollMob = new CombatMob(150, 150, 50, 50);
    private static CombatMob bearMob = new CombatMob(175, 175, 75, 75);

    public static void startMenu(Scanner sc) {

        System.out.println("Welcome to this mediocre indie game made by two middle-schoolers! Would you like to play, load, quit, or die in a hole?");

        String menuChoice = sc.nextLine().toLowerCase();

        // They're an example.
        System.out.println("You wrote: " + menuChoice);


        if (menuChoice.equals("play")) {

            // Start actual game function here
            System.out.println("Time to begin the game!");

            firstGameBeforeChoices(sc);

        } else if (menuChoice.equals("quit")) {

            System.out.println("Well then. Good job you party pooper.");

        } else if (menuChoice.equals("die in a hole")) {

            System.out.println("Hm. You should definitely try something else. In fact, I'll make you do so.");

            startMenu(sc);

        } else if (menuChoice.equals("load")) {

            ReadObjects.loadGame();

        } else {

            System.out.println("Need I remind you this is a mediocre game? Use play, quit, or die in a hole.");

            startMenu(sc);

        }
    }

    // Uh, Jack? I wrote out most of the 'path' in the game in Path.java
    // I think that's the point of Path.java, after all
    // Edit: I just moved it here. We're probably going to need a chart for all the choices.
    private static void firstGameBeforeChoices(Scanner sc) {

        pl.setLocation("firstGameBeforeChoices");

        WriteObjects.saveGame();

        System.out.println();

        System.out.println("Do you want to play as a male or female?");

        String useless = sc.nextLine();

        System.out.println("It doesn't really matter if you want to play as a " + useless + " because we're too lazy to program in a gender-based game. Or even gender-based text! So you're going to be playing a " +/*Sexist!!!*/ "male. Tough luck.");

        System.out.println("Your name is Libordismachus, an ambiguously Greek wanderer. Literally, the gods are paying you to wander around. Great job, right?");

        System.out.println("You're wandering around Nechzchuk, a normally barren desert. However, a forest randomly appeared. Don't ask me how, though I really should know.");

        System.out.println("Do you want to enter it? Yes or no.");

        String enterForest = sc.nextLine().toLowerCase();

        if (enterForest.equals("yes")) {

            System.out.println("You decide to enter the forest, and slowly begin trekking into its confines.");

            inForest1(sc);

        } else if (enterForest.equals("no")) {

            System.out.println("Welp. Since you chose not to go into teh[sic] forest, the game is over now. Do you want to restart the game?");

            String restart = sc.nextLine().toLowerCase();

            if (restart.equals("yes")) {

                System.out.println("Here we go.");

                firstGameBeforeChoices(sc);

            } else {

                System.out.println("Welp. Play again some other time!");

            }


        } else if (enterForest.equals("God") || enterForest.equals("Jesus")) {

            System.out.println("Ok, look, I know that Jesus is the answer and all that, but you need to choose 'yes' or 'no'. Without the quotes, of course.");

            System.out.println("And now, you will have to restart almost all of the game.");

            firstGameBeforeChoices(sc);

        } else {

            System.out.println("Ok, ok. No. Try either yes or no.");

            System.out.println("And now, you will have to restart almost all of the game.");

            firstGameBeforeChoices(sc);

        }
    }


    private static void inForest1(Scanner sc) {

        pl.setLocation("inForest1");

        System.out.println("Within the random forest, you see a troll. Do you want to poke it, run, or try to communicate?");

        System.out.println("And no, poking it is not trying to communicate.");

        String interactTroll = sc.nextLine().toLowerCase();

        if (interactTroll.equals("poke") || (interactTroll.equals("poke it"))) {

            System.out.println("I'm not sure if you either didn't know that poking is the troll's equivalent of flipping someone off, or you just wanted to piss him off.");
            System.out.println("Either way, he is ready to vicariously tear your head off. And then eat it. With his feet.");

            // Start combat functions
            CombatMechanics.battleLoop(pl, trollMob, sc);

        } else if (interactTroll.equals("run")) {

            System.out.println("You cowardly run away from this troll.. That's a darn shame.. \nGAME OVER");
            startMenu(sc);

        } else if (interactTroll.equals("communicate") || interactTroll.equals("try to communicate")) {

            System.out.println("You approach the troll. Upon seeing you, the troll turns his face towards you, gallantly wearing a monocle.");
            System.out.println("The troll says, 'Is there anything I may assist you with, good sir?");

            trollInteract1(sc);

        } else {

            System.out.println("Ooh... you didn't choose any of the options. Try again.");

            inForest1(sc);

        }

    }

    private static void trollInteract1(Scanner sc) {

        pl.setLocation("trollInteract1");

        System.out.println("What would you like to say? \n");

        System.out.println("a. Death");
        System.out.println("b. I can has cheezburger?");
        System.out.println("d. Can you get me out of this game?");
        System.out.println("e. Hey! There was no 'c' option!");

        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("a") || choice.equals("death")) {

            System.out.println("The troll says, 'Well, sir, if that is what you want, that is what you shall receive.'");

            System.out.println("All of a sudden, you are struck by lightning, despite the fact that it should clearly have struck one of the trees, which are much taller than you are.");

            System.out.println("Yeah. You've died. Sending you back to the menu, now.");

            startMenu(sc);

        } else if (choice.equals("b") || choice.equals("i can has cheezburger?")) {

            System.out.println("The troll says, 'Yes, yes you may.'");
            System.out.println("The troll gives you a cheeseburger.");
            //Yummy
            System.out.println("Congratulations. You have reached the burger end.");
            System.out.println("Sending you back to the menu.");

            startMenu(sc);

        } else if (choice.equals("d") || choice.equals("can you get me out of this game?")) {

            System.out.println("The troll says, 'Great job breaking the fourth wall there.'");
            System.out.println("The troll says, 'Anyway, Christopher and Jack have not implemented serialization quite yet, so you are incapable of saving your progress.'");
            System.out.println("The troll says, 'You always have the option of closing the window, of course.'");

        } else if (choice.equals("e") || choice.equals("hey! There was no 'c' option!")) {

            System.out.println("The troll says, 'Quite an astute observation, kind sir.'");

        } else {

            System.out.println("You should specify the correct input, my gosh");

            trollInteract1(sc);

        }
    }

    //Please rename this when I am not looking.
    public static void postTrollBattle(Scanner sc){

        pl.setLocation("postTrollBattle");

        System.out.println("You've defeated the troll!\nYou search the bag that the troll had and find a map!");

        System.out.println("What do you want to do now? Use the map, or get yourself the heck out of this mess?");

        String choice = sc.nextLine().toLowerCase();

        if(choice.equals("use the map")){

            System.out.println("It appears that the map wants to you head north-east. Fortunately, you happened to have brought your handy compass with you!");
            System.out.println("As you head north-east you 'accidently' run into a bear.");/*Please do not hesitate to have this be another creature.*/
            System.out.println("The bear is outraged at you and decides to attack you!");
            CombatMechanics.battleLoop(pl, bearMob, sc);


        } else if(choice.equals("get me the heck out of this mess")){

            System.out.println("That's okay, but you're a wuss, who knows what that map leads to..");
            System.out.println("Returning you to the very beginning.");
            startMenu(sc);

        } else {
            System.out.println("I'm not joking around here, you need to use one of the ACTUAL answers..");
            postTrollBattle(sc);
        }



    }

    //This is useful.
    public static int battleCount = 0;
    //Used when completing a battle..
    public static void advanceStory(Scanner sc){

        if(battleCount == 1){

            postTrollBattle(sc);

        } else if(battleCount == 2){
            /*Insert an amazing battle that we are too lazy to make at the moment.*/
        } else {
            //I'm very funny, am I not?
            System.out.println("Please contact your local Home_Nahdras programmer if you see this message, thank you.");
        }






    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ////////// Everything beyond here is for testing. ///////////
        // pl = player
        // Moved this to the proper location.
        ///////////// Resume normality /////////

        App.startMenu(sc);

        WriteObjects.saveGame();

        sc.close();


    }


}