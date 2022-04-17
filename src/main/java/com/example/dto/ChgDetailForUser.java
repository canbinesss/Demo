package com.example.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liuyang
 * @date 2021年05月06日22:18
 */
@Data
public class ChgDetailForUser {
    private String invCode;
    private String goodsname;
    private String imgurl;
    private String num;
    private BigDecimal money;
    private Date date;
}
