package parse;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


//@Root(name = "Policy")

public class Policy
{
	@Attribute(name="Auth")
	String auth;
	
	@Attribute(name="PollInterval")
	String pollInterval;

	public String toString()
	{
		return "Auth:" + auth + ", PollInterval:" + pollInterval;
	}
}
