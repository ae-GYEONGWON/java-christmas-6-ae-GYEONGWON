package christmas.view;

public class OutputView {

    public void displayWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void displayEventPreview(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
    public void printMenu() {
        System.out.println("<주문 메뉴>");
        // ...
    }
    // ...
}
