package com.musicstore.model;

import java.util.Date;

public class Cart {
    private long recordId;
    private long cartId;
    private long albumId;
    private int count;
    private Date createDate;

    public long getRecordId() {
        return recordId;
    }
    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }
    public long getCartId() {
        return cartId;
    }
    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
    public long getAlbumId() {
        return albumId;
    }
    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
