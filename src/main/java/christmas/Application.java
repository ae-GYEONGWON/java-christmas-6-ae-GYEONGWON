package christmas;

import christmas.controller.OrderController;
import christmas.model.Discount;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Order model = new Order();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Discount discount = new Discount();
        OrderController controller = new OrderController(model, inputView, outputView, discount);

        controller.processOrder();
        controller.discountController();
    }
}
