package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName session
 */
@TableName(value ="session")
@Data
@ApiModel("场次")
public class Session implements Serializable {
    @ApiModelProperty("场次ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("场次开始时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("电影ID（外键）")
    private Integer movieId;

    @ApiModelProperty("电影信息")
    @TableField(exist = false)
    private Movie movie;

    @ApiModelProperty("放映厅ID（外键）")
    private Long roomId;

    @ApiModelProperty("放映厅信息")
    @TableField(exist = false)
    private Room room;

    @ApiModelProperty("价格")
    private Long price;

    private static final long serialVersionUID = 1L;
}