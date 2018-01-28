package com.sparkforchange.controllers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Adapter for the RecyclerView regarding horizontal cards or movie cards.
 */
public class CharityListviewAdapter extends RecyclerView.Adapter<CharityListviewAdapter.CharityViewHolder> {

    /**
     * List of charities
     */
    private List<Charity> charities;

    /**
     * Constructor for the adapter that sets the charities list to argument.
     * @param m List of charities to set the cards to
     */
    public CharityListviewAdapter(List<Charity> m) {
        this.charities = m;
    }

    @Override
    public int getItemCount() {
        return  charities.size();
    }

    /**
     * Method to update the movie list for the adapter with a new set of charities.
     *
     * @param list New list to update the movie list to
     */
    public void updateMovies(List<Charity> list) {
        charities = list;
    }

    @Override
    public CharityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.charity_row, viewGroup, false);
        return new CharityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CharityViewHolder charityViewHolder, int i) {
        final Charity mov = charities.get(i);
//
//        charityViewHolder.movieName.setText(mov.getName());
//        charityViewHolder.releaseDate.setText(mov.getDate());
//        charityViewHolder.details.setText(mov.getRatingRuntime());
//        charityViewHolder.starBar.setRating((float) mov.getRating().getAverageRating());
//
//        new DownloadImageTask(charityViewHolder.movPhoto).execute(mov.getPhotoID());
//
//        charityViewHolder.cvLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Intent it = new Intent(v.getContext(), MovieInfoActivity.class);
//                it.putExtra("SALTY_POPCORN_CURRENT_MOVIE", mov);
//                v.getContext().startActivity(it);
//            }
//        });
    }

    /**
     * ViewHolder Class following the ViewHolder Android Pattern. Establishes views held inside
     * the movie cards that this adapter sets.
     */
    public static class CharityViewHolder extends RecyclerView.ViewHolder {
        /**
         * Charity title
         */
        private TextView charityTitle;
        /**
         * Movie photo
         */
        private ImageView charityPhoto;

        /**
         * View
         * @param itemView view
         */
        CharityViewHolder(View itemView) {
            super(itemView);
//            cv = (CardView) itemView.findViewById(R.id.movCardView);
            charityTitle = (TextView) itemView.findViewById(R.id.tv_choose_charity_row_charity);
//            releaseDate = (TextView) itemView.findViewById(R.id.release_date);
//            details = (TextView) itemView.findViewById(R.id.movie_details);
            charityPhoto = (ImageView) itemView.findViewById(R.id.im_choose_charity_photo);
//            cvLayout = (RelativeLayout) itemView.findViewById(R.id.cv_layout);
//            starBar = (RatingBar) itemView.findViewById(R.id.mov_rating);
        }
    }
}