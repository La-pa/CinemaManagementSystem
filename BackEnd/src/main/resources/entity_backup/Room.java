package entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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