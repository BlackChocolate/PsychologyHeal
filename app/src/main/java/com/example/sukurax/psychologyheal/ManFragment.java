package com.example.sukurax.psychologyheal;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;


/**
 * Created by sukurax on 2017/3/8.
 */

public class ManFragment extends Fragment {
    ImageView dingdan,xiaoxi;
    LinearLayout article1,article3,article5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_man, container, false);
        innerView(view);
        getWidgetId(view);
        setClickListener();
        return view;
    }

    private void setClickListener() {
        dingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),MyOrderActivity.class);
                startActivity(intent);
            }
        });
        xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ChatListFragmentActivity.class);
                startActivity(intent);
            }
        });
        article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleActivity.class);
                intent.putExtra("whichlayout", "1");
                startActivity(intent);
            }
        });
        article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleActivity.class);
                intent.putExtra("whichlayout", "3");
                startActivity(intent);
            }
        });
        article5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),ArticleActivity.class);
                intent.putExtra("whichlayout", "5");
                startActivity(intent);
            }
        });
    }

    private void getWidgetId(View view) {
        dingdan=(ImageView)view.findViewById(R.id.dingdan);
        xiaoxi=(ImageView)view.findViewById(R.id.xiaoxi);

        article1=(LinearLayout)view.findViewById(R.id.article1);
        article3=(LinearLayout)view.findViewById(R.id.article3);
        article5=(LinearLayout)view.findViewById(R.id.article5);
    }

    private void innerView(View view) {

    }
}
