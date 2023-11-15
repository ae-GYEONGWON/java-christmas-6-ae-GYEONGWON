package christmas.controller;

public class Validator {
    public boolean dateValidate(String dateString) {
        int date;
        try {
            date = Integer.parseInt(dateString);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return false;
        }
        if (1 <= date && date <= 31) {
            return true;
        }
        System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        return false;
    }

    public boolean orderValidate(String orderedItems) {
        String[] orderedItemsList = orderedItems.split(",");
        for (String orderedItemString : orderedItemsList) {
            String[] orderedItem = orderedItemString.split("-");
            int quantity;
            try {
                quantity = Integer.parseInt(orderedItem[1]);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return false;
            }
            if (0 <= quantity) {
                return true;
            }
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return false;
        }
        return true;
    }
}
