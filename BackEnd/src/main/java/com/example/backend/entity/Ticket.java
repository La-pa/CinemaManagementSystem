package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName ticket
 */
@TableName(value ="ticket")
@Data
@ApiModel("电影票")
public class Ticket implements Serializable {
    @ApiModelProperty("电影票ID")
//    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("场次ID（外键）")
    private Integer sessionId;

    @ApiModelProperty("场次信息")
    @TableField(exist = false)
    private Session session;

    @ApiModelProperty("座位ID（外键）")
    private Integer seatId;

    @ApiModelProperty("座位信息")
    @TableField(exist = false)
    private Seat seat;

    private static final long serialVersionUID = 1L;
}