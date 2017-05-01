package com.sravan.and.buildbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        {
            View root = inflater.inflate(R.layout.fragment_main, container, false);
            Button buttonJoke = (Button) root.findViewById(R.id.button_joke_paid);
            buttonJoke.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Button","The button is clicked");
                    Toast.makeText(getContext(),"This is paid Version", Toast.LENGTH_SHORT).show();
                }
            });
            return root;
        }
    }
}
