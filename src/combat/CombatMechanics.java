package combat;

import java.util.Scanner;

import main.App;

public class CombatMechanics {

    private static int damageCalc(CombatMob mob) {

        // A mob, upon winning evalClash(), will do 1/6 of their total health for damage

        double d = mob.getMaxHealth() / 6;

        float f = (float) d;

        return Math.round(f);

    }

    private static void regenStamina(CombatMob mob) {

        mob.addStamina(Math.round(mob.getMaxStamina() * mob.getStaminaRegenRate()));

    }

    public static void evalClash(PlayerCharacter mob1, AICombatMob mob2) {

        if (mob1.isAttacking() && mob2.isAttacking()) {

            evalDamage(mob1, mob2);

        } else if (mob1.isAttacking()) {

            mob2.setHealth(mob2.getHealth() - 10);

        } else if (mob2.isAttacking()) {

            mob1.setHealth(mob1.getHealth() - 10);

        } else {

            System.out.println("Both fighting blocked, so no one loses any health.");
        }

    }

    public static void evalDamage(PlayerCharacter mob1, AICombatMob mob2) {

        if (mob1.getAttemptedStamina() < mob2.getAttemptedStamina()) {

            mob1.setHealth(mob1.getHealth() - damageCalc(mob2));


        } else if (mob2.getAttemptedStamina() < mob1.getAttemptedStamina()) {

            mob2.setHealth(mob2.getHealth() - damageCalc(mob1));

        } else {

            System.out.println("You both put in an equivalent amount of stamina. You will both lose 1 health.");

            mob2.setHealth(mob2.getHealth() - 1);

            mob1.setHealth(mob1.getHealth() - 1);

        }


    }

    public static void battleLoop(PlayerCharacter mob1, AICombatMob mob2, Scanner sc) {

        while (mob1.getHealth() > 0 && mob2.getHealth() > 0) {


            if (!mob1.isAttacking()) {

                regenStamina(mob1);

            }

            if (!mob2.isAttacking()) {

                regenStamina(mob2);

            }

            System.out.println("You have " + mob1.getHealth() + " health out of " + mob1.getMaxHealth() + " max health.\n");
            System.out.println("You have " + mob1.getStamina() + " stamina out of " + mob1.getMaxStamina() + " max stamina.\n");

            System.out.println("Your opponent has " + mob2.getHealth() + " health out of " + mob2.getMaxHealth() + " max health.\n");
            System.out.println("Your opponent has " + mob2.getStamina() + " stamina out of " + mob2.getMaxStamina() + " max stamina.\n");

            battlePrompt(mob1, sc);

            mob2.AIChoose(mob2);

            evalClash(mob1, mob2);


        }

        if (mob1.getHealth() > 0) {

            mob1.setAttacking(false);

            System.out.println("Congratulations. You have defeated this... enemy. I'm too lazy to code in specific messages for each mob beaten, after all.");

            PlayerCharacter.heal(App.pl);

            System.out.println("You have also been magically (divinely?) healed. It must be an act of Yahweh, or something.");
            App.battleCount += 1;
            // TODO As I put in other past TODO, I don't think this is necessary... It all depends on what you want to do.
            // App.advanceStory(sc);

        } else {

            System.out.println("You have lost this battle. Restart!");

            App.startMenu(sc);

        }
    }



    public static void battlePrompt(PlayerCharacter pl, Scanner sc) {

        String choice;

        System.out.println("Do you want to block or attack?");

        choice = sc.nextLine().toLowerCase();

        System.out.println("Choice was: " + choice);

        if (choice.equals("attack")) {

            pl.setAttacking(true);


            try {

                System.out.println("How much stamina do you want to use? If you want to go back, just type in a word.");

                String midChoice = sc.nextLine().toLowerCase();

                int choice2 = Integer.parseInt(midChoice);

                pl.chooseStamina(choice2, sc);

            } catch(Exception e) {

                System.out.println("You're 'exceptional!'");
                System.out.println("Returning you to the battle prompt.");
                battlePrompt(pl, sc);

            }

        } else if (choice.equals("block")) {

            pl.setAttacking(false);

        } else {

            System.out.println("Come on! There are clearly only two choices! Blocking or attacking! If you made a mistake, however, then you're totally fine.");

            battlePrompt(pl, sc);

        }


    }

}

