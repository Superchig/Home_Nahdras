package combat;

/**
 * Created by Chiggie on 3/23/2015.
 */
public class BearodyteMob extends AICombatMob {

    public BearodyteMob(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }

    @Override
    public void AIChoose(AICombatMob combatMob) {

        ChangeRan();

        int chosenAttemptedStamina = Math.round(getMaxStamina() * getRan());

        System.out.println("chosenAttemptedStamina is: " + chosenAttemptedStamina);

        if (chosenAttemptedStamina == 0 || this.getStamina() == 0) {

            this.setAttacking(false);

            System.out.println("The bearodyte decided to block.");

        } else if (chosenAttemptedStamina <= this.getStamina()) {

            this.setAttacking(true);

            this.setAttemptedStamina(chosenAttemptedStamina);
            this.setStamina(this.getStamina() - chosenAttemptedStamina);

        } else {

            AIChoose(this);

        }


    }

}
