package com.lockbull.composer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lockbull.composer.R;
import com.lockbull.composer.item_capsule.Compose_Item_intials;
import com.lockbull.composer.item_capsule.Item_intials;

import java.util.List;

public class ComprecycAdapter extends RecyclerView.Adapter<ComprecycAdapter.MyViewHolder> {

    private List<Compose_Item_intials> iitemList;
    private onItemClickListener itListener;
    public String qti;
    public ComprecycAdapter(List<Compose_Item_intials> list){
        this.iitemList=list;
    }

    public interface onItemClickListener
    {
        void onDeleteClick(int position) throws Exception;
    }
    public void setOnItemClickedListener(onItemClickListener listener){

        itListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.comprecyc_item_view,parent,false);
        return new MyViewHolder(view, itListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Compose_Item_intials ii= iitemList.get(position);
        holder.t1.setText(ii.getiText());
        holder.t2.setText(String.valueOf(ii.getiPrice()));
        holder.t3.setText(ii.getiUnit());
        holder.t4.setText(ii.getIqty());
        holder.t5.setText(String.valueOf( ii.getEfprice()));
        qti=(ii.getiUnit());

    }

    @Override
    public int getItemCount() {
        return iitemList.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5;
        ImageView i2;

        public MyViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            t1=itemView.findViewById(R.id.item_name);
            t2=itemView.findViewById(R.id.item_price);
            t3=itemView.findViewById(R.id.item_unit);
            t4=itemView.findViewById(R.id.qty);
            t5=itemView.findViewById(R.id.efprice);
            i2=itemView.findViewById(R.id.deleteItt);

            i2.setOnClickListener((v)->{
                if(listener!=null){
                    int position = getAdapterPosition();
                    if(position !=RecyclerView.NO_POSITION){
                        try {
                            listener.onDeleteClick(position);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

            });
        }
    }

}