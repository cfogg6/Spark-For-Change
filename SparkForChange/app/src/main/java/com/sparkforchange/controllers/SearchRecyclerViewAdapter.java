package com.sparkforchange.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Loginable;

import java.util.List;
import java.util.function.Function;

/**
 * Adapter for the RecyclerView regarding horizontal cards or movie cards.
 */
public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.GroupViewHolder> {

    /**
     * List of charities
     */
    private List<Loginable> loginables;

    /**
     * Constructor for the adapter that sets the charities list to argument.
     */
    public SearchRecyclerViewAdapter() {
        this.loginables = Facade.getInstance().getLoginables();
    }

    @Override
    public int getItemCount() {
        return loginables.size();
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.choose_charity_row, viewGroup, false);
        return new GroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GroupViewHolder groupViewHolder, int i) {
        final Loginable loginable = loginables.get(groupViewHolder.getAdapterPosition());

        groupViewHolder.name.setText(loginable.getName());

        groupViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent it;
                if (loginable instanceof Charity) {
                    it = new Intent(v.getContext(), CharityActivity.class);
                    it.putExtra("charityIndex", groupViewHolder.getAdapterPosition());
                } else {
                    //TODO: Make company activity
                    it = new Intent(v.getContext(), CharityActivity.class);
                    it.putExtra("charityIndex", groupViewHolder.getAdapterPosition());
                }
                v.getContext().startActivity(it);
            }
        });
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        /**
         * Name
         */
        private TextView name;

        /**
         * Layout to make clickable
         */
        private LinearLayout linearLayout;


        /**
         * View
         * @param itemView view
         */
        GroupViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_groupname);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.ll_group_layout);
        }
    }
}