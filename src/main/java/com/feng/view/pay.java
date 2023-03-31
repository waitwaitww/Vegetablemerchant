package com.feng.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class pay implements Serializable {
    private String waiterName;
    private Float basePay;
    private Integer orderQuantity;
    private Integer complain;
    private Float salary;

    public void countSalary(){
        this.setSalary(basePay+orderQuantity*2-complain*20);
    }
}
