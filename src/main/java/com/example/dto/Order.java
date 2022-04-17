package com.example.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String url;
    private String goodsname;
    private BigDecimal price;
    private Integer num;
    private BigDecimal xj;
    private String checked;

}
