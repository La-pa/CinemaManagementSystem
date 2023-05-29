package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName seat
 */
@TableName(value ="seat")
@Data
@ApiModel("座位")
public class Seat implements Serializable {
    @ApiModelProperty("座位ID")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("座位的行坐标")
    private String seatRow;

    @ApiModelProperty("座位的列坐标")
    private Integer seatCol;

    @ApiModelProperty("放映厅ID（外键）")
    private Integer roomId;

    private static final long serialVersionUID = 1L;
}