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
 * @TableName movie
 */
@TableName(value ="movie")
@Data
@ApiModel("电影")
public class Movie implements Serializable {
    private Integer id;

    private String title;

    private String genre;

    private String director;

    private Integer showStatus;

    private String imageUrl;

    private String introduction;

    @TableField("release_date")
    private Date releaseDate;

    private static final long serialVersionUID = 1L;
}