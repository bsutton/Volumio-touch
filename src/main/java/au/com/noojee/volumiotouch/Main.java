package au.com.noojee.volumiotouch;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.tensin.sonos.commander.Sonos;
import org.tensin.sonos.control.ZonePlayer;

import au.com.noojee.volumiotouch.controllers.MainPaneController;

public class Main extends Application
{
	Logger logger = LogManager.getLogger(Main.class);

	private MainPaneController mainPaneController;
	
	private static Sonos sonos;
	private static ZonePlayer player;

	@Override
	public void start(Stage primaryStage)
	{
		// Load the main window.
		
		sonos = new Sonos();
		player = sonos.getPlayer("Kitchen");
		System.out.println(player.getId());
		System.out.println(sonos.getZoneNames());


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

	@Override
	public void stop() throws Exception
	{
		super.stop();
		sonos.close();

	}

	public static void main(String[] args)
	{
		launch(args);
	}

	public static Sonos getSonos()
	{
		 return sonos;
	}

	public static ZonePlayer getPlayer()
	{
		return player;
	}
}
