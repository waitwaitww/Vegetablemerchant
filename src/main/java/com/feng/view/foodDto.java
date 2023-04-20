package com.feng.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class foodDto {

    private String foodId;

    private String foodName;

    private String foodAlias;

    private String foodSpecifications;

    private Integer foodState;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date manufactureDate;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date validDate;

    private Integer isSeasonal;

    private Float unitPrice;

    private String defaultImage;

    private String typeName;


}
