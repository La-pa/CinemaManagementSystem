package entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName ticket
 */
@TableName(value ="ticket")
@Data
public class Ticket implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer sessionId;

    private Integer seatId;

    private Integer price;

    private Session session;

    private Seat seat;

    private static final long serialVersionUID = 1L;
}