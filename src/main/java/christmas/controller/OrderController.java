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
    Validator validator = new Validator();

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
        String dateString;
        // 예상 방문 날짜 입력받기
        do {
            dateString = inputView.readDate();
        } while (!validator.dateValidate(dateString));
        order.setVisitDate(Integer.parseInt(dateString));

        // 주문 메뉴와 model개수 입력받기
        String Requestedorder = inputView.readOrder();
        order.setItems(Requestedorder);
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
        boolean giveaway = discount.getGiveaway();

        int sumDiscount = christmasDiscount + weekDiscount + weekendDiscount + specialDiscount;
        discount.setRealdiscountAmount(sumDiscount);
        if (giveaway) {
            sumDiscount += 25000;
            discount.setDiscountAmount(sumDiscount);
        }
    }

    public void printresult() {
        outputView.displayBenefitPreview(order.getVisitDate());
        outputView.printMenu(order.getItems());
        outputView.printTotalAmount(order.getTotalAmount());
        outputView.printGiveaway(discount.getGiveaway());
        outputView.printBenefitDetails(discount.getChristmasDiscount(), discount.getWeekDiscount(), discount.getWeekendDiscount(), discount.getSpecialDiscount(),discount.getGiveaway());
        outputView.printDiscountAmount(discount.getDiscountAmount());
        outputView.printExpectedPrice(order.getTotalAmount()-discount.getRealdiscountAmount());
        outputView.printBadge(discount.getBadge(discount.getDiscountAmount()));
    }
}
