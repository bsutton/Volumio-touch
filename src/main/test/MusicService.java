import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.convert.RegistryStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

public class MusicService
{

	@Test
	public void test()
	{
		
		String xml = 
				
"<orderManager>\n"
+ "    <order name=\"AX101\">\n"
+ "        <product>Product A</product>\n"
+ "    </order>\n"
+ "    <order name=\"AX102\">\n"
+ "        <product>Product B</product>\n"
+ "    </order>\n"
+ "    <order name=\"AX103\">\n"
+ "        <product>Product C</product>\n"
+ "    </order>\n"
+ "</orderManager>";
	
		Registry registry = new Registry();
	//	registry.bind(URI.class, URIConverter.class);
		Strategy strategy = new RegistryStrategy(registry);
		Serializer serializer = new Persister(strategy);
		
		try
		{
			OrderManager manager = serializer
			.read(OrderManager.class, xml);
			
			System.out.println(manager);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
