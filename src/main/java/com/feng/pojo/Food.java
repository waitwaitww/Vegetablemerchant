package com.feng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * food
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
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "food_id", type = IdType.ASSIGN_ID)
    private String foodId;

    private String typeId;

    private String foodName;

    private String foodAlias;

    private String foodSpecifications;

    private Integer foodState;

    private Date manufactureDate;

    private Date validDate;

    private Integer isSeasonal;

    private Float unitPrice;

    private String defaultImage;


}
