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
 * work_type
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
public class WorkType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "work_type_id", type = IdType.ASSIGN_ID)
    private String workTypeId;

    private String workTypeName;


}
