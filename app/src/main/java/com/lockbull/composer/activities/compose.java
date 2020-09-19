package com.lockbull.composer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lockbull.composer.R;
import com.lockbull.composer.adapter.ComprecycAdapter;
import com.lockbull.composer.item_capsule.Compose_Item_intials;
import com.lockbull.composer.item_capsule.Item_intials;
import com.lockbull.composer.set_of_list.BaseElements;
import com.lockbull.composer.set_of_list.CompositeElements;
import com.lockbull.composer.set_of_list.MiscellaneousElements;

import java.util.ArrayList;
import java.util.List;

public class compose extends AppCompatActivity {
    private Spinner sp1,sp2;
    private String qty,q;
    private  int tquant=0;
    private  float tcost=0.0f,pr=0.0f,mpr=0.0f;
    private EditText editedQty;
    private TextView tv,tq,tc;
    private ArrayList<String> arraylist_one;
    private List < Item_intials > list_base,arraylist_composites,arraylist_miscellaneous;
    //private List<Item_intials> ;
    //private List<Item_intials> ;
    private ArrayList<Compose_Item_intials> ii=new ArrayList<Compose_Item_intials>();
    private ArrayAdapter<String> arrayAdapter_one;
    private ArrayAdapter<Item_intials> arrayAdapter_two;
    //recyceler
    private RecyclerView iRecyclerView;
    private ComprecycAdapter iAdapter;
    private RecyclerView.LayoutManager iLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        sp1= findViewById(R.id.spinner1);
        sp2= findViewById(R.id.spinner2);
        editedQty= findViewById(R.id.qty);
        tq= findViewById(R.id.totalquantity);
        tc=findViewById(R.id.totalcost);



        //first spinner task
        arraylist_one=new ArrayList<>();
        arraylist_one.add("Base");
        arraylist_one.add("Composite");
        arraylist_one.add("Miscellaneous");

        arrayAdapter_one=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arraylist_one);
        sp1.setAdapter(arrayAdapter_one);

        //second spinner task
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    valid(0);
                    //sp2.setAdapter((SpinnerAdapter) arrayAdapter_two);
                }
                if(position==1){
                    valid(1);
                    //arrayAdapter_two=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arraylist_base);
                }
                if(position==2)
                {
                    valid(2);

                    //arrayAdapter_two=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arraylist_composites);
                }

                sp2.setAdapter((SpinnerAdapter) arrayAdapter_two);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(compose.this,"yaha seSelect elements",Toast.LENGTH_SHORT).show();

            }


        });



    }
    private void valid(int t) {
        if (t ==0){
        list_base = new BaseElements().getBaselist();
        arrayAdapter_two = new ArrayAdapter<Item_intials>(this, android.R.layout.simple_spinner_dropdown_item, list_base);}

        if (t ==1) {// arraylist_composites=new ArrayList<>();
            arraylist_composites = new CompositeElements().getCompositelist();
            arrayAdapter_two = new ArrayAdapter<Item_intials>(this, android.R.layout.simple_spinner_dropdown_item, arraylist_composites);
        }
        if (t ==2) {
            arraylist_miscellaneous = new MiscellaneousElements().getMiscellaneouslist();
            arrayAdapter_two = new ArrayAdapter<Item_intials>(this, android.R.layout.simple_spinner_dropdown_item, arraylist_miscellaneous);
        arrayAdapter_two.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
    }
    //task on button clicked.
    public void add(View v){
        String s1 = sp1.getSelectedItem().toString();
        Item_intials item = (Item_intials) sp2.getSelectedItem();
        qty=editedQty.getText().toString();
        String name =item.getiText();
        int price = (item.getiPrice());
        String unit =(item.getiUnit());
        int calc = Integer.valueOf(qty);
        pr=(float)(calc*0.001*price);
        if((tquant+calc)>1000)
        {
          Toast.makeText(this,"1000grams limit reached",Toast.LENGTH_SHORT).show();
        }
        else {


            tquant=tquant+Integer.valueOf(qty);
            tcost=(float)tcost+pr;
            ii.add(new Compose_Item_intials(name,price,unit,qty,pr));
            ldlist(ii);
            setToTotal();
        }
    }

    private void ldlist(ArrayList initiaList){
        iRecyclerView= findViewById(R.id.rerecycle);
        iRecyclerView.setHasFixedSize(true);
        iLayoutManager= new LinearLayoutManager(this);
        iAdapter= new ComprecycAdapter(initiaList);
        iRecyclerView.setLayoutManager(iLayoutManager);
        iRecyclerView.setAdapter(iAdapter);

        iAdapter.setOnItemClickedListener(new ComprecycAdapter.onItemClickListener() {
            @Override
            public void onDeleteClick(int position) throws Exception {
                q=ii.get(position).getIqty();
                mpr=ii.get(position).getEfprice();
                tquant=tquant-(Integer.valueOf(q));
                tcost=(float) tcost-(float) mpr;
                setToTotal();
                initiaList.remove(position);
                iAdapter.notifyItemRemoved(position);



            }
        });
    }
    private void setToTotal(){

        tq.setText(String.valueOf(tquant));
        tc.setText(String.valueOf(tcost));

        //s2= String.valueOf(tcost)+" "+String.valueOf(tquant);

    }

    public void saveit(View view) {
        if(tquant!=1000){
            Toast.makeText(this,"Total quantity should be 1000g",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Valid",Toast.LENGTH_SHORT).show();
        }

    }
}
