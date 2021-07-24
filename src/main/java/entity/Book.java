package entity;

import java.util.Objects;

public class Book {
    private Long id;
    private String name;
    private Double cost;
    private String url;
    private String briefInfo;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return amount == book.amount && Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(cost, book.cost) && Objects.equals(url, book.url) && Objects.equals(briefInfo, book.briefInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, url, briefInfo, amount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", url='" + url + '\'' +
                ", briefInfo='" + briefInfo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
