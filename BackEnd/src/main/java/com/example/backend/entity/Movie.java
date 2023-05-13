package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName movie
 */
@TableName(value ="movie")
@Data
public class Movie implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}