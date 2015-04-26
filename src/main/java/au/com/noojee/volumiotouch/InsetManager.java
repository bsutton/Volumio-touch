package au.com.noojee.volumiotouch;

import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import au.com.noojee.volumiotouch.controllers.PaneController;

public class InsetManager
{
	Logger logger = LogManager.getLogger(InsetManager.class);

	/**
	 * Map of panes that are being managed.
	 */
	private HashMap<InsetPanels, PaneController> panes = new HashMap<>();

	/**
	 * The StackPane node that holds the managed panes.
	 */
	private StackPane parent;

	public InsetManager(StackPane parent)
	{
		super();
		this.parent = parent;

		// Pre load all of the defined panels
		for (InsetPanels inset : InsetPanels.values())
		{
			loadManagedPane(inset);
		}
	}

	/**
	 *
	 * Loads the FXML resource as a parent.
	 *
	 * @param managedPaneName
	 *            to associated with Panel loaded from the FXML file.
	 * @param fxmlFilename
	 *            filename of the fxml file relative to the /src/java/resources
	 *            directory.
	 * @return
	 */
	public boolean loadManagedPane(InsetPanels inset)
	{
		boolean loaded = false;
		try
		{
			PaneController paneController = InsetPanels.load(inset);

			addController(inset, paneController);
			loaded = true;
		}
		catch (Exception e)
		{
			logger.error(e, e);
		}
		return loaded;
	}

	/**
	 * Add the pane of the given name to the Root. If there is an existing pane
	 * remove it first applying an transition. The new pane is also displayed
	 * using a transition.
	 *
	 * @param paneName
	 *            the name of the pane to display.
	 * @return
	 */
	public void setInset(final InsetPanels managedPaneName)
	{
		if (this.panes.get(managedPaneName) != null)
		{
			if (!parent.getChildren().isEmpty())
			{
				transition(managedPaneName);
			}
			else
			{
				fadeIn(managedPaneName);
			}
		}
		else
		{
			logger.error("Pane " + managedPaneName + " not found.");
		}
	}

	/**
	 * Adds the named pane to the scene and fades it in.
	 *
	 * @param managedPaneName
	 */
	private void fadeIn(final InsetPanels managedPaneName)
	{
		parent.setOpacity(0.0);

		// Add the new pane and transition it in.
		parent.getChildren().add(this.panes.get(managedPaneName).getManagedPane());
		Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(parent.opacityProperty(), 0.0)),
				new KeyFrame(new Duration(800), new KeyValue(parent.opacityProperty(), 1.0)));
		fadeIn.play();
	}

	private void transition(final InsetPanels managedPaneName)
	{
		Timeline fadeOut = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(parent.opacityProperty(), 1.0)),
				new KeyFrame(new Duration(800), new EventHandler<ActionEvent>()
						{
					@Override
					public void handle(ActionEvent t)
					{
						// Remove the current Pane.
						parent.getChildren().remove(0);
						// Fade in the new pane.
						fadeIn(managedPaneName);
					}
						}, new KeyValue(parent.opacityProperty(), 0.0)));
		fadeOut.play();
	}

	/**
	 * Add the pane to the collection
	 *
	 * @param inset
	 * @param paneController
	 */
	public void addController(InsetPanels inset, PaneController paneController)
	{
		this.panes.put(inset, paneController);
	}

	/**
	 * Returns the Pane with the given name.
	 *
	 * @param name
	 *            of the pane to return.
	 * @return
	 */
	public PaneController getPane(String name)
	{
		return this.panes.get(name);
	}

	/**
	 * Remove the named panel from list of managed panes.
	 *
	 * @param name
	 * @return
	 */
	public void unloadPane(String managedPaneName)
	{
		if (this.panes.remove(managedPaneName) == null)
		{
			logger.error("The managedPane " + managedPaneName + " doesn't exist.");
		}
	}
}
