package com.feng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * order
 * </p>
 *
 * @author yang
 * @since 2023-03-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeliveryOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.INPUT)
    private String orderId;

    private String menuId;

    private String staffId;

    @JsonFormat(pattern="MM-dd HH:mm",timezone = "GMT+8")
    private Date orderGenerationTime;

    @JsonFormat(pattern="MM-dd HH:mm",timezone = "GMT+8")
    private Date orderCompletionTime;

    private Integer orderState;

    private String destination;

    private String orderTelephone;


}
