package com.sravan.and.buildbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.sravan.and.jokelib.Jokes;
import com.sravan.and.jokeviewlib.MainActivityJokeView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.button_joke)
    Button buttonJoke;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,rootView);
        buttonJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jokes jokes = new Jokes();
                Intent intent = new Intent(getContext(), MainActivityJokeView.class);
                intent.putExtra(Intent.EXTRA_TEXT, jokes.getJoke());
                startActivity(intent);
            }
        });

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("6C21B0458E3BA016232450AFD157E6C0")
                .build();
        mAdView.loadAd(adRequest);
        return rootView;
    }
}
