package com.example.sukurax.psychologyheal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by sukurax on 2017/1/30.
 */

public class HomeFragment extends Fragment {

    ImageView column,article,test;
    LinearLayout article1,article2,article3,article4,article5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_home,container,false);
        initBanner(view);
        getWidgetId(view);
        setClickListener();

        return view;
    }

    private void setClickListener() {
        column.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ColumnActivity.class);
                startActivity(intent);
            }
        });
        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleActivity.class);
                startActivity(intent);
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),TestActivity.class);
                startActivity(intent);
            }
        });

        article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "1");
                startActivity(intent);
            }
        });
        article2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "2");
                startActivity(intent);
            }
        });
        article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "3");
                startActivity(intent);
            }
        });
        article4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "4");
                startActivity(intent);
            }
        });
        article5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),ArticleContentActivity.class);
                intent.putExtra("whichlayout", "5");
                startActivity(intent);
            }
        });
    }

    private void getWidgetId(View view) {
        column=(ImageView)view.findViewById(R.id.column);
        article=(ImageView)view.findViewById(R.id.article);
        test=(ImageView)view.findViewById(R.id.test);

        article1=(LinearLayout)view.findViewById(R.id.article1);
        article2=(LinearLayout)view.findViewById(R.id.article2);
        article3=(LinearLayout)view.findViewById(R.id.article3);
        article4=(LinearLayout)view.findViewById(R.id.article4);
        article5=(LinearLayout)view.findViewById(R.id.article5);
    }

    private void initBanner(View view) {
        //初始化需要轮播展示的数据，bannerImgList中存储的是图片int型的id
        int[] bannerImag = { R.drawable.rollviewpic1, R.drawable.rollviewpic2, R.drawable.rollviewpic3};
        List bannerImgList = new ArrayList();
        for (int aBannerImag : bannerImag) {
            bannerImgList.add(aBannerImag);
        }

        ConvenientBanner banner= (ConvenientBanner) view.findViewById(R.id.convenientBanner);

        banner.setPages(new CBViewHolderCreator() {//加载ImageView控件显示图片
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        },bannerImgList)//bannerImgList,必须存储的是int型的图片id,否则出现ClassCastException

                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设,第一个是指示器初始化状态，第二个是获得焦点后的
                .setPageIndicator(new int[]{R.drawable.whitepoint, R.drawable.redpoint})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL) //设置指示器的方向(左中右)
                .setPointViewVisible(true)    //设置指示器是否可见
                .startTurning(6000);     //设置自动切换（同时设置了切换时间间隔）
        //.stopTurning();    //关闭自动切换
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer); //集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
        // banner.setManualPageable(false);//设置不能手动影响，即无法手势滑动
    }

    private class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }


}
