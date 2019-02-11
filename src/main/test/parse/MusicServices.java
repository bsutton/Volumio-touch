package parse;


import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="Services")
public class MusicServices
{
	@Attribute(name="SchemaVersion")
	private String schemaVersion;
	
//	@ElementList(name="Service")
//	private List<MusicService> serviceList; 
	
	//@ElementArray(name="Service")
	
	@ElementList(name="Service", inline=true, type=MusicService.class)
	private List<MusicService> musicServices;
	
	


    public List<MusicService> getMusicServices() {
        return musicServices;
    }
	
//	public List<MusicService> getMusicServiceList()
//	{
//		return serviceList;
//	}

    
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for (MusicService service: musicServices)
    	{
    		sb.append(service);
    		sb.append("\n");
    	}
    	return sb.toString();
    }
}
