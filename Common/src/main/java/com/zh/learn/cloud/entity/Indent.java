package com.zh.learn.cloud.entity;

import java.io.Serializable;

/**
  * TODO
  * @since 2020-08-24 16:46
  * @author ZhouHu
  **/  
    
public class Indent implements Serializable {
    private Long id;

    /**
    * 商品ID
    */
    private Long produceId;

    /**
    * 商品数量
    */
    private Long productOunt;

    /**
    * 商品价格单位为分
    */
    private Long price;

    /**
    * 总价是多少
    */
    private Long totalPrice;

    /**
    * 订单状态 0 -> 未付款. 1 -> 待发货. 2 -> 待收货. 4 -> 待评价
    */
    private Long orderStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduceId() {
        return produceId;
    }

    public void setProduceId(Long produceId) {
        this.produceId = produceId;
    }

    public Long getProductOunt() {
        return productOunt;
    }

    public void setProductOunt(Long productOunt) {
        this.productOunt = productOunt;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", produceId=").append(produceId);
        sb.append(", productOunt=").append(productOunt);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append("]");
        return sb.toString();
    }
}