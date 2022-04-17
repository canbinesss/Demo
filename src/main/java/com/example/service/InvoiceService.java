package com.example.service;

import com.example.entity.Invoice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.InvoiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InvoiceService extends ServiceImpl<InvoiceMapper, Invoice> {

    @Resource
    private InvoiceMapper invoiceMapper;

}