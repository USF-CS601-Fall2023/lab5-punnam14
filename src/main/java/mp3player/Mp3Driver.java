package mp3player;

import javax.swing.*;
import java.awt.*;

/** The driver class for the mp3 player. */
public class Mp3Driver {
    public static void main(String[] args) {
        SongCollectionModel model = new SongCollectionModel();
        Controller controller = new Controller(model);
        Mp3PlayerView panel = new Mp3PlayerView(model, controller);

        panel.setPreferredSize(new Dimension(600, 400));
        JFrame frame = new JFrame("Mp3 player"); // window showing the panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
