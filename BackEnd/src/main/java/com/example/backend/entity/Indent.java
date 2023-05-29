package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("购买时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime purchaseTime;

    @ApiModelProperty("电影票ID（外键）")
    private Long ticketId;

    @ApiModelProperty("电影票信息")
    @TableField(exist = false)
    private Ticket ticket;

    @ApiModelProperty("用户ID（外键）")
    private Long userId;

    public Indent() { }


    public Indent(LocalDateTime purchaseTime, Long ticketId, Ticket ticket, Long userId) {
        this.purchaseTime = purchaseTime;
        this.ticketId = ticketId;
        this.ticket = ticket;
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;
}