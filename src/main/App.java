package main;

import combat.CombatMechanics;
import combatMobs.*;
import dataManagement.ReadObjects;
import dataManagement.WriteObjects;

import java.util.Scanner;

// Ha! Jack! I think I've found it! We can use serialization to save.


public class App {

    // I don't know how to use anonymous classes
    public static PlayerCharacter pl = new PlayerCharacter(200, 200, 100, 100);

    private static AICombatMob trollMob = new TrollMob(150, 150, 50, 50);
    private static AICombatMob bearMob = new BearodyteMob(175, 175, 75, 75);
    private static AICombatMob twinBrotherMob = new TwinBrotherMob(300, 300, 200, 200);

    public static void startMenu(Scanner sc) {

        if (pl.isMurderedBrother()) {

            System.out.println("Welcome to this mediocre indie game, you monstrous monster.");
            System.out.println("Would you like to play, load, quit, die in a hole, or wallow in the imminent misery and regret of brutally murdering a brother?(JUST LIKE THAT, TOO)");

        } else {

            System.out.println("Welcome to this mediocre indie game made by two middle-schoolers! Would you like to play, load, quit, or die in a hole?");

        }

        checkEndings(pl);

        System.out.println("NOTE: TYPING play AFTER ALREADY SAVING MAY OVERWRITE YOUR SAVE FILE");

        String menuChoice = sc.nextLine().toLowerCase();

        // They're an example.
        System.out.println("You wrote: " + menuChoice);


        if (menuChoice.equals("play")) {

            // Start actual game function here
            System.out.println("Time to begin the game!");

            firstGameBeforeChoices(sc);

        } else if (menuChoice.equals("quit")) {

            System.out.println("Well then. Good job, you party pooper");

        } else if (menuChoice.equals("die in a hole")) {

            System.out.println("Hm. You should definitely try something else. In fact, I'll make you do so.");

            startMenu(sc);

        } else if (menuChoice.equals("load")) {

            ReadObjects.loadGame();

            pl = ReadObjects.getPlStorage();

            evalLocation(sc);

        } else if (menuChoice.equals("wallow in the imminent misery and regret of brutally murdering a brother")) {

            if (pl.isMurderedBrother()) {


                secretEnding(sc);

            } else {

                System.out.println();

            }

        } else {

            System.out.println("Need I remind you this is a mediocre game? Use play, quit, load, or die in a hole.");

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

            pl.setDeEnd1(true);

            decentEnd(sc);


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

        WriteObjects.savePrompt(sc);

        System.out.println("Within the random forest, you see a troll. Do you want to poke it, run, or try to communicate?");

        System.out.println("And no, poking it is not trying to communicate.");

        String interactTroll = sc.nextLine().toLowerCase();

        if (interactTroll.equals("poke") || (interactTroll.equals("poke it"))) {

            System.out.println("I'm not sure if you either didn't know that poking is the troll's equivalent of flipping someone off, or you just wanted to piss him off.");
            System.out.println("Either way, he is ready to vicariously tear your head off. And then eat it. With his feet.");

            // Start combat functions
            CombatMechanics.battleLoop(pl, trollMob, sc);

            postTrollBattle(sc);

        } else if (interactTroll.equals("run")) {

            System.out.println("You cowardly run away from this troll.. That's a darn shame..");
            pl.setDeEnd2(true);
            decentEnd(sc);

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

        WriteObjects.savePrompt(sc);

        System.out.println("What would you like to say? \n");

        System.out.println("a. Death");
        System.out.println("b. I can has cheezburger?");
        System.out.println("d. Can you get me out of this game?");
        System.out.println("e. Hey! There was no 'c' option!");

        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("a") || choice.equals("death")) {

            System.out.println("The troll says, 'Well, sir, if that is what you want, that is what you shall receive.'");

            System.out.println("All of a sudden, you are struck by lightning, despite the fact that it should clearly have struck one of the trees, which are much taller than you are.");

            System.out.println("Yeah. You've died. Believe it or not, this is the second worst ending.");

            pl.setDeEnd3(true);

            decentEnd(sc);

        } else if (choice.equals("b") || choice.equals("i can has cheezburger?")) {

            System.out.println("The troll says, 'Yes, yes you may.'");
            System.out.println("The troll gives you a cheeseburger.");
            //Yummy
            System.out.println("Congratulations. You have reached the burger end.");

            pl.setDeEnd4(true);

            System.out.println("Sending you back to the menu.");

            startMenu(sc);

        } else if (choice.equals("d") || choice.equals("can you get me out of this game?")) {

            System.out.println("The troll says, 'Great job breaking the fourth wall there.'");
            System.out.println("The troll says, 'Anyway, Christopher and Jack have implemented json serialization. So you can save your progress, to a point.'");
            System.out.println("The troll says, 'You always have the option of closing the window, of course.'");
            tempEnd(sc);

        } else if (choice.equals("e") || choice.equals("hey! There was no 'c' option!")) {

            System.out.println("The troll says, 'Quite an astute observation, kind sir.'");
            pl.setDeEnd5(true);
            decentEnd(sc);

        } else {

            System.out.println("You should specify the correct input, my gosh");

            trollInteract1(sc);

        }
    }

    //Please rename this when I am not looking.
    public static void postTrollBattle(Scanner sc) {

        pl.setLocation("postTrollBattle");

        WriteObjects.savePrompt(sc);

        System.out.println("You've defeated the troll!\nYou search the bag that the troll had and find a map!");

        System.out.println("Did you murder that poor guy? I don't know.");//Nonono, we 'defeated' him!

        System.out.println("What do you want to do now? Use the map, or get the heck out of this mess?");

        String choice = sc.nextLine().toLowerCase();

        if (choice.equals("use the map")) {

            System.out.println("It appears that the map wants to you head north-east. Fortunately, you happened to have brought your handy compass with you!");
            System.out.println("As you head north-east you 'accidently' run into a bearodyte.");
            /*Please do not hesitate to have this be another creature.*/
            System.out.println("Bearodytes are a form of sentient bear. They're widely renowned for holding grudges, especially through generations.");
            System.out.println("They can read and write, but cannot speak any known human language.");
            System.out.println("The bearodyte is outraged at you and decides to attack you!");

            CombatMechanics.battleLoop(pl, bearMob, sc);

            finalBattlePrompt(sc);


        } else if (choice.equals("get the heck out of this mess")) {

            System.out.println("That's okay, but you're a wuss, who knows what that map leads to..");

            pl.setDeEnd6(true);

            decentEnd(sc);

        } else {
            System.out.println("I'm not joking around here, you need to use one of the ACTUAL answers..");
            postTrollBattle(sc);
        }


    }


    public static void finalBattlePrompt(Scanner sc) {
        pl.setLocation("finalBattlePrompt");

        WriteObjects.savePrompt(sc);

        System.out.println("With the bearodyte defeated, you can continue.");
        System.out.println("Of course, that is, if you want to continue.");
        System.out.println("Please specify if you want to continue, or leave the forest.");
        String choice = sc.nextLine().toLowerCase();
        if (choice.equals("continue")) {
            System.out.println("Continuing down the path...");
            finalBattle(sc);
        } else if (choice.equals("leave")) {
            System.out.println("If you say so..");

            pl.setDeEnd7(true);

            decentEnd(sc);
        } else {
            System.out.println("Hello? I said whether to leave or continue.");
            finalBattlePrompt(sc);
        }
    }

    public static void finalBattle(Scanner sc) {
        pl.setLocation("finalBattle");

        WriteObjects.savePrompt(sc);

        System.out.println("After hours going down the path you finally reach a cave, and (no, you do not get a choice of going in or not..) you go inside.");
        System.out.println("Inside, you find.. Your twin brother separated at death!");

        //BAD ENDING COMMENCE
        System.out.println("He appears docile, and greets you calmly.");
        System.out.println("Out of the blue, you attack him!");
        CombatMechanics.battleLoop(pl, twinBrotherMob, sc);

        badEnd(sc);

    }

    private static void badEnd(Scanner sc) {

        System.out.println("This is the worst ending possible! You horrible person! You murdered your brother for no legitimate reason. What the heck, man. Who even does that?");
        System.out.println("Sending you back to the main menu, you monster.");
        pl.setMurderedBrother(true);
        pl.setBadEnd(true);

        startMenu(sc);
    }

    private static void decentEnd(Scanner sc) {


        //10/10 would end 10 again ben 10 approves 10/10
        System.out.println("You have reached one of the few decent endings.");
        System.out.println("Sending you back to the main menu.");

        startMenu(sc);

    }


    public static void jokeError(Scanner sc) {

        System.out.println("Error code 404: Error code not found");
        System.out.println("Will now attempt to find error code 404");
        System.out.println("Press to enter to continue...");
        sc.nextLine();
        jokeError(sc);

    }

    public static void evalLocation(Scanner sc) {

        String location = ReadObjects.getPlStorage().getLocation().toLowerCase();

        System.out.println("Location: " + location);

        if (location.equals("firstgamebeforechoices")) {

            firstGameBeforeChoices(sc);

        } else if (location.equals("inforest1")) {

            inForest1(sc);

        } else if (location.equals("trollinteract1")) {

            trollInteract1(sc);

        } else if (location.equals("posttrollbattle")) {

            postTrollBattle(sc);

        } else {

            System.out.println("Hm. It appears that you don't have a valid location.");

        }

    }

    public static void tempEnd(Scanner sc) {

        System.out.println("This is a temporary ending. This means that we were too lazy to code in a permanent one.");
        System.out.println("Sending you back to the main menu.");

        startMenu(sc);

    }


    // Prepare for a rollercoaster of events...
    public static void secretEnding(Scanner sc) {
        pl.setLocation("secretEnding");
        WriteObjects.saveGame();

        System.out.println("Note: press enter (or anything, really) to continue.");
        System.out.println("Secret ending begin!:");
        System.out.println("Meanwhile, in a deep cave, somewhere far under the earth.");
        System.out.println("A troll with a monocle walks over to the dead corpse of someone's twin brother, who was separated at death.");

        sc.nextLine();

        System.out.println("The troll says, 'Good God, man.'");
        System.out.println("The troll says, 'What happened to this poor soul?'");

        sc.nextLine();

        System.out.println("I (that's right. Me, the narrator. Seriously, I'm a character) say, 'Eh. He was murdered by his twin brother, who was separated at death.'");

        sc.nextLine();

        System.out.println("The troll says, 'The same one who murdered me, yet simultaneously said 4 other things to me?");

        sc.nextLine();

        System.out.println("Uh, ye-");

        sc.nextLine();

        System.out.println("A young courier comes crashing into the room.");
        System.out.println("The courier says, 'Sir! Sir! I bear horrible news!'");

        sc.nextLine();

        System.out.println("The troll says, 'What is it?'");

        sc.nextLine();

        System.out.println("The courier says, 'London Bridge is falling down.'");
        System.out.println("The troll says, 'Falling down?'");
        System.out.println("The courier says, 'Falling down.'");

        sc.nextLine();

        System.out.println("I say, 'London bridge is falling down?'");
        System.out.println("The troll says, 'My fair lady!");

        sc.nextLine();

        System.out.println("Fin. \n" + " I do love me some fish.");
        System.out.println("Returning to the start menu.");
    }

    public static void checkEndings(PlayerCharacter pl) {

        if (pl.isBadEnd() && pl.isDeEnd1() && pl.isDeEnd2() && pl.isDeEnd3() && pl.isDeEnd4() && pl.isDeEnd5()
                && pl.isDeEnd6() && pl.isDeEnd7() && pl.isWorstEnding2nd()) {

            pl.setUnlockedAllEndings(true);

            System.out.println("The secret ending has been unlocked by unlocking all the other endings.");
            System.out.println("See if you can find it ;).");

        } else {

            System.out.println("If you play this game enough (and correctly), this message will eventually disappear.");

        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ////////// Everything beyond here is for testing. ///////////
        // pl = player
        // Moved this to the proper location.
        ///////////// Resume normality /////////

        App.startMenu(sc);

        sc.close();


    }


}