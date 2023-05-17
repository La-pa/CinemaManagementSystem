package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName ticket
 */
@TableName(value ="ticket")
@Data
public class Ticket implements Serializable {
    private Long id;

    private Integer sessionId;

    @TableField(exist = false)
    private Session session;

    private Integer seatId;

    @TableField(exist = false)
    private Seat seat;

    private Integer price;

    private static final long serialVersionUID = 1L;
}