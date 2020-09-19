package com.lockbull.composer.set_of_list;

import com.lockbull.composer.item_capsule.Item_intials;

import java.util.ArrayList;
import java.util.List;

public class CompositeElements {
    List<Item_intials> Compositelist;
    public CompositeElements() {

    }

    public List<Item_intials> getCompositelist() {
        List<Item_intials> initiaList=new ArrayList<>();
        initiaList.add(new Item_intials("CompositeElement1",200,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement2",100,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement3",600,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement4",500,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement5",800,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement6",900,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement7",5000,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement9",2,"/K.G."));
        initiaList.add(new Item_intials("CompositeElement10",2000,"/K.G."));
        initiaList.add(new Item_intials("Element1",200,"/K.G."));
        initiaList.add(new Item_intials("Element2",100,"/K.G."));
        initiaList.add(new Item_intials("Element3",600,"/K.G."));
        initiaList.add(new Item_intials("Element4",500,"/K.G."));
        initiaList.add(new Item_intials("Element5",800,"/K.G."));
        initiaList.add(new Item_intials("Element6",900,"/K.G."));
        initiaList.add(new Item_intials("Element7",5000,"/K.G."));
        initiaList.add(new Item_intials("Element9",2,"/K.G."));
        initiaList.add(new Item_intials("Element10",2000,"/K.G."));
        return initiaList;
    }

    public void setCompositelist(List<Item_intials> compositelist) {
        Compositelist = compositelist;
    }
}
