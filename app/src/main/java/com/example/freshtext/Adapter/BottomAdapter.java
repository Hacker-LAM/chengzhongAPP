package com.example.freshtext.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshtext.Entity.ShoppingCart;
import com.example.freshtext.R;

import java.util.List;

public class BottomAdapter  extends RecyclerView.Adapter<BottomAdapter.BottomViewHolder> {
    private List<ShoppingCart> list;
    static class BottomViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public BottomViewHolder(View view) {
            super(view);
            textView = (TextView)view.findViewById(R.id.bottom_text);
        }
    }

    public BottomAdapter(List<ShoppingCart> list_2) {
        list = list_2;
    }


    @NonNull
    @Override
    public BottomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottom, parent, false);
        final BottomViewHolder holder = new BottomViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                ShoppingCart str = list.get(position);
                Toast.makeText(v.getContext(), "点击了bottomAdapter" + str.getName(), Toast.LENGTH_LONG).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BottomViewHolder holder, int position) {
        ShoppingCart str = list.get(position);
        holder.textView.setText(str.getName());
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }


}
