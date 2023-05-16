package entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName session
 */
@TableName(value ="session")
@Data
public class Session implements Serializable {
    private Integer id;

    private Date startTime;

    private Integer movieId;

    private Integer roomId;

    private Movie movie;

    private Room room;

    private static final long serialVersionUID = 1L;
}