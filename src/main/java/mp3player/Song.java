package mp3player;

/** Represents a song with the given name, artist and the name of the corresponding mp3 file */
public class Song {
    private String songName;
    private String songArtist;
    private String filename;

    public Song(String songName, String songArtist, String filename) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.filename = filename;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getFilename() {
        return filename;
    }

    public String toString(){
        return(songName + " - " + songArtist);
    }
}
