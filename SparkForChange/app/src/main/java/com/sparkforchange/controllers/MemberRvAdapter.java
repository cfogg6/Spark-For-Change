package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Group;
import com.sparkforchange.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coleb_000 on 1/28/2018.
 */

public class MemberRvAdapter extends RecyclerView.Adapter<MemberRvAdapter.MemberRvHolder> {

    private List<User> members;

    /**
     * Constructor for the adapter that sets the Group list to argument.
     */
    public MemberRvAdapter(String groupName) {
        Group group = Facade.getInstance().getGroupsAsMap().get(groupName);
        this.members = new ArrayList<>(group.getMembers());
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public MemberRvAdapter.MemberRvHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_row, viewGroup, false);
        return new MemberRvAdapter.MemberRvHolder(v);
    }

    @Override
    public void onBindViewHolder(final MemberRvAdapter.MemberRvHolder memberRvHolder, int i) {
        final User user = members.get(memberRvHolder.getAdapterPosition());
        memberRvHolder.name.setText(user.getName());
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class MemberRvHolder extends RecyclerView.ViewHolder {
        private TextView name;

        MemberRvHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_user_group);

        }
    }
}

