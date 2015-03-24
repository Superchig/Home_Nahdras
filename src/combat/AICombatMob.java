package combat;


public class AICombatMob extends CombatMob {

    private static float ran = (float) Math.random();

    public static void ChangeRan() {

        ran = (float) Math.random();

    }

    public static void AIChoose(CombatMob mob) {

        ChangeRan();

        int strongAttemptedStamina = Math.round(mob.getMaxStamina() * 3/4);
        int mediumAttemptedStamina = Math.round(mob.getMaxStamina()/4);
        int weakAttemptedStamina = Math.round(mob.getMaxStamina()/10);


        if (mob.getStamina() >= weakAttemptedStamina) {

            if (ran <= 0.75) {

                mob.setAttacking(true);

                if (ran > 0.50) {

                    if (mob.getStamina() > strongAttemptedStamina) {

                        mob.AIChooseStamina(strongAttemptedStamina);

                        System.out.println("Your opponent chose a strong attack!");
                        System.out.println("The stamina used was: " + strongAttemptedStamina);

                    } else {

                        AIChoose(mob);

                    }

                } else if (ran > 0.25) {

                    if (mob.getStamina() > mediumAttemptedStamina) {

                        mob.AIChooseStamina(mediumAttemptedStamina);

                        System.out.println("Your opponent chose a medium attack.");
                        System.out.println("The stamina used was: " + mediumAttemptedStamina);


                    } else {

                        AIChoose(mob);

                    }

                } else {

                    mob.AIChooseStamina(weakAttemptedStamina);

                    System.out.println("Your opponent chose a weak attack...");
                    System.out.println("The stamina used was " + weakAttemptedStamina);


                }

            } else {

                mob.setAttacking(false);

                System.out.println("Your enemy blocked.");

            }


        } else if(mob.getStamina() <= 0) {

            System.out.println("Your enemy ran out of stamina!");

            System.out.println("So they blocked.");

            mob.setAttacking(false);

        }

    }

    public void AIChooseStamina(int staminaSubtracted) {

        //If stamina - subtracted is lower than zero...
        if (this.getStamina() - staminaSubtracted < 0) {

            AICombatMob.AIChoose(this);

        } else {

            this.setAttemptedStamina(staminaSubtracted);

            this.setStamina(this.getStamina() - staminaSubtracted);

        }

    }

    public AICombatMob(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }
}
