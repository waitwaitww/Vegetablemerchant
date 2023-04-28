package com.feng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2023-04-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopingCar implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车id
     */
      @TableId(value = "car_id", type = IdType.INPUT)
    private String carId;

    private String consumerId;

    private int foodnum;

    private float totalprice;


}
