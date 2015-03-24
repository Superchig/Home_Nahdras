package combat;


public class AICombatMob extends CombatMob {

    private static float ran = (float) Math.random();

    public static void ChangeRan() {

        ran = (float) Math.random();

    }

    public void AIChoose(AICombatMob AIMob) {

        ChangeRan();

        int strongAttemptedStamina = Math.round(AIMob.getMaxStamina() * 3/4);
        int mediumAttemptedStamina = Math.round(AIMob.getMaxStamina()/4);
        int weakAttemptedStamina = Math.round(AIMob.getMaxStamina()/10);


        if (AIMob.getStamina() >= weakAttemptedStamina) {


            if (ran <= 0.75) {

                AIMob.setAttacking(true);

                if (ran > 0.50) {

                    if (AIMob.getStamina() > strongAttemptedStamina) {

                        AIMob.AIChooseStamina(strongAttemptedStamina);

                        System.out.println("Your opponent chose a strong attack!");
                        System.out.println("The stamina used was: " + strongAttemptedStamina);

                    } else {

                        AIChoose(AIMob);

                    }

                } else if (ran > 0.25) {

                    if (AIMob.getStamina() > mediumAttemptedStamina) {

                        AIMob.AIChooseStamina(mediumAttemptedStamina);

                        System.out.println("Your opponent chose a medium attack.");
                        System.out.println("The stamina used was: " + mediumAttemptedStamina);


                    } else {

                        AIChoose(AIMob);

                    }

                } else {

                    AIMob.AIChooseStamina(weakAttemptedStamina);

                    System.out.println("Your opponent chose a weak attack...");
                    System.out.println("The stamina used was " + weakAttemptedStamina);


                }

            } else {

                AIMob.setAttacking(false);

                System.out.println("Your enemy blocked.");

            }


        } else if(AIMob.getStamina() <= 0) {

            System.out.println("Your enemy ran out of stamina!");

            System.out.println("So they blocked.");

            AIMob.setAttacking(false);

        }

    }

    public void AIChooseStamina(int staminaSubtracted) {

        //If stamina - subtracted is lower than zero...
        if (this.getStamina() - staminaSubtracted < 0) {

            this.AIChoose(this);

        } else {

            this.setAttemptedStamina(staminaSubtracted);

            this.setStamina(this.getStamina() - staminaSubtracted);

        }

    }

    public AICombatMob(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }

    public static float getRan() {
        return ran;
    }
}
