package com.example.yida.dagger2demo.demo2;

import javax.inject.Inject;

/**
 * Created by yida on 2018/7/31.
 */

public class Two {

    Product mProduct;

    @Inject
    public Two(Product product) {
        mProduct = product;
    }
}
