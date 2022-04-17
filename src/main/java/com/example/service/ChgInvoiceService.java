package com.example.service;

import com.example.entity.ChgInvoice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ChgInvoiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChgInvoiceService extends ServiceImpl<ChgInvoiceMapper, ChgInvoice> {

    @Resource
    private ChgInvoiceMapper chgInvoiceMapper;

    public List<ChgInvoice> getByUserId(Long id) {
        return chgInvoiceMapper.getByUserId(id);
    }
}