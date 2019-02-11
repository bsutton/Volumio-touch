package parse;

import static org.junit.Assert.*;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.convert.RegistryStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

public class ParseMusicService
{

	@Test
	public void test()
	{

		String xml = "<Services SchemaVersion=\"1\">" + "<Service Id=\"204\" " + "Name=\"Apple Music\" Version=\"1.1\" "
				+ "Uri=\"https://sonos-music.apple.com/ws/SonosSoap\" "
				+ "SecureUri=\"https://sonos-music.apple.com/ws/SonosSoap\" " + "ContainerType=\"SoundLab\" "
				+ "Capabilities=\"1020481\">"
				+ "<Policy Auth=\"AppLink\" PollInterval=\"60\"/>"
				 + "<Presentation><Strings Version=\"10\" Uri=\"https://sonos-music.apple.com/xml/strings.xml\"/>"
				 + "<PresentationMap Version=\"7\" Uri=\"http://sonos-pmap.s3.amazonaws.com/applemusic_pmap.1.xml\"/>"
				 + "</Presentation>"
				+ "</Service>"
				
				 + "<Service Id=\"204\" "
				 + "Name=\"Brett Music\" Version=\"1.1\" "
				 + "Uri=\"https://sonos-music.apple.com/ws/SonosSoap\" "
				 + "SecureUri=\"https://sonos-music.apple.com/ws/SonosSoap\" "
				 + "ContainerType=\"SoundLab\" "
				 + "Capabilities=\"1020481\">"
				  + "<Policy Auth=\"AppLink\" PollInterval=\"60\"/>"
				  + "<Presentation><Strings Version=\"10\" Uri=\"https://sonos-music.apple.com/xml/strings.xml\"/>"
				  + "<PresentationMap Version=\"7\" Uri=\"http://sonos-pmap.s3.amazonaws.com/applemusic_pmap.1.xml\"/>"
				  + "</Presentation>"
				 + "</Service>"
				+ "</Services>";

		Registry registry = new Registry();
		// registry.bind(URI.class, URIConverter.class);
		Strategy strategy = new RegistryStrategy(registry);
		Serializer serializer = new Persister(strategy);

		try
		{
			MusicServices manager = serializer.read(MusicServices.class, xml);

			System.out.println(manager);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
