/* Assignment: 3
Campus: Ashdod
Authors:
Eliran Naduyev 312089105
Maria Garber
*/

package com.example.Recipeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterSearchResult extends RecyclerView.Adapter<RecyclerViewAdapterSearchResult.MyViewHolder> {

    private Context mContext;
    private List<RecipeMethods> mData;

    public RecyclerViewAdapterSearchResult(Context mContext, List<RecipeMethods> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_search_result, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_recipe_title.setText(mData.get(position).getTitle());
        if (mData.get(position).getThumbnail().isEmpty()) {
            holder.img_recipe_thumbnail.setImageResource(R.drawable.nopicture);
        } else{
            Picasso.get().load(mData.get(position).getThumbnail()).into(holder.img_recipe_thumbnail);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecipeDetails.class);
                intent.putExtra("id", mData.get(position).getId());
                intent.putExtra("title",mData.get(position).getTitle());
                intent.putExtra("img",mData.get(position).getThumbnail());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_recipe_title;
        ImageView img_recipe_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_recipe_title = itemView.findViewById(R.id.search_result_recipe_title);
            img_recipe_thumbnail = itemView.findViewById(R.id.search_result_recipe_img);
            cardView = itemView.findViewById(R.id.search_result_cardview);
        }
    }
}
