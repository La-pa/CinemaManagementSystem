package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @TableName indent
 */
@TableName(value ="indent")
@Data
@ApiModel("订单")
public class Indent implements Serializable {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Date purchaseTime;

    private Long ticketId;

    @TableField(exist = false)
    private Ticket ticket;

    private Integer userId;

    public Indent() {

    }


    public Indent(Date purchaseTime, Long ticketId, Ticket ticket, Integer userId) {
        this.purchaseTime = purchaseTime;
        this.ticketId = ticketId;
        this.ticket = ticket;
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;
}