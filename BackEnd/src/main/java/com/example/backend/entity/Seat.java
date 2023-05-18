package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @TableName seat
 */
@TableName(value ="seat")
@Data
@ApiModel("座位")
public class Seat implements Serializable {
    private Integer id;

    private String seatRow;

    private Integer seatCol;

    private Integer roomId;

    private static final long serialVersionUID = 1L;
}