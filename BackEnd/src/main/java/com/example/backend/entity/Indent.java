package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName indent
 */
@TableName(value ="indent")
@Data
public class Indent implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Date purchaseTime;

    private Long ticketId;

    @TableField(exist = false)
    private Ticket ticket;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}