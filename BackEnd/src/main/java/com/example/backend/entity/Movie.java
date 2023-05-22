package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @TableName movie
 */
@TableName(value ="movie")
@Data
@ApiModel("电影")
public class Movie implements Serializable {
    @ApiModelProperty("电影ID")
    private Integer id;

    @ApiModelProperty("电影名")
    private String title;

    @ApiModelProperty("类型")
    private String genre;

    @ApiModelProperty("导演")
    private String director;

    @ApiModelProperty("是否放映状态")
    private Integer showStatus;

    @ApiModelProperty("封面的url")
    private String imageUrl;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("开始放映的日期")
    private Date releaseDate;

    private static final long serialVersionUID = 1L;
}