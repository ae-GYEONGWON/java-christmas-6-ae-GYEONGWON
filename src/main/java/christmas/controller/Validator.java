package christmas.controller;

public class Validator {
    public boolean dateValidate(int date) {
        if (1 <= date && date <= 31) {
            return true;
        }
        System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        return false;
    }
}
