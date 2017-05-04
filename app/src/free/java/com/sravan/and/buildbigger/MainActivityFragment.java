package com.sravan.and.buildbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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
                getJoke();
            }
        });

        return rootView;
    }

    private void getJoke() {
        jokeProgress.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute(getActivity());
    }

    @Override
    public void done(String result) {
        jokeProgress.setVisibility(View.GONE);
        Intent intent = new Intent(getActivity(), MainActivityJokeView.class);
        intent.putExtra(Intent.EXTRA_TEXT, result );
        startActivity(intent);
    }
}
