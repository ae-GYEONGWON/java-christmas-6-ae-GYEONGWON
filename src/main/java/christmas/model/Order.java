package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int visitDate;
    private Map<String, Integer> items; // 주문한 메뉴와 수량
    private int totalAmount; // 할인 전 총 금액
    private Map<String, Integer> category;
    private String eventBadge; // 이벤트 배지

    public Order() {
        items = new HashMap<>();
        category = new HashMap<>();
        String[] keys = {"Appetizer", "MainCourse", "Dessert", "Beverage"};
        for (String key : keys) {
            category.put(key, 0);
        }
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setTotalAmount(Map<String, Integer> items) {
        this.totalAmount = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String menuNameKorean = entry.getKey();
            Menu menu = new Menu();
            Map<String, String> menuNameMap = menu.getMenuNameMap();
            String menuName = menuNameMap.get(menuNameKorean);
            int quantity = entry.getValue();
            int price = Menu.getPrice(menuNameKorean);
            totalAmount += price * quantity;
            String menuCategory = Menu.findMenuCategory(menuName);
            int currentQuantity = category.getOrDefault(menuCategory, 0);
            setCategory(menuCategory, (currentQuantity + quantity));
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setCategory(String menuCategory, int quantity) {

        category.put(menuCategory, quantity);
    }

    public Map<String, Integer> getCategory() {
        return category;
    }
}
