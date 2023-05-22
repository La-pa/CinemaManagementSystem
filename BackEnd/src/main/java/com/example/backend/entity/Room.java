package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName room
 */
@TableName(value ="room")
@Data
@ApiModel("放映厅")
public class Room implements Serializable {
    @ApiModelProperty("放映厅ID")
    private Integer id;

    @ApiModelProperty("放映厅厅名")
    private String name;

    private static final long serialVersionUID = 1L;
}