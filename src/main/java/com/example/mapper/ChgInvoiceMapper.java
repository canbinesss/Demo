package com.example.mapper;

import com.example.entity.ChgInvoice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface ChgInvoiceMapper extends BaseMapper<ChgInvoice> {

    List<ChgInvoice> getByUserId(Long id);
}