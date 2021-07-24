package entity;

import java.util.Objects;

public class Basket {
    private Integer amount;
    private Long userId;
    private Long bookId;
    private boolean bought;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;
        Basket basket = (Basket) o;
        return bought == basket.bought && Objects.equals(amount, basket.amount) && Objects.equals(userId, basket.userId) && Objects.equals(bookId, basket.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, userId, bookId, bought);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "amount=" + amount +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bought=" + bought +
                '}';
    }
}
