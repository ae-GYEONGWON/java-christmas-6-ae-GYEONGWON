package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<String, String> menuNameMap;

    public Menu() {
        menuNameMap = new HashMap<>();
        setMenuNameMap();
    }

    public enum Appetizer {
        MUSHROOM_SOUP(6000),
        TAPAS(5500),
        CAESAR_SALAD(8000);

        private final int price;

        Appetizer(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public enum MainCourse {
        T_BONE_STEAK(55000),
        BBQ_RIBS(54000),
        SEAFOOD_PASTA(35000),
        CHRISTMAS_PASTA(25000);

        private final int price;

        MainCourse(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public enum Dessert {
        CHOCOLATE_CAKE(15000),
        ICE_CREAM(5000);

        private final int price;

        Dessert(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public enum Beverage {
        ZERO_COLA(3000),
        RED_WINE(60000),
        CHAMPAGNE(25000);

        private final int price;

        Beverage(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public static int getPrice(String menuName) {
        String menuCategory = Menu.findMenuCategory(menuName);
        if (menuCategory.equals("Appetizer")) {
            return Appetizer.valueOf(menuName).getPrice();
        }
        if (menuCategory.equals("MainCourse")) {
            return MainCourse.valueOf(menuName).getPrice();
        }
        if (menuCategory.equals("Dessert")) {
            return Dessert.valueOf(menuName).getPrice();
        }
        if (menuCategory.equals("Beverage")) {
            return Beverage.valueOf(menuName).getPrice();
        }
        return -1;
    }

    public static String findMenuCategory(String menuName) {
        if (findInEnum(Appetizer.values(), menuName)) {
            return "Appetizer";
        }
        if (findInEnum(MainCourse.values(), menuName)) {
            return "MainCourse";
        }
        if (findInEnum(Dessert.values(), menuName)) {
            return "Dessert";
        }
        if (findInEnum(Beverage.values(), menuName)) {
            return "Beverage";
        }

        return "Unknown Category";
    }

    private static <E extends Enum<E>> boolean findInEnum(E[] enumValues, String name) {
        for (E e : enumValues) {
            if (e.name().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private void setMenuNameMap() {
        menuNameMap.put("양송이스프", "MUSHROOM_SOUP");
        menuNameMap.put("타파스", "TAPAS");
        menuNameMap.put("시저샐러드", "CAESAR_SALAD");
        menuNameMap.put("티본스테이크", "T_BONE_STEAK");
        menuNameMap.put("바비큐립", "BBQ_RIBS");
        menuNameMap.put("해산물파스타", "SEAFOOD_PASTA");
        menuNameMap.put("크리스마스파스타", "CHRISTMAS_PASTA");
        menuNameMap.put("초코케이크", "CHOCOLATE_CAKE");
        menuNameMap.put("아이스크림", "ICE_CREAM");
        menuNameMap.put("제로콜라", "ZERO_COLA");
        menuNameMap.put("레드와인", "RED_WINE");
        menuNameMap.put("샴페인", "CHAMPAGNE");
    }

    public Map<String, String> getMenuNameMap() {
        return menuNameMap;
    }
}
