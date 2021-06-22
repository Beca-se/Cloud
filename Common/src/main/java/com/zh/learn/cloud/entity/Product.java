package com.zh.learn.cloud.entity;

import java.io.Serializable;

/**
 * Table(Product)实体类
 *
 * @author ZhouHu
 * @since 2020-08-22 12:28
 **/

public class Product implements Serializable {
    private static final long serialVersionUID = 9468L;

    private Long id;

    /**
     * 商品标题
     */
    private String name;

    /**
     * 商品价格单位为分
     */
    private Long price;

    /**
     * 商品种类
     */
    private String category;

    /**
     * 商品数量
     */
    private Long pnum;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 商品描述
     */
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getPnum() {
        return pnum;
    }

    public void setPnum(Long pnum) {
        this.pnum = pnum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", category=").append(category);
        sb.append(", pnum=").append(pnum);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}