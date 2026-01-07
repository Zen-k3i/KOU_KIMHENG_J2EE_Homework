package co.istad.jdbc.model;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String code;
    private String name;
    private BigDecimal price;
    private Integer qty;
    private Boolean status;

    public Product() {}

    public Product(String code, String name, BigDecimal price, Integer qty, Boolean status) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.status = status;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
