package au.com.noojee.volumiotouch;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import au.com.noojee.volumiotouch.controllers.PaneController;

public enum InsetPanels
{
	settings("Settings.fxml"), playing("Playing.fxml"), main("Main.fxml"), queue("Queue.fxml"), music("Music.fxml"), playlist(
			"Playlist.fxml"), storage("Storage.fxml"), tasks("Tasks.fxml");

	private static Logger logger = LogManager.getLogger(InsetPanels.class);

	private String filename;

	InsetPanels(String filename)
	{
		this.filename = filename;
	}

	public static PaneController load(InsetPanels panel) throws IOException
	{
		URL location = InsetPanels.class.getResource(new File(File.separator + "fxml", panel.filename)
		.getAbsolutePath());

		if (location == null)
			throw new RuntimeException("The InsetPane " + panel.filename + " cannot be found.");
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent pane;
		PaneController paneController = null;
		try
		{
			pane = (Parent) fxmlLoader.load(location.openStream());
			paneController = ((PaneController) fxmlLoader.getController());
			paneController.setManagedPane(pane);
		}
		catch (Throwable e)
		{
			logger.error("The insetPanel " + panel.filename + " could not be loaded. Exception follows");
			logger.error(e,e);
			new RuntimeException("The insetPanel " + panel.filename + " could not be loaded", e);
		}

		return paneController;
	}

}