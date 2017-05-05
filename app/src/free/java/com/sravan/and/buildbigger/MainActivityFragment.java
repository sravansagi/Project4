package com.sravan.and.buildbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.sravan.and.jokeviewlib.MainActivityJokeView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.Callback {

    @BindView(R.id.button_joke)
    Button buttonJoke;
    @BindView(R.id.joke_progressbar)
    ProgressBar jokeProgress;
    InterstitialAd mInterstitialAd;
    String joke;
    boolean displayInterstitalAd;
    boolean getJokeTaskComplete;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        joke = "";
        displayInterstitalAd = false;
        getJokeTaskComplete = false;
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,rootView);
        buttonJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
                if (mInterstitialAd.isLoaded()) {
                    displayInterstitalAd = true;
                    mInterstitialAd.show();
                } else {
                    jokeProgress.setVisibility(View.VISIBLE);
                }
            }
        });

        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("6C21B0458E3BA016232450AFD157E6C0")
                .build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                displayInterstitalAd = false;
                requestNewInterstitial();
                if (getJokeTaskComplete){
                    getJokeTaskComplete = false;
                    launchActivity(joke);
                } else {
                    jokeProgress.setVisibility(View.VISIBLE);
                }
            }
        });
        requestNewInterstitial();
        return rootView;
    }

    private void getJoke() {
        //jokeProgress.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute(getActivity());
    }

    @Override
    public void done(String result) {
        jokeProgress.setVisibility(View.GONE);
        if(!displayInterstitalAd){
            launchActivity(result);
        } else{
            getJokeTaskComplete = true;
            joke = result;
        }
    }

    private void launchActivity(String result){
        Intent intent = new Intent(getActivity(), MainActivityJokeView.class);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        startActivity(intent);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("6C21B0458E3BA016232450AFD157E6C0")
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
}
