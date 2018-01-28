package com.sparkforchange.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.UserDonationBlock;

import java.util.List;

/**
 * Adapter for the RecyclerView regarding horizontal cards or movie cards.
 */
public class DonationsRvAdapter extends RecyclerView.Adapter<DonationsRvAdapter.DonationViewHolder> {

    private List<UserDonationBlock> userDonationBlocks;

    public DonationsRvAdapter() {
        this.userDonationBlocks = Facade.getInstance().getCurrentUser().getDonationHistory();
    }

    @Override
    public int getItemCount() {
        return userDonationBlocks.size();
    }

    @Override
    public DonationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.donation_row, viewGroup, false);
        return new DonationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DonationViewHolder donationViewHolder, int i) {
        final UserDonationBlock block = userDonationBlocks.get(userDonationBlocks.size() - i - 1);

        donationViewHolder.charityName.setText(block.getCharity().getName());
        donationViewHolder.dollars.setText("$" + String.format("%.2f", block.getDonationAmount()));
        donationViewHolder.date.setText(block.getDate());
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class DonationViewHolder extends RecyclerView.ViewHolder {
        private TextView dollars;
        private TextView charityName;
        private TextView date;
        private LinearLayout linearLayout;

        DonationViewHolder(View itemView) {
            super(itemView);
            dollars = itemView.findViewById(R.id.tv_donated_amount);
            charityName = itemView.findViewById(R.id.tv_charity_donation);
            date = itemView.findViewById(R.id.tv_date_donation);
            linearLayout = itemView.findViewById(R.id.ll_donation_row);
        }
    }
}