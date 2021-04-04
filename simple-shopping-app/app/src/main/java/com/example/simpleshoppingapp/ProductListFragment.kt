package com.example.simpleshoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleshoppingapp.adpter.ItemAdapter
import com.example.simpleshoppingapp.data.Datasource
import com.example.simpleshoppingapp.util.SpacingItemDecorator

class ProductListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.clipToOutline=true

        val myDataset = Datasource().loadData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rcView)
        recyclerView.addItemDecoration(SpacingItemDecorator(12))
        val gridLayout = GridLayoutManager(context,  2)
        recyclerView.layoutManager = gridLayout
        recyclerView.adapter = ItemAdapter(view.context,myDataset)

        recyclerView.setHasFixedSize(true)

    }
}