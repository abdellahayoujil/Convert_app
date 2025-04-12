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

public class Convert_cm_m extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Convert_cm_m() {
    }

    public static Convert_cm_m newInstance(String param1, String param2) {
        Convert_cm_m fragment = new Convert_cm_m();
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
        View view = inflater.inflate(R.layout.fragment_convert_cm_m, container, false);

        EditText etInput = view.findViewById(R.id.et_input);
        RadioButton rbToMeters = view.findViewById(R.id.rb_to_meters);
        RadioButton rbToCentimeters = view.findViewById(R.id.rb_to_centimeters);
        Button btnConvert = view.findViewById(R.id.btn_convert);
        TextView tvResult = view.findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();

                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    double result;

                    if (rbToMeters.isChecked()) {
                        result = value / 100;
                        tvResult.setText("Résultat : " + result + " m");
                    } else if (rbToCentimeters.isChecked()) {
                        result = value * 100;
                        tvResult.setText("Résultat : " + result + " cm");
                    } else {
                        tvResult.setText("Veuillez sélectionner une option.");
                    }
                } else {
                    tvResult.setText("Veuillez entrer une valeur.");
                }
            }
        });

        return view;
    }
}
