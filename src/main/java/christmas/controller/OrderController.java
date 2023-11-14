package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
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

        // 예상 방문 날짜 입력받기
        view.displayExpectedDateRequest();
        model.setVisitDate(Console.readLine());

        // 주문 메뉴와 개수 입력받기
        view.displayOrderRequest();
        model.setItems(Console.readLine());
        view.displayEventPreview(model.getVisitDate());



        // 모델 업데이트
        // 뷰 업데이트
    }

    // 다른 메서드 추가

}
