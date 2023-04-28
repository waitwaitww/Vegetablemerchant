package com.feng.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class carDto {

    private String carId;
    private String consumerId;
    private int foodnum;
    private float totalprice;
    private String foodName;
    private String foodId;
    private int counts;
    private float unitPrice;
}
