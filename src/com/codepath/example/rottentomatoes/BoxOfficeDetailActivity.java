package com.codepath.example.rottentomatoes;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BoxOfficeDetailActivity extends Activity {
	private ImageView ivPosterImage;
	private TextView tvTitle;
	private TextView tvSynopsis;
	private TextView tvCast;
	private TextView tvAudienceScore;
	private TextView tvCriticsScore;
	private TextView tvCriticsConsensus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_box_office_detail);
		// Fetch views
		ivPosterImage = findViewById(R.id.ivPosterImage);
		tvTitle = findViewById(R.id.tvTitle);
		tvSynopsis = findViewById(R.id.tvSynopsis);
		tvCast = findViewById(R.id.tvCast);
		tvCriticsConsensus = findViewById(R.id.tvCriticsConsensus);
		tvAudienceScore =  findViewById(R.id.tvAudienceScore);
		tvCriticsScore = findViewById(R.id.tvCriticsScore);
		// Load movie data
		BoxOfficeMovie movie = (BoxOfficeMovie) getIntent().getSerializableExtra(BoxOfficeActivity.MOVIE_DETAIL_KEY);
		loadMovie(movie);
	}
	
	// Populate the data for the movie
	public void loadMovie(BoxOfficeMovie movie) {
		String title = "unknown";
		if(movie.getTitle() != null) {
			title = movie.getTitle();
		}
		getActionBar().setTitle(title);

		// Populate data
		tvTitle.setText(movie.getTitle());
		tvCriticsScore.setText(Html.fromHtml("<b>Critics Score:</b> " + movie.getCriticsScore() + "%"));
		tvAudienceScore.setText(Html.fromHtml("<b>Audience Score:</b> " + movie.getAudienceScore() + "%"));
		tvCast.setText(movie.getCastList());
		tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + movie.getSynopsis()));
		tvCriticsConsensus.setText(Html.fromHtml("<b>Consensus:</b> " + movie.getCriticsConsensus()));
		// R.drawable.large_movie_poster from 
        // http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg -->
		Picasso.with(this).load(movie.getLargePosterUrl()).
		    placeholder(R.drawable.large_movie_poster).
		    into(ivPosterImage);
	}

}
