package au.com.noojee.volumiotouch;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import au.com.noojee.volumiotouch.controllers.MainPaneController;

public class Main extends Application
{
	Logger logger = LogManager.getLogger(Main.class);

	private MainPaneController mainPaneController;

	@Override
	public void start(Stage primaryStage)
	{
		// Load the main window.

		try
		{
			mainPaneController = (MainPaneController) InsetPanels.load(InsetPanels.main);
			StackPane insetPanel = mainPaneController.getInsetPane();

			// Load the managed panes.
			InsetManager insetManager = new InsetManager(insetPanel);
			mainPaneController.setInsetManager(insetManager);

			// Set the starting pane.
			insetManager.setInset(InsetPanels.playing);

			// build and show the scene.
			Scene scene = new Scene(mainPaneController.getManagedPane());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e)
		{
			logger.error(e, e);
		}

	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
