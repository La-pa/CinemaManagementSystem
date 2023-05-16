package entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Order implements Serializable {
    private Integer id;

    private Date purchaseTime;

    private Integer ticketId;

    private Integer userId;

    private Ticket ticket;

    private static final long serialVersionUID = 1L;
}