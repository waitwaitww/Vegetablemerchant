package com.feng;

import com.feng.pojo.Food;
import com.feng.pojo.Staff;
import com.feng.service.FoodService;
import com.feng.service.StaffService;
import com.feng.service.SystemAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VegetablemerchantApplicationTests {

    @Autowired
    @Qualifier("FoodServiceImpl")
    private FoodService foodService;

    @Test
    void contextLoads() {
        List<Food> foods = foodService.queryFoodByName("花");
        foods.forEach(System.out::println);
    }

}
