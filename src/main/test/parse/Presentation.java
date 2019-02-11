package parse;


import org.simpleframework.xml.Element;



public class Presentation
{
	@Element(name="Strings")
	private Strings strings;
	
	@Element(name = "PresentationMap")
	private PresentationMap presentationMap;
	
	public String toString()
	{
		return strings + ":" + presentationMap;
		
	}

}
