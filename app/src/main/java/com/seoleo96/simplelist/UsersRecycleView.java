package com.seoleo96.simplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecycleView extends RecyclerView.Adapter<UsersRecycleView.ViewHolder>{
    ArrayList<Users> usersArrayList;
    Context mContext;

    public UsersRecycleView(Context context, ArrayList<Users> users){
        usersArrayList = users;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_users, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.username.setText(usersArrayList.get(position).getUsername());
        Glide.with(mContext).asBitmap().load(usersArrayList.get(position).getUrlImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         public ViewHolder(View itemView) {
             super(itemView);
         }
         TextView username = itemView.findViewById(R.id.username);
         CircleImageView imageView = itemView.findViewById(R.id.imageId);
     }
}
