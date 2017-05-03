package com.sravan.and.buildbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sravan.and.jokelib.Jokes;
import com.sravan.and.jokeviewlib.MainActivityJokeView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityFragment extends Fragment {

    @BindView(R.id.button_joke)
    Button buttonJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.bind(this,rootView);
            buttonJoke.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new EndpointsAsyncTask().execute(getActivity());
                }
            });
            return rootView;
        }
    }
}
