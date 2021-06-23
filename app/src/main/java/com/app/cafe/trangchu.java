package com.app.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.app.cafe.Adapter.AdapterViewPayer;
import com.app.cafe.Model.ModelItem;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class trangchu extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listviewmanhinhchinh;
    DrawerLayout drawerLayout;
    private AdapterViewPayer adapter;
    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        Anhxa();
        ActionBar();

        adapter = new AdapterViewPayer(getApplicationContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        renewItems(sliderView);
        removeLastItem(sliderView);
        addNewItem(sliderView);

        //ActionViewFlipper();
    }

//    private void ActionViewFlipper() {
//        ArrayList<String> mangquangcao = new ArrayList<>();
//        mangquangcao.add("https://xuongmocgocongnghiep.com/upload/images/thiet-ke-quan-cafe-dep-02.jpg");
//        mangquangcao.add("https://cdn.vietnamtours247.com/2019/12/1EE5448A-1DBC-4F9A-B322-5653427E5403-1920x1920.jpeg");
//        mangquangcao.add("https://tuarts.net/wp-content/uploads/2019/10/79203743_732156290524449_492674440098742272_o-800x600.jpg");
//        mangquangcao.add("https://dulich9.com/wp-content/uploads/2020/07/Quan-cafe-noi-tieng-o-Nha-Trang-4.jpg");
//        for (int i=0;i<mangquangcao.size();i++){
//            ImageView imageView = new ImageView(getApplicationContext());
//            Picasso.get().load(mangquangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
//    }
    /*----------- Tạo ảnh SliderLoad -----------*/

    public void renewItems(SliderView sliderView) {
        List<ModelItem> sliderItemList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ModelItem sliderItem = new ModelItem();
            switch (i) {
                case 0:
                    sliderItem.setImageurl("https://xuongmocgocongnghiep.com/upload/images/thiet-ke-quan-cafe-dep-02.jpg");
                    break;
                case 1:
                    sliderItem.setImageurl("https://cdn.vietnamtours247.com/2019/12/1EE5448A-1DBC-4F9A-B322-5653427E5403-1920x1920.jpeg");
                    break;
                case 2:
                    sliderItem.setImageurl("https://tuarts.net/wp-content/uploads/2019/10/79203743_732156290524449_492674440098742272_o-800x600.jpg");
                    break;
                case 3:
                    sliderItem.setImageurl("https://dulich9.com/wp-content/uploads/2020/07/Quan-cafe-noi-tieng-o-Nha-Trang-4.jpg");
                    break;

            }
            sliderItemList.add(sliderItem);
        }
        adapter.ViewPagerAdapter(sliderItemList);
    }


    public void removeLastItem(SliderView sliderView) {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteitem(adapter.getCount() - 1);
    }

    public void addNewItem(SliderView sliderView) {
        ModelItem sliderItem = new ModelItem();
        sliderItem.setImageurl("https://1.bp.blogspot.com/-W445RQ2YtbU/YKOI0sIDkzI/AAAAAAAAACA/7r2uGRJFKzkbNjG7i6mZbKaJTLzpNhKwQCNcBGAsYHQ/s970/giamgia.png");
        adapter.addItem(sliderItem);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /*----------- End tạo ảnh SliderLoad -----------*/

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listviewmanhinhchinh = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
    }
}