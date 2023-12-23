package simpleOrder.core.order;

// 변수는 3가지
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
