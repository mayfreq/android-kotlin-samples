package com.example.simpleshoppingapp.data

import com.example.simpleshoppingapp.R
import com.example.simpleshoppingapp.model.Product

class Datasource {

    fun loadData(): List<Product>{
        return listOf<Product>(
                Product(R.string.product1,R.drawable.product1,35),
                Product(R.string.product2,R.drawable.product2,30),
                Product(R.string.product3,R.drawable.product3,25),
                Product(R.string.product4,R.drawable.product4,35),
                Product(R.string.product5,R.drawable.product5,25),
                Product(R.string.product6,R.drawable.product6,40),
                Product(R.string.product7,R.drawable.product7,35),
                Product(R.string.product8,R.drawable.product8,35),
                Product(R.string.product9,R.drawable.product9,30),
                Product(R.string.product10,R.drawable.product10,18),
                Product(R.string.product11,R.drawable.product11,50),
                Product(R.string.product12,R.drawable.product12,30),
                Product(R.string.product13,R.drawable.product13,50),
                Product(R.string.product14,R.drawable.product14,5),
                Product(R.string.product15,R.drawable.product15,18),
                Product(R.string.product16,R.drawable.product16,30),
                Product(R.string.product17,R.drawable.product17,20),
                Product(R.string.product18,R.drawable.product18,15),
                Product(R.string.product19,R.drawable.product19,40),
                Product(R.string.product20,R.drawable.product20,25),
        )
    }
}