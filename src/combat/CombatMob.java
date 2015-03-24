// Heyo Jack! So far, I'm only adding various stats for the combat.
// I have an idea for a simple combat system. It involves a combination of skill and luck.
// Probably 2/3 skill and 1/3 luck. Hopefully closer to 3/4 skill and 1/3 luck. Ask me about it later.
// Crap. Originally, this was static. I may make this abstract, or make it an interface.

package combat;

import main.App;

import java.io.Serializable;

public class CombatMob implements Serializable {
    //////// Stats /////////////////////
    private int health;
    private int maxHealth;
    private int stamina;
    private int maxStamina;

    private int attemptedStamina;

    private float staminaRegenRate = 0.375f;

    private boolean attacking;

    public static void heal(CombatMob mob) {

        mob.setStamina(mob.getMaxStamina());
        mob.setHealth(mob.getMaxHealth());

    }

    @Override
    public String toString() {
        return "CombatMob{" +
                "health=" + health +
                ", maxHealth=" + maxHealth +
                ", stamina=" + stamina +
                ", maxStamina=" + maxStamina +
                ", attemptedStamina=" + attemptedStamina +
                ", attacking=" + attacking +
                ", battleCount=" + App.battleCount +
                '}';
    }

    public void addStamina(int staminaAdded) {

        if (this.getStamina() + staminaAdded > this.getMaxStamina()) {

            this.setStamina(getMaxStamina());

        } else {

            this.setStamina(getStamina() + staminaAdded);

        }

    }

    public CombatMob(int health, int maxHealth, int stamina, int maxStamina) {
        this.health = health;
        this.health = health;
        this.maxStamina = maxStamina;
        this.stamina = stamina;
        this.maxHealth = maxHealth;
    }

    public float getStaminaRegenRate() {
        return staminaRegenRate;
    }

    public void setStaminaRegenRate(float staminaRegenRate) {
        this.staminaRegenRate = staminaRegenRate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public int getAttemptedStamina() {
        return attemptedStamina;
    }

    public void setAttemptedStamina(int attemptedStamina) {
        this.attemptedStamina = attemptedStamina;
    }

}