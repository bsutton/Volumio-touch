import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class OrderManager {

	@ElementList(name="order", inline=true, type=Order.class)
    private  List<Order> orders;

//    public OrderManager(@ElementList(name="order", inline=true, type=Order.class) List<Order> orders) {
//        this.orders = orders;
//    }

  //  @ElementList(name="order")
    public List<Order> getOrders() {
        return orders;
    }
}