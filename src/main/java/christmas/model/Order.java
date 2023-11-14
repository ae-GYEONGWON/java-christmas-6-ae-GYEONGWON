package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int visitDate;
    private Map<String, Integer> items; // 주문한 메뉴와 수량
    private int totalAmount; // 할인 전 총 금액
    private String eventBadge; // 이벤트 배지

    public Order() {
        items = new HashMap<>();
    }

    // Constructor, getters, and setters

    // 주문 추가, 할인 계산 등의 메서드 추가

    public void setVisitDate(int date) {
        this.visitDate = date;
    }

    public int getVisitDate() {
        return visitDate;
    }

    public void setItems(String orderedItems) {
        String[] orderedItemsList = orderedItems.split(",");
        for (String orderedItemString : orderedItemsList) {
            String[] orderedItem = orderedItemString.split("-");
            this.items.put(orderedItem[0], Integer.parseInt((orderedItem[1])));
        }
    }

    public void setTotalAmount() {
        totalAmount = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            int price = Menu.getPrice(menuName);
            totalAmount += price * quantity;
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
