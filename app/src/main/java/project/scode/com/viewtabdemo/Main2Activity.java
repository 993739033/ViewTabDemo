package project.scode.com.viewtabdemo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ViewPager pager;
    private MePageAdapter adapter;
    private ArrayList<View> views;
    private View view1;
    private View view2;
    private View view3;
    private MeDynamic dynamic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }


    private void init() {
        views = new ArrayList<>();
        pager = (ViewPager) findViewById(R.id.view_pager);
        dynamic =  (MeDynamic)findViewById(R.id.meDynamic);

        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1, null);
        view2 = inflater.inflate(R.layout.layout2, null);
        view3 = inflater.inflate(R.layout.layout3, null);

        views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);


        adapter = new MePageAdapter(views);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new MeOnPageChange(this,dynamic,pager));
    }
}
