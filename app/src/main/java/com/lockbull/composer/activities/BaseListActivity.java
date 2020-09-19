package com.lockbull.composer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lockbull.composer.R;
import com.lockbull.composer.adapter.CustomItemAdapter;
import com.lockbull.composer.item_capsule.Item_intials;
import com.lockbull.composer.set_of_list.BaseElements;
import com.lockbull.composer.set_of_list.CompositeElements;
import com.lockbull.composer.set_of_list.MiscellaneousElements;

import java.util.List;

public class BaseListActivity extends AppCompatActivity {
    private List<Item_intials> initia;
    private int p;

    private RecyclerView iRecyclerView;
    private CustomItemAdapter iAdapter;
    private RecyclerView.LayoutManager iLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baselist);

 /*       BaseElements listcreate = new BaseElements();
        List<Item_intials> initiaList=listcreate.getBaselist();
        iRecyclerView= findViewById(R.id.irecycle);
        iRecyclerView.setHasFixedSize(true);
        iLayoutManager= new LinearLayoutManager(this);
        iAdapter= new CustomItemAdapter(initiaList);
        iRecyclerView.setLayoutManager(iLayoutManager);
        iRecyclerView.setAdapter(iAdapter);*/

    }
    public void baselist(View v)
    {
        List<Item_intials> initiaList=new BaseElements().getBaselist();
        loadlist(initiaList);
        initia=initiaList;
    }

    public void misc(View v)
    {
        List<Item_intials> initiaList=new MiscellaneousElements().getMiscellaneouslist();
        initia=initiaList;
        loadlist(initiaList);
    }

    public void comp(View v)
    {
        List<Item_intials> initiaList=new CompositeElements().getCompositelist();
        loadlist(initiaList);
        initia=initiaList;
    }
    private void loadlist(List<Item_intials> initiaList){
        iRecyclerView= findViewById(R.id.irecycle);
        iRecyclerView.setHasFixedSize(true);
        iLayoutManager= new LinearLayoutManager(this);
        iAdapter= new CustomItemAdapter(initiaList);
        iRecyclerView.setLayoutManager(iLayoutManager);
        iRecyclerView.setAdapter(iAdapter);
        ImageView i=findViewById(R.id.deleteIt);


      iAdapter.setOnItemClickedListener(new CustomItemAdapter.onItemClickListener() {
            @Override
            public void onDeleteClick(int position) {

                initiaList.remove(position);
                iAdapter.notifyItemRemoved(position);
            }

        });
    }



   }
