package christmas.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {

    public void displayWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void displayBenefitPreview(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public void printMenu(Map<String, Integer> items) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(menuName + " " + quantity + "개");
        }
    }
    public void printTotalAmount(int totalAmount) {
        System.out.println("<할인 전 총주문 금액>");
        String formattedValue = numberFormatWithWon(totalAmount);
        System.out.println(formattedValue);
    }
    public void printGiveaway(boolean giveaway) {
        System.out.println("<증정 메뉴>");
        if (giveaway) {
            System.out.println("샴페인 1개");
        }
        if (!giveaway) {
            System.out.println("없음");
        }
    }
//    <혜택 내역>
//    크리스마스 디데이 할인: -1,200원
//    평일 할인: -4,046원
//    특별 할인: -1,000원
//    증정 이벤트: -25,000원
    public void printBenefitDetails(int christmasDiscount, int weekDiscount, int weekendDiscount, int specialDiscount, boolean giveaway) {
        System.out.println("<혜택 내역>");
        if (christmasDiscount == 0 && weekDiscount == 0 && weekendDiscount == 0 && specialDiscount == 0 && giveaway == false) {
            System.out.println("없음");
        }
        if (christmasDiscount != 0) {
            System.out.println("크리스마스 디데이 할인: " + "-" + numberFormatWithWon(christmasDiscount));
        }
        if (weekDiscount != 0) {
            System.out.println("평일 할인: " + "-" + numberFormatWithWon(weekDiscount));
        }
        if (weekendDiscount != 0) {
            System.out.println("주말 할인: " + "-" + numberFormatWithWon(weekendDiscount));
        }
        if (specialDiscount != 0) {
            System.out.println("특별 할인: " + "-" + numberFormatWithWon(specialDiscount));
        }
        if (giveaway) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public String numberFormatWithWon(int money) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(money) + "원";
    }

    public void printDiscountAmount(int money) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + numberFormatWithWon(money));
    }
}
