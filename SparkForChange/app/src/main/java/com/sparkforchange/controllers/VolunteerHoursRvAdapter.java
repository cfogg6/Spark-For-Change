package com.sparkforchange.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.VolunteerHourBlock;

import java.util.List;

/**
 * Adapter for the RecyclerView regarding horizontal cards or movie cards.
 */
public class VolunteerHoursRvAdapter extends RecyclerView.Adapter<VolunteerHoursRvAdapter.HourViewHolder> {

    private List<VolunteerHourBlock> volunteerHourBlocks;

    /**
     * Constructor for the adapter that sets the sparkDonations list to argument.
     */
    public VolunteerHoursRvAdapter() {
        this.volunteerHourBlocks = Facade.getInstance().getCurrentUser().getHourHistory();
    }

    @Override
    public int getItemCount() {
        return volunteerHourBlocks.size();
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.volunteerhours_row, viewGroup, false);
        return new HourViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HourViewHolder hourViewHolder, int i) {
        final VolunteerHourBlock block = volunteerHourBlocks.get(volunteerHourBlocks.size() - i - 1);

        hourViewHolder.charityName.setText(block.getCharity().getName());
        hourViewHolder.hours.setText(String.valueOf(block.getHours()));
        hourViewHolder.date.setText(block.getDate());
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class HourViewHolder extends RecyclerView.ViewHolder {
        private TextView hours;
        private TextView charityName;
        private TextView date;
        private LinearLayout linearLayout;

        HourViewHolder(View itemView) {
            super(itemView);
            hours = itemView.findViewById(R.id.tv_num_hours);
            charityName = itemView.findViewById(R.id.tv_charity_hours);
            date = itemView.findViewById(R.id.tv_date_hours);
            linearLayout = itemView.findViewById(R.id.ll_hours_row);
        }
    }
}