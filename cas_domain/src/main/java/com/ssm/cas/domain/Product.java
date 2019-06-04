package com.ssm.cas.domain;

import com.ssm.cas.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 商品类
 *
 * @author 胖虎
 */
public class Product {
    /**
     * 主键
     */
    private String id;
    /**
     * 商品编号 唯一
     */
    private String productNum;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 目标城市
     */
    private String departureCity;
    /**
     * 出发时间
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureTime;
    private String departureTimeStr;
    /**
     * 商品价格
     */
    private double productPrice;
    /**
     * 商品描述
     */
    private String productDesc;
    /**
     * 商品状态 关闭0 打开1
     */
    private boolean open;
    private String productStatusStr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        departureTimeStr = null;
        if (departureTime != null) {
            departureTimeStr = DateUtils.dateToString(departureTime, "yyyy-MM-dd HH:mm");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getProductStatusStr() {
        return (open ? "开" : "关");
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", open=" + open +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
