import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Order
{

	@Attribute(name = "name")
	private String name;

	@Element(name = "product")
	private String product;

	// public Order(@Attribute(name="name") String name,
	// @Element(name="product") String product)
	// {
	// this.product = product;
	// this.name = name;
	// }

	public String getProduct()
	{
		return product;
	}
}