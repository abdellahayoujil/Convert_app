package com.example.convert_app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Convert_f_c extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Convert_f_c() {
        // Required empty public constructor
    }

    public static Convert_f_c newInstance(String param1, String param2) {
        Convert_f_c fragment = new Convert_f_c();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_convert_f_c, container, false);

        EditText etInput = view.findViewById(R.id.et_input);
        RadioButton rbToCelsius = view.findViewById(R.id.rb_to_celsius);
        RadioButton rbToFahrenheit = view.findViewById(R.id.rb_to_fahrenheit);
        Button btnConvert = view.findViewById(R.id.btn_convert);
        TextView tvResult = view.findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();

                if (!input.isEmpty()) {
                    double temperature = Double.parseDouble(input);
                    double result;

                    if (rbToCelsius.isChecked()) {
                        result = (temperature - 32) / 1.8;
                        tvResult.setText("Résultat : " + result + " °C");
                    } else if (rbToFahrenheit.isChecked()) {
                        result = (temperature * 1.8) + 32;
                        tvResult.setText("Résultat : " + result + " °F");
                    } else {
                        tvResult.setText("Veuillez sélectionner une option.");
                    }
                } else {
                    tvResult.setText("Veuillez entrer une température.");
                }
            }
        });

        return view;
    }
}
