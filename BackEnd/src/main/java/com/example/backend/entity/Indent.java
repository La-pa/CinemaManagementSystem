package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName indent
 */
@TableName(value ="indent")
@Data
@ApiModel("订单")
public class Indent implements Serializable {
    @ApiModelProperty("订单ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("购买时间")
    private Date purchaseTime;

    @ApiModelProperty("电影票ID（外键）")
    private Long ticketId;

    @ApiModelProperty("电影票信息")
    @TableField(exist = false)
    private Ticket ticket;

    @ApiModelProperty("用户ID（外键）")
    private Integer userId;

    public Indent() { }


    public Indent(Date purchaseTime, Long ticketId, Ticket ticket, Integer userId) {
        this.purchaseTime = purchaseTime;
        this.ticketId = ticketId;
        this.ticket = ticket;
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;
}