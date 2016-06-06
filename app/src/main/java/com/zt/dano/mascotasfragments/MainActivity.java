package com.zt.dano.mascotasfragments;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.actionBar);
        tablayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUptViewPager();


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotas());

        return fragments;
    }

    private void setUptViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablayout.setupWithViewPager(viewPager);
        tablayout.getTabAt(0).setIcon(R.drawable.ic_action_home);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_action_name);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopcion, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAcerca:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.mContacto:
                Intent inten = new Intent(this, ContactoActivity.class);
                startActivity(inten);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
