package decorator.order_processor;

import java.util.LinkedList;
import java.util.Queue;

public class OrderProcessorQueuingDecorator implements IOrderProcessor{
    private IOrderProcessor _orderProcessor;
    private Queue<Order> _orderQueue;
    public OrderProcessorQueuingDecorator(IOrderProcessor orderProcessor){
        _orderProcessor = orderProcessor;
        _orderQueue = new LinkedList<Order>();
    }
    @Override
    public void process(Order order) {
        _orderQueue.add(order);
        System.out.println("Order Processor Process Order: " + order);
    }

}
