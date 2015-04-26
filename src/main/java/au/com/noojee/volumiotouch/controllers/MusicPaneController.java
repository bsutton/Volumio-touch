package au.com.noojee.volumiotouch.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MusicPaneController implements Initializable, PaneController
{
	private Parent managedPane;

	@FXML
	private TextField searchBar;

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

	@FXML
	void onClear(ActionEvent event)
	{

	}

	@FXML
	void onKeyTyped(ActionEvent event)
	{
		this.searchBar.clear();
	}

}
