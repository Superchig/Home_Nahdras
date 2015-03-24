package dataManagement;

import com.cedarsoftware.util.io.JsonWriter;
import main.App;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

    public static void saveGame() {

        System.out.println("Saving game...");
        System.out.println("Heed no attention to the following outputs unless I tell you to!");

        try (FileOutputStream fs = new FileOutputStream("save.json"); ObjectOutputStream os = new ObjectOutputStream(fs); JsonWriter jw = new JsonWriter(os)) {

            System.out.println(App.pl);

            jw.write(App.pl);

            System.out.println("Game saved");

        } catch (FileNotFoundException e) {

            System.out.println("Ha! There is no save.json! Though I'm not really sure why not, as this should generate one.");

        } catch (IOException e) {

            System.out.println("Ho! Santa isn't real!");

        }

    }

}
