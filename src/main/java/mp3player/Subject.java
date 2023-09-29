package mp3player;

/** The subject/model that is Observable.*/
public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers();
}
