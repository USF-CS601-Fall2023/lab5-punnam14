package mp3player;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.exceptions.*;
import org.jaudiotagger.tag.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** The class that stores the songs, it's the "model" in this example.
 * Implements the Subject interface so that it can have observers. */
public class SongCollectionModel  { // TODO: implement the Subject interface
    private List<Song> songs;
    // TODO: add observers and methods to add an observer and notify observers
    private PlayerThread currThread = new PlayerThread("");	// the current thread that is playing the song

    public SongCollectionModel() {
       songs = new ArrayList<>();
    }

    /**
     * Return the song given its index
     * @param ind index of the song
     * @return song
     */
    public Song getSongByIndex(int ind) {
        return songs.get(ind);
    }

    /**
     * Returns the number of songs in the model
     * @return number of songs
     */
    public int getNumSongs(){
        return songs.size();
    }

    /**
     * Create a Song object from the given mp3 file
     * @param mp3FileName name of the mp3 file with the song
     * @return Song
     */
    private Song createSongFromFile(String mp3FileName) {
        try {
            AudioFile f = AudioFileIO.read(new File(mp3FileName));
            // Extracts the artist and the title from the mp3 file
            Tag tag = f.getTag();
            String artist = tag.getFirst(FieldKey.ARTIST);
            String title = tag.getFirst(FieldKey.TITLE);
            return new Song(title, artist, mp3FileName);
        }
        catch (IOException | CannotReadException | ReadOnlyFileException e) {
            System.out.println(e);
        } catch (TagException e) {
            System.out.println(e);
        } catch (InvalidAudioFrameException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Find all mp3 files in the given directory, create a Song object from each file,
     * and add it to the list of songs.
     * @param dir directory that contains mp3 files
     */
    public void loadSongsFromDirectory(String dir){
        // FILL IN CODE:
        // Open a directory stream for a given directory, find all mp3 files
        // and for each mp3 file, create a Song object using the createSongFromFile method,
        // and add a song to the list


    }

    /** Play the song with the
     *
     * @param ind
     */
    public void playSong(int ind) {
        // Get a song with the given index, so that you could access the corresponding mp3
        // If the currThread is alive, you should stop it first.
        // currThread should be pointed to a new PlayerThread with the corresponding mp3 filename
        // and started.
        // FILL IN CODE:

    }

    public void stop() {
        // FILL IN CODE:
        // If the current player thread is alive, you should stop it.

    }

    /** A helper class for playing the song */
    private static class PlayerThread extends Thread {
        Player player; // a built-in class from javazoom.jl library; can play mp3

        PlayerThread(String filename) { // filename with the mp3
            try {
                player = new Player(new FileInputStream(filename));
            } catch (FileNotFoundException | JavaLayerException e) {
                System.out.println(e);
            }
        }

        @Override
        public void run() {
            try {
                player.play();
            }
            catch (JavaLayerException e) {
                System.out.println(e);
            }
        }

        public void stopPlay() {
            player.close();
        }
    }
}
