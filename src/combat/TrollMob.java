package combat;

/**
 * Created by Chiggie on 3/23/2015.
 */
public class TrollMob extends AICombatMob {

    public TrollMob(int health, int maxHealth, int stamina, int maxStamina) {
        super(health, maxHealth, stamina, maxStamina);
    }

    // Despite the first troll in the game being intelligent and gentlemanly (lots of 'gent's!),
    // Trolls use the predictable, yet paradoxically random, default AIChoose
}
