package christmas.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {

    public void displayWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void displayEventPreview(int date) {
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
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedValue = numberFormat.format(totalAmount) + "원";
        System.out.println(formattedValue);
    }
}
