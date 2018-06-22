package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class OperaPrice {
    private Integer id;

    private Integer operaId;

    private BigDecimal price;

    private Integer deadline;

    private Date createtime;

    private Integer isSpecial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperaId() {
        return operaId;
    }

    public void setOperaId(Integer operaId) {
        this.operaId = operaId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }
}