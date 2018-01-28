package com.sparkforchange.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.SparkDonation;

import java.util.List;

/**
 * Adapter for the RecyclerView regarding horizontal cards or movie cards.
 */
public class SparkContributionRvAdapter extends RecyclerView.Adapter<SparkContributionRvAdapter.SparkViewHolder> {

    /**
     * List of spark contributions
     */
    private List<SparkDonation> sparkDonations;

    /**
     * Constructor for the adapter that sets the sparkDonations list to argument.
     */
    public SparkContributionRvAdapter() {
        this.sparkDonations = Facade.getInstance().getCurrentUser().getSparkTransactions();
    }

    @Override
    public int getItemCount() {
        return sparkDonations.size();
    }

    @Override
    public SparkViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sparks_row, viewGroup, false);
        return new SparkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SparkViewHolder sparkViewHolder, int i) {
        final SparkDonation donation = sparkDonations.get(i);

        sparkViewHolder.charityName.setText(donation.getCharity().getName());
        sparkViewHolder.companyName.setText(donation.getCompany().getName());
        sparkViewHolder.sparksNum.setText(String.valueOf(donation.getSparkNum()));
        sparkViewHolder.date.setText(donation.getDate());
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class SparkViewHolder extends RecyclerView.ViewHolder {
        private TextView sparksNum;
        private TextView charityName;
        private TextView companyName;
        private TextView date;
        private LinearLayout linearLayout;

        SparkViewHolder(View itemView) {
            super(itemView);
            sparksNum = itemView.findViewById(R.id.tv_sparks_used_sparkDonations);
            charityName = itemView.findViewById(R.id.tv_charity_sparkDonations);
            companyName = itemView.findViewById(R.id.tv_company_sparkDonations);
            date = itemView.findViewById(R.id.tv_date_sparkDonations);
            linearLayout = itemView.findViewById(R.id.ll_sparks_row);
        }
    }
}