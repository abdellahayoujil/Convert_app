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

public class Convert_kmh_ms extends Fragment {

    public Convert_kmh_ms() {}

    public static Convert_kmh_ms newInstance() {
        return new Convert_kmh_ms();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert_kmh_ms, container, false);

        EditText etInput = view.findViewById(R.id.et_input);
        RadioButton rbToMs = view.findViewById(R.id.rb_to_ms);
        RadioButton rbToKmh = view.findViewById(R.id.rb_to_kmh);
        Button btnConvert = view.findViewById(R.id.btn_convert);
        TextView tvResult = view.findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();

                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    double result;

                    if (rbToMs.isChecked()) {
                        result = value / 3.6;
                        tvResult.setText("Résultat : " + result + " m/s");
                    } else if (rbToKmh.isChecked()) {
                        result = value * 3.6;
                        tvResult.setText("Résultat : " + result + " km/h");
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
