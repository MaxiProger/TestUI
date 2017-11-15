package com.example.max.testui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.max.testui.R;
import com.example.max.testui.networking.dto.Api;
import com.example.max.testui.networking.dto.translateDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    private String BASE_URL = "https://translate.yandex.net";
    private TextView textView;
    private Button button;
    private Spinner spinner;
    private EditText editText;


    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        editText = (EditText) view.findViewById(R.id.editText);
        button = (Button) view.findViewById(R.id.button);
        spinner = (Spinner) view.findViewById(R.id.language);


        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://translate.yandex.net").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        final Api api = retrofit.create(Api.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lang = String.valueOf(spinner.getSelectedItem()).toLowerCase();
                List<String> input = new ArrayList<String>();
                input.add(editText.getText().toString());

                api.getTranslate(input, lang).enqueue(new Callback<translateDTO>() {

                    @Override
                    public void onResponse(Call<translateDTO> call, Response<translateDTO> response) {

                        textView.setText(response.body().getText().toString());

                    }

                    @Override
                    public void onFailure(Call<translateDTO> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
            }

        });

        return view;
    }

}
