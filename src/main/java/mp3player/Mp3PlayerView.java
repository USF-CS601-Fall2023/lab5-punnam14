package mp3player;

/** The GUI for the Mp3 player. */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/** View in the MVC pattern. Provides a GUI (Graphical User interface) for the mp3 player.
 *  Implements Observer (observes the model). */
public class Mp3PlayerView extends JPanel  { // TODO: implement Observer
	// View should be the observer of the model: must implement update()
	// Add instance variables: references to the controller and the model

	// GUI-related stuff
	private JPanel bottomPanel;
	private JTable table = null; // Table in the central panel
	private JScrollPane centerPanel; // the panel that displays songs
	private JButton loadMp3Button, playButton, stopButton, exitButton;

	public Mp3PlayerView(SongCollectionModel model, Controller controller) {
		// FILL IN CODE: initialize the model and the controller, and register this
		// class with the model as an observer

		// The code below is for generating GUI elements, no need to change
		this.setLayout(new BorderLayout());
		loadMp3Button = new JButton("Load mp3");
		exitButton = new JButton("Exit");
		playButton = new JButton("Play");
		stopButton = new JButton("Stop");

		// add a listener for each button
		loadMp3Button.addActionListener(new MyButtonListener());
		playButton.addActionListener(new MyButtonListener());
		stopButton.addActionListener(new MyButtonListener());
		exitButton.addActionListener(new MyButtonListener());

		// create the bottom panel and add three buttons to it
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		bottomPanel.add(loadMp3Button);
		bottomPanel.add(playButton);
		bottomPanel.add(stopButton);
		bottomPanel.add(exitButton);

		this.add(bottomPanel, BorderLayout.SOUTH);

		// the panel in the center that shows mp3 songs
		centerPanel = new JScrollPane();
		this.add(centerPanel, BorderLayout.CENTER);
	}

	// TODO: Override the update method that will be called by the model when it changes
	// update() should call displaySongs()

	/**
	 * Create a table that shows the title and the artist of each song in the
	 * center panel.
	 * Invoked in the update() method
	 */
	public void displaySongs() {
		int numSongs = 0;// TODO: get the number of songs from the model
		String[][] tableElems = new String[numSongs][2]; // contains titles and artists for each song
		String[] columnNames = {"Title", "Artist"};

		for (int i = 0; i < numSongs; i++) {
			// get the song with index i from the model
			tableElems[i][0] = ""; // get the title of the song with index i from the model
			tableElems[i][1] = ""; // get the artist's name of the song with index i from the model
		}

		// Each row of tableElems must contain the title and the artist of a song
		// For instance, tableElems[0][0] should contain the title of the first song
		// and tableElems[0][1] should contain the artist for the song.

		// the code below will add the table to the centerPanel
		table = new JTable(tableElems, columnNames);
		centerPanel.getViewport().add(table);
	}


	/**
	 * An inner listener class for buttons.
	 * The actionPerformed will be called whenever the user presses a button
	 **/
	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loadMp3Button) { // user pressed "LoadMp3"
				System.out.println("Load mp3 button");
				// Allows the user to select a directory with mp3 files
				// Inside the getDirectoryWithMp3Music, FileChooser will open a separate window and will allow the
				// user to select a directory
				String dir = getDirectoryWithMp3Music();
				// FILL IN CODE: "tell" the controller that the user selected the directory with music
				// (the controller will then call the corresponding method of the model that will load the songs to the model)

			}
			else if (e.getSource() == playButton) { // user pressed "Play"
				if (table == null)
					return;
				int songIndex = table.getSelectedRow(); // this is the index of the song the user selected
				// FILL IN CODE: "tell" the controller that the user selected a song, and pass the song id.
				// The controller will then ask the model to play it

			} else if (e.getSource() == stopButton) {
				// FILL IN CODE: tell the controller that the user wants to stop
				// playing the song
			} else if (e.getSource() == exitButton) {
				System.exit(-1);
			}
			updateUI(); // a method from JPanel, refreshes the UI
		} // actionPerformed
	} // ButtonListener

	/** Opens a separate window and allows the user to select a directory with mp3 songs
	 * @return directory
	 */
	public String getDirectoryWithMp3Music() {
		// Do not modify
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setDialogTitle("Select a directory with mp3 songs");
		int returnVal = fc.showOpenDialog(Mp3PlayerView.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().toString(); // The directory selected
		} else
			return null;
	}
}