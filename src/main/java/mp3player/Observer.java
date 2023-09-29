package mp3player;

/** A part of the Observer pattern. This interface must be implemented by any observers of the model.
 *  In this example, Mp3PlayerView should be the observer of the model.  */
public interface Observer {
    void update();
}
