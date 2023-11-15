package christmas.controller;

import christmas.model.Discount;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class OrderController {
    private Order order;
    private OutputView outputView;
    private InputView inputView;
    private Discount discount;

    public OrderController(
            Order order,
            InputView inputView,
            OutputView outputView,
            Discount discount
            ) {
        this.order = order;
        this.outputView = outputView;
        this.inputView = inputView;
        this.discount = discount;

    }

    public void processOrder() {
        outputView.displayWelcomeMessage();

        // 예상 방문 날짜 입력받기
        int date = inputView.readDate();
        order.setVisitDate(date);

        // 주문 메뉴와 model개수 입력받기
        String Requestedorder = inputView.readOrder();
        order.setItems(Requestedorder);

        outputView.displayEventPreview(date);
        System.out.println("크리스마스 디데이 할인!!! : " + discount.christmasDiscount(date));

        order.setTotalAmount(order.getItems());
//        System.out.println(order.getItems());


        // 모델 업데이트
        // 뷰 업데이트
    }

    public void discountController() {
        int date = order.getVisitDate();
        Map<String, Integer> categoryMap = order.getCategory();
        int dessertAmount = categoryMap.getOrDefault("Dessert", 0);
        int mainCourseAmount = categoryMap.getOrDefault("MainCourse", 0);
        int christmasDiscount = discount.christmasDiscount(date);
        int weekDiscount = discount.weekDiscount(date, dessertAmount);
        int weekendDiscount = discount.weekendDiscount(date, mainCourseAmount);
        int specialDiscount = discount.specialDiscount(date);
        System.out.println(specialDiscount);
    }

}
