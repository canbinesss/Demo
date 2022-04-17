package com.example.service;

import com.example.entity.ChgDetail;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ChgDetailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ChgDetailService extends ServiceImpl<ChgDetailMapper, ChgDetail> {

    @Resource
    private ChgDetailMapper chgDetailMapper;

    public List<ChgDetail> getByInvoiceCode(String invoiceCode) {
        return chgDetailMapper.getByInvoiceCode(invoiceCode);
    }

    public List<HashMap> getgoods() {
        return chgDetailMapper.getgoods();
    }
}