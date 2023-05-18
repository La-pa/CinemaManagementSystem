package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName room
 */
@TableName(value ="room")
@Data
public class Room implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}