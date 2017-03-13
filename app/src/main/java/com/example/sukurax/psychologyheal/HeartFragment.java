package com.example.sukurax.psychologyheal;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by sukurax on 2017/2/12.
 */

public class HeartFragment extends Fragment {
    LinearLayout doctor1,doctor2,doctor3,doctor4,doctor5,doctor6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_heart, container, false);
        innerView(view);
        return view;
    }

    private void innerView(View view) {
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.optional_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        doctor1=(LinearLayout) view.findViewById(R.id.doctor1);
        doctor2=(LinearLayout) view.findViewById(R.id.doctor2);
        doctor3=(LinearLayout) view.findViewById(R.id.doctor3);
        doctor4=(LinearLayout) view.findViewById(R.id.doctor4);
        doctor5=(LinearLayout) view.findViewById(R.id.doctor5);
        doctor6=(LinearLayout) view.findViewById(R.id.doctor6);

        doctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "1");
                startActivity(intent);
            }
        });
        doctor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "2");
                startActivity(intent);
            }
        });
        doctor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "3");
                startActivity(intent);
            }
        });
        doctor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "1");
                startActivity(intent);
            }
        });
        doctor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "2");
                startActivity(intent);
            }
        });
        doctor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),DoctorIfoActivity.class);
                intent.putExtra("whichdoctor", "3");
                startActivity(intent);
            }
        });

    }
}
