package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName seat
 */
@TableName(value ="seat")
@Data
public class Seat implements Serializable {
    private Integer id;

    private String rowNum;

    private Integer colNum;

    private Integer roomId;

    private static final long serialVersionUID = 1L;
}