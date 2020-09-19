package com.lockbull.composer.set_of_list;

import androidx.appcompat.app.AppCompatActivity;

import com.lockbull.composer.item_capsule.Item_intials;

import java.util.ArrayList;
import java.util.List;
public class BaseElements extends AppCompatActivity {
private  List<Item_intials> baselist;
private List<Item_intials> initiaList=new ArrayList<>();

    public BaseElements() {
        generateBaseList();

    }

    public List<Item_intials> getBaselist() {

        baselist=initiaList;
        return initiaList;
    }

    public void generateBaseList(){
        initiaList.add(new Item_intials("BaseElement1",200,"/K.G."));
        initiaList.add(new Item_intials("Element2",100,"/K.G."));
        initiaList.add(new Item_intials("Element3",600,"/K.G."));
        initiaList.add(new Item_intials("Element4",500,"/K.G."));
        initiaList.add(new Item_intials("Element5",800,"/K.G."));
        initiaList.add(new Item_intials("Element6",900,"/K.G."));
        initiaList.add(new Item_intials("Element7",5000,"/K.G."));
        initiaList.add(new Item_intials("Element9",2,"/K.G."));
        initiaList.add(new Item_intials("Element10",2000,"/K.G."));
        initiaList.add(new Item_intials("Element1",200,"/K.G."));
        initiaList.add(new Item_intials("Element2",100,"/K.G."));
        initiaList.add(new Item_intials("Element3",600,"/K.G."));
        initiaList.add(new Item_intials("Element4",500,"/K.G."));
        initiaList.add(new Item_intials("Element5",800,"/K.G."));
        initiaList.add(new Item_intials("Element6",900,"/K.G."));
        initiaList.add(new Item_intials("Element7",5000,"/K.G."));
        initiaList.add(new Item_intials("Element9",2,"/K.G."));
        initiaList.add(new Item_intials("Element10",2000,"/K.G."));

    }






}
