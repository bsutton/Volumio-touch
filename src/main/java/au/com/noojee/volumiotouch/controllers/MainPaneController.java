package au.com.noojee.volumiotouch.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import au.com.noojee.volumiotouch.InsetManager;
import au.com.noojee.volumiotouch.InsetPanels;

/**
 * FXML Controller class
 */
public class MainPaneController implements Initializable, PaneController
{
	Logger logger = LogManager.getLogger(InsetManager.class);

	@FXML
	private Slider volumeLeft;

	@FXML
	private Slider volumeRight;

	@FXML
	private ProgressBar progressBar;

	@FXML
	private Label labelNextSong;

	private InsetManager insetManager;

	private Parent managedPane;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		// TODO
	}

	public StackPane getInsetPane()
	{
		return getInsetPane(this.managedPane);
	}

	private StackPane getInsetPane(Parent parent)
	{
		StackPane insetPane = null;
		for (Node child : parent.getChildrenUnmodifiable())
		{
			if (child.getId() != null && child.getId().compareTo("managedPanes") == 0)
			{
				insetPane = (StackPane) child;
			}
			else
			{
				if (child instanceof Parent)
					insetPane = getInsetPane((Parent) child);
			}
			if (insetPane != null)
				break;
		}
		return insetPane;
	}

	@Override
	public Parent getManagedPane()
	{
		return this.managedPane;
	}

	@Override
	public void setManagedPane(Parent managedPane)
	{
		this.managedPane = managedPane;
	}

	public void setInsetManager(InsetManager insetManager)
	{
		this.insetManager = insetManager;
	}

	@FXML
	void onRepeat(ActionEvent event)
	{

	}

	@FXML
	void onPause(ActionEvent event)
	{

	}

	@FXML
	void onRestartTrack(ActionEvent event)
	{

	}

	@FXML
	void onPreviousTrack(ActionEvent event)
	{

	}

	@FXML
	void onNextTrack(ActionEvent event)
	{

	}

	@FXML
	void onShuffle(ActionEvent event)
	{

	}

	@FXML
	void onSkipBack(ActionEvent event)
	{

	}

	@FXML
	void onSkipNext(ActionEvent event)
	{

	}

	@FXML
	void onPlaying(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.playing);
	}

	@FXML
	void onQueued(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.queue);
	}

	@FXML
	void onPlayList(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.playlist);
	}

	@FXML
	void onMusic(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.music);
	}

	@FXML
	void onStorage(ActionEvent event)
	{

	}

	@FXML
	void onSettings(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.settings);

	}

	@FXML
	void onTask(ActionEvent event)
	{
		insetManager.setInset(InsetPanels.tasks);
	}

}
