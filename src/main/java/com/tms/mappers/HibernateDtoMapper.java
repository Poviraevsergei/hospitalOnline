package com.tms.mappers;

import com.tms.domain.*;

import java.util.HashSet;
import java.util.Set;

public class HibernateDtoMapper {
    public static CustomerExampleDto getCustomerExampleDto(CustomerExample customerExample) {
        Set<ProductExampleDto> resultProductList = new HashSet<>();
        for (ProductExample pe : customerExample.getProducts()) {
            ProductExampleDto ped = new ProductExampleDto();
            ped.setId(pe.getId());
            ped.setProductInfo(pe.getProductInfo());
            resultProductList.add(ped);
        }

        UserExampleDto ued = new UserExampleDto();
        ued.setId(customerExample.getUserExample().getId());
        ued.setUsername(customerExample.getUserExample().getUsername());
        ued.setTelephones(customerExample.getUserExample().getTelephones());

        CustomerExampleDto cud = new CustomerExampleDto();
        cud.setId(customerExample.getId());
        cud.setCustomerName(customerExample.getCustomerName());
        cud.setUserExample(ued);
        cud.setProducts(resultProductList);
        return cud;
    }

    public static ProductExampleDto getProductExampleDto(ProductExample productExample) {
        Set<CustomerExampleDto> resultCustomerList = new HashSet<>();
        for (CustomerExample pe : productExample.getCustomers()) {
            UserExampleDto ued = new UserExampleDto();
            ued.setId(pe.getUserExample().getId());
            ued.setUsername(pe.getUserExample().getUsername());
            ued.setTelephones(pe.getUserExample().getTelephones());

            CustomerExampleDto ced = new CustomerExampleDto();
            ced.setId(pe.getId());
            ced.setUserExample(ued);
            ced.setCustomerName(pe.getCustomerName());
            resultCustomerList.add(ced);
        }

        ProductExampleDto ped = new ProductExampleDto();
        ped.setId(productExample.getId());
        ped.setProductInfo(productExample.getProductInfo());
        ped.setCustomers(resultCustomerList);

        return ped;
    }

    public static UserExampleDto getUserExampleDto(UserExample userExample) {
        Set<ProductExampleDto> productDtoList = new HashSet<>();
        for (ProductExample pe : userExample.getCustomer().getProducts()) {
            ProductExampleDto productExampleDto = new ProductExampleDto();
            productExampleDto.setId(pe.getId());
            productExampleDto.setProductInfo(pe.getProductInfo());
            productDtoList.add(productExampleDto);
        }

        CustomerExampleDto customerExampleDto = new CustomerExampleDto();
        customerExampleDto.setId(userExample.getCustomer().getId());
        customerExampleDto.setCustomerName(userExample.getCustomer().getCustomerName());
        customerExampleDto.setProducts(productDtoList);

        UserExampleDto ued = new UserExampleDto();
        ued.setId(userExample.getId());
        ued.setUsername(userExample.getUsername());
        ued.setCustomer(customerExampleDto);
        ued.setTelephones(userExample.getTelephones());
        return ued;
    }
}