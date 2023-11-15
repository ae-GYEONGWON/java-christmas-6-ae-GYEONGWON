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
    private int realdiscountAmount; // 증정이 포함되지 않은 할인 금액
    private int christmasDiscount;
    private int weekDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private boolean giveaway;
    Order order;

    public Discount() {
        discountAmount = 0;
        realdiscountAmount = 0;
        christmasDiscount = 0;
        weekendDiscount = 0;
        weekDiscount = 0;
        specialDiscount = 0;
        giveaway = false;
        order = new Order();
    }

    public void setDiscountAmount(int money) {
        discountAmount = money;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setRealdiscountAmount(int money) {
        realdiscountAmount = money;
    }

    public int getRealdiscountAmount() {
        return realdiscountAmount;
    }

    public void christmasDiscount(int date) {
        if (1 <= date && date <= 25) {
            christmasDiscount = 1000 + (100 * (date - 1));
        }
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    /*
    평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
    주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
     */
    public void weekDiscount(int date, int dessertAmount) {
        if (!isWeekend(date)) {
            weekDiscount = 2023 * dessertAmount;
        }
    }

    public int getWeekDiscount() {
        return weekDiscount;
    }

    public void weekendDiscount(int date, int mainCourseAmount) {
        if (isWeekend(date)) {
            weekendDiscount = 2023 * mainCourseAmount;
        }
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public boolean isWeekend(int date) {
        int dayOfWeek = (date - 1) % 7;
        return dayOfWeek == 0 || dayOfWeek == 1;
    }

    /*
    특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
     */
    public void specialDiscount(int date) {
        if (date % 7 == 3 || date == 25) {
            specialDiscount = 1000;
        }
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    /*
    증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
    이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
     */
    public void giveawayPromotion(int money) {
        giveaway = money >= 120000;
    }

    public boolean getGiveaway() {
        return giveaway;
    }
    /*
    5천 원 이상: 별
    1만 원 이상: 트리
    2만 원 이상: 산타
     */
    public String getBadge(int money) {
        if (money >= 20000) {
            return "산타";
        }
        if (money >= 10000) {
            return "트리";
        }
        if (money >= 5000) {
            return "별";
        }
        return "없음";
    }

}