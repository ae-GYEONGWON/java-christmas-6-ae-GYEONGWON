package christmas;

import christmas.controller.OrderController;
import christmas.model.Order;
import christmas.view.OrderView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Order model = new Order();
        OrderView view = new OrderView();
        OrderController controller = new OrderController(model, view);

        controller.processOrder();
    }
}
