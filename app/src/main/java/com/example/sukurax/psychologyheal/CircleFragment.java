package com.example.sukurax.psychologyheal;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by sukurax on 2017/3/9.
 */

public class CircleFragment extends Fragment {
    private LinearLayout article3,article4,article5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_circle, container, false);
        innerArticleActivity();
        getWidgetId(view);
        setClickListener();
        return view;
    }


    private void setClickListener() {
        article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "3");
                startActivity(intent);
            }
        });
        article4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "4");
                startActivity(intent);
            }
        });
        article5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "5");
                startActivity(intent);
            }
        });
    }

    private void getWidgetId(View view) {
        article3=(LinearLayout)view.findViewById(R.id.article3);
        article4=(LinearLayout)view.findViewById(R.id.article4);
        article5=(LinearLayout)view.findViewById(R.id.article5);
    }

    private void innerArticleActivity() {


    }
}
