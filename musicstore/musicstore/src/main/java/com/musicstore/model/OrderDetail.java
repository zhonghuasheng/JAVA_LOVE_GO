package com.musicstore.model;

public class OrderDetail {
    private long orderDetailId;
    private long orderId;
    private long albumId;
    private long quantity;
    private double unitPrice;

    public long getOrderDetailId() {
        return orderDetailId;
    }
    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public long getAlbumId() {
        return albumId;
    }
    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
