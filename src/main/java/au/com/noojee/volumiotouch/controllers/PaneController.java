package au.com.noojee.volumiotouch.controllers;

import javafx.scene.Parent;

/**
 * Each pane must implement a Controller that implements this interface.
 *
 * @author bsutton
 *
 */
public interface PaneController
{
	public void setManagedPane(Parent managedPane);

	public Parent getManagedPane();
}
