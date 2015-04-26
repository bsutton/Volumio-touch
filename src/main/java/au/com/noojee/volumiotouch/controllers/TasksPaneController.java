package au.com.noojee.volumiotouch.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class TasksPaneController implements Initializable, PaneController
{
	private Parent managedPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void setManagedPane(Parent managedPane)
	{
		this.managedPane = managedPane;
	}

	@Override
	public Parent getManagedPane()
	{
		return this.managedPane;
	}

}
