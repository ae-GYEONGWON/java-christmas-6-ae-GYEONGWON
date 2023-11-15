package christmas.model;

public class Discount {
    /*
    크리스마스 디데이 할인
이벤트 기간: 2023.12.1 ~ 2023.12.25
1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
총주문 금액에서 해당 금액만큼 할인
(e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
     */
    private int discountAmount; // 총 할인 금액
    private int date;
    Order order;

    public Discount() {
        discountAmount = 0;
        order = new Order();
    }

    public void setDiscountAmount(int money) {
        discountAmount = money;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int christmasDiscount(int date) {
        if (1 <= date && date <= 25) {
            return 1000 + (100 * (date - 1));
        }
        return 0;
    }

    /*
    평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
     */
    public int weekDiscount(int date, int dessertAmount) {
        if (isWeekend(date)) {
            return 2023 * dessertAmount;
        }
        return 0;
    }

    public int weekendDiscount(int date, int mainCourseAmount) {
        if (!isWeekend(date)) {
            return 2023 * mainCourseAmount;
        }
        return 0;
    }

    public boolean isWeekend(int date) {
        int dayOfWeek = (date - 1) % 7;
        return dayOfWeek == 0 || dayOfWeek == 1;
    }
    /*
    특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
     */
    public int specialDiscount(int date) {
        if (date % 7 == 3 || date == 25) {
            return 1000;
        }
        return 0;
    }
    /*
    증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
     */
    public boolean giveawayPromotion(int money) {
        return money >= 120000;
    }
}