package com.lockbull.composer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lockbull.composer.R;
import com.lockbull.composer.item_capsule.Item_intials;

import java.util.List;

public class CustomItemAdapter extends RecyclerView.Adapter<CustomItemAdapter.MyViewHolder> {

    private List<Item_intials> iitemList;
    private onItemClickListener itListener;
    public CustomItemAdapter( List<Item_intials> list){
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
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(view, itListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item_intials ii= iitemList.get(position);
        holder.t1.setText(ii.getiText());
        holder.t2.setText(String.valueOf(ii.getiPrice()));
        holder.t3.setText(ii.getiUnit());

    }

    @Override
    public int getItemCount() {
        return iitemList.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public ImageView i1;

        public MyViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);
            t1=itemView.findViewById(R.id.item_name);
            t2=itemView.findViewById(R.id.item_price);
            t3=itemView.findViewById(R.id.item_unit);
            i1=itemView.findViewById(R.id.deleteIt);

            i1.setOnClickListener((v)->{
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