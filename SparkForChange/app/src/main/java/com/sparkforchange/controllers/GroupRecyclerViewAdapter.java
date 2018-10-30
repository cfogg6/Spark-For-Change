package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Group;
import com.sparkforchange.model.SparkDonation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.GroupViewHolder> {

    /**
     * list of groups
     */
    private List<Group> groups;

    /**
     * Constructor for the adapter that sets the Group list to argument.
     */
    public GroupRecyclerViewAdapter() {
        this.groups = Facade.getInstance().getCurrentUser().getGroups();
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    @Override
    public GroupRecyclerViewAdapter.GroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_row, viewGroup, false);
        return new GroupRecyclerViewAdapter.GroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final GroupRecyclerViewAdapter.GroupViewHolder groupViewHolder, int i) {
        final Group group = groups.get(groupViewHolder.getAdapterPosition());

        groupViewHolder.groupName.setText(group.getName());

        groupViewHolder.key = group.getName();

        groupViewHolder.groupName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent it = new Intent(v.getContext(), GroupActivity.class);
                it.putExtra("groupKey", groupViewHolder.key);
                v.getContext().startActivity(it);
            }
        });

    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern.
     */
    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        private TextView groupName;

        private String key;

        GroupViewHolder(View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.et_group_row);
        }
    }
}
