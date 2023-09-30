package mp3player;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Controller in the MVC pattern. Takes user input from the view
 * and translates it into the actions on the model.
 */
public class Controller {
    private SongCollectionModel model;

    public Controller(SongCollectionModel model) {
        this.model = model;
    }

    // FILL IN CODE: add methods that will check input and call methods of the model
    public void songSelected(int ind){
        model.playSong(ind);
    }

    public void stopSong(){
        model.stop();
    }

    public void load(String dir) {
        Path p = Paths.get(dir);
        if(!Files.exists(p)){
            throw new IllegalArgumentException();
        }
        model.loadSongsFromDirectory(dir);
    }
}
