package dataManagement;


import com.cedarsoftware.util.io.JsonIoException;
import com.cedarsoftware.util.io.JsonReader;
import combatMobs.PlayerCharacter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ReadObjects {

    static PlayerCharacter plStorage;

    public static PlayerCharacter getPlStorage() {
        return plStorage;
    }

    public static void loadGame() {

        try (FileInputStream fs = new FileInputStream("save.json"); ObjectInputStream os = new ObjectInputStream(fs); JsonReader jr = new JsonReader(os)) {

            // Only currently designed to work with App.Startmenu()

            plStorage = (PlayerCharacter) jr.readObject();

            System.out.println(plStorage);

            System.out.println("Game loaded");

            System.out.println("Starting actual game now...");

        } catch (FileNotFoundException e) {

            System.out.println("Hm. There isn't a save.json, which means that you probably haven't saved your game before.");
            System.out.println("At least, there is no save file.");

        } catch (IOException e) {

            // Because we aren't quite sure what causes IOExceptions
            // For your knowledge: IOException == 'An exception class used for signaling runtime failure of reading and writing operations.. See the API for more..
            e.printStackTrace();
            System.out.println("Something went wrong...");

        } catch (JsonIoException e) {

            System.out.println("Oh dear! If this happens to you, try the following troubleshooting steps. \n");
            System.out.println("Step 1. Sit down and try not to cry");
            System.out.println("Step 2. Cry");
            System.out.println("Step 4. Skip step 3");
            System.out.println("Step 5. Contact Christopher or Jack. If you don't know who those are, repeat steps 1-2");

        }

    }

}
