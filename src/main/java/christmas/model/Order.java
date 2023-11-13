package christmas.model;

import java.util.Map;

public class Order {
    private int visitDate;
    private Map<String, Integer> items; // 주문한 메뉴와 수량
    private int totalAmount; // 할인 전 총 금액
    private int discountAmount; // 총 할인 금액
    private String eventBadge; // 이벤트 배지

    // Constructor, getters, and setters

    // 주문 추가, 할인 계산 등의 메서드 추가

    public void setVisitDate(String visitDate) {
        this.visitDate = Integer.parseInt(visitDate);
    }

    public int getVisitDate() {
        return visitDate;
    }

    public void setItems(String orderedItems) {
        String[] orderedItemsList = orderedItems.split(",");
        for ( String orderedItemString : orderedItemsList ) {
            String[] orderedItem = orderedItemString.split("-");
            this.items.put(orderedItem[0], Integer.parseInt((orderedItem[1])));
        }
    }

}
