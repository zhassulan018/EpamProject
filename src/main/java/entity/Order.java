package entity;

import java.util.Objects;

public class Order {
    private Long id;
    private String status;
    private Long basketUserId;
    private Long basketBookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBasketUserId() {
        return basketUserId;
    }

    public void setBasketUserId(Long basketUserId) {
        this.basketUserId = basketUserId;
    }

    public Long getBasketBookId() {
        return basketBookId;
    }

    public void setBasketBookId(Long basketBookId) {
        this.basketBookId = basketBookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(status, order.status) && Objects.equals(basketUserId, order.basketUserId) && Objects.equals(basketBookId, order.basketBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, basketUserId, basketBookId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", basketUserId=" + basketUserId +
                ", basketBookId=" + basketBookId +
                '}';
    }
}
