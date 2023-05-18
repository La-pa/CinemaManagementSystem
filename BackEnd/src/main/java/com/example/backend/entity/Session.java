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
 * @TableName session
 */
@TableName(value ="session")
@Data
@ApiModel("场次")
public class Session implements Serializable {
    private Integer id;

    private Date startTime;

    private Integer movieId;

    @TableField(exist = false)
    private Movie movie;

    private Integer roomId;

    @TableField(exist = false)
    private Room room;

    private static final long serialVersionUID = 1L;
}