package au.com.noojee.volumiotouch.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.tensin.sonos.model.musicService.MusicService;
import org.xml.sax.SAXException;

import au.com.noojee.volumiotouch.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

public class ServicesPaneController implements Initializable, PaneController
{
	private Parent managedPane;
	
	@FXML
	ListView<MusicServiceWrapper> serviceList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{

		try
		{
			List<MusicService> services = Main.getSonos().getMusicServiceList(Main.getPlayer());
			
			for (MusicService service : services)
			{
				serviceList.getItems().add(new MusicServiceWrapper(service));
			}
		}
		catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	class MusicServiceWrapper
	{
		private MusicService service;

		MusicServiceWrapper(MusicService service)
		{
			this.service = service;
			
		}
		
		public String toString()
		{
			return this.service.getName();
		}
	}

}
