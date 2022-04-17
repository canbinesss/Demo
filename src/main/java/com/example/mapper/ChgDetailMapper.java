package com.example.mapper;

import com.example.entity.ChgDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

public interface ChgDetailMapper extends BaseMapper<ChgDetail> {

    List<ChgDetail> getByInvoiceCode(String invoiceCode);

    List<HashMap> getgoods();
}