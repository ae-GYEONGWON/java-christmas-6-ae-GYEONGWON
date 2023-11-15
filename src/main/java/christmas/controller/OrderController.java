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

        outputView.displayBenefitPreview(date);

        order.setTotalAmount(order.getItems());
    }

    public void discountCalculator() {
        int date = order.getVisitDate();
        Map<String, Integer> categoryMap = order.getCategory();
        int dessertAmount = categoryMap.getOrDefault("Dessert", 0);
        int mainCourseAmount = categoryMap.getOrDefault("MainCourse", 0);

        discount.christmasDiscount(date);
        discount.weekDiscount(date, dessertAmount);
        discount.weekendDiscount(date, mainCourseAmount);
        discount.specialDiscount(date);
        discount.giveawayPromotion(order.getTotalAmount());

        int christmasDiscount = discount.getChristmasDiscount();
        int weekDiscount = discount.getWeekDiscount();
        int weekendDiscount = discount.getWeekendDiscount();
        int specialDiscount = discount.getSpecialDiscount();

        int sumDiscount = christmasDiscount + weekDiscount + weekendDiscount + specialDiscount;
        discount.setDiscountAmount(sumDiscount);
    }

    public void printresult() {
        outputView.printMenu(order.getItems());
        outputView.printTotalAmount(order.getTotalAmount());
        outputView.printGiveaway(discount.getGiveaway());
        outputView.printBenefitDetails(discount.getChristmasDiscount(), discount.getWeekDiscount(), discount.getWeekendDiscount(), discount.getSpecialDiscount(),discount.getGiveaway());
    }
}
