package com.fyp.appmaker.Functionality;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;

import com.fyp.appmaker.Authenticaiton.LoginActivity;
import com.fyp.appmaker.R;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;

import com.fyp.appmaker.UserAccount.AccountActivity;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UserMainScreen extends UtilitiesClass
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView domainsListView;
    private ArrayList<String> domains;
    ObjectAnimator objectAnimator;
    public UserMainScreen() {
    }

    public UserMainScreen(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        domains=new ArrayList<>();
        domains.add("Online Store");
        domains.add("Business");
        domains.add("Blog");
        domains.add("Restaurants");
        domains.add("Events");
        domains.add(" ");

        domainsListView =findViewById(R.id.domainsListView);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,domains);
        domainsListView.setAdapter(adapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        objectAnimator = ObjectAnimator.ofFloat(domainsListView,"translationY",0f,50f);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
        domainsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (domains.get(i).equals("Online Store")) {
                    Intent intent = new Intent(UserMainScreen.this, ChooseTemplate.class);
                    intent.putExtra("domain", domains.get(i));
                    startActivity(intent);
                }else{
                    Toast.makeText(UserMainScreen.this, "Templates not available now", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_main_screen, menu);
        menu.add("New").setIcon(R.drawable.ic_arrow_back_black_24dp);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.yourAccount) {
            // Handle the camera action
            startActivity(new Intent(this, AccountActivity.class));

        } else if (id == R.id.logout) {
            deleteFromPrefs(this);
            startActivity(new Intent(UserMainScreen.this, LoginActivity.class));
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
