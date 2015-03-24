package combat;

import main.App;

import java.util.Scanner;

/**
 * Created by Chiggie on 3/23/2015.
 */
public class PlayerCharacter extends CombatMob {

    public PlayerCharacter(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }

    private String location = "";

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "health=" + this.getHealth() +
                ", maxHealth=" + this.getMaxHealth() +
                ", stamina=" + this.getStamina() +
                ", maxStamina=" + this.getMaxStamina() +
                ", attemptedStamina=" + this.getAttemptedStamina() +
                ", location=" + this.getLocation() +
                ", attacking=" + this.isAttacking() +
                ", battleCount=" + App.battleCount +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void chooseStamina(int staminaSubtracted, Scanner sc) {

        if (this.getStamina() - staminaSubtracted < 0) {

            System.out.println("You can't use this much stamina. Try again.");

            CombatMechanics.battlePrompt(this, sc);

        } else {

            this.setAttemptedStamina(staminaSubtracted);

            this.setStamina(this.getStamina() - staminaSubtracted);

        }

    }

}
