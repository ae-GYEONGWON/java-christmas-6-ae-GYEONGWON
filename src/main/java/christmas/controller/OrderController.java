package christmas.controller;

import christmas.model.Order;
import christmas.view.OrderView;

public class OrderController {
    private Order model;
    private OrderView view;

    public OrderController(Order model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public void processOrder() {
        view.displayWelcomeMessage();

        // 입력 받기
        // 모델 업데이트
        // 뷰 업데이트
    }

    // 다른 메서드 추가
}
