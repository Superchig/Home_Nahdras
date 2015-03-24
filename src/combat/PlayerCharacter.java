package combat;

/**
 * Created by Chiggie on 3/23/2015.
 */
public class PlayerCharacter extends CombatMob {

    public PlayerCharacter(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }

    private String location = "";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
