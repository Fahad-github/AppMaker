package com.fyp.appmaker.Functionality;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.widget.LinearLayout;
import android.widget.TextView;


import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.fyp.appmaker.FragmentTemplate2.Template2Fragment;
import com.fyp.appmaker.R;
import com.fyp.appmaker.ViewPagerAdapter.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class Template2 extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    NavigationView navigationView;
    LinearLayout linearLayout;
    Dialog dialog;
    Menu menu;
    EditText tabNameEdit;
    String tabNameString;
    int themeColor = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template2);

        initViews();
    }

    private void initViews() {


        setupDialog();
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        drawer = findViewById(R.id.template2Drawer);
        toolbar = findViewById(R.id.toolbarTemplate2);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Template 2");
        navigationView = findViewById(R.id.template2NavigationDrawer);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        View view = navigationView.getHeaderView(0);

        linearLayout = view.findViewById(R.id.naviHeaderLayout);
        TextView textView = view.findViewById(R.id.navAppTitle);
        textView.setText("App Name");

//
//        findViewById(R.id.chooseColorButton).setOnClickListener(this);
//        findViewById(R.id.addTabButton).setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void setupDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_tab_dialog);
        dialog.setTitle("Add Category");
        tabNameEdit = dialog.findViewById(R.id.tabNameEdit);

        dialog.findViewById(R.id.tabAddButton).setOnClickListener(this);
        dialog.findViewById(R.id.tabCancelButton).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.template2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.pick_color) {
            applyColorDialog();
        } else if (item.getItemId() == R.id.add_category) {
            dialog.show();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tabAddButton: {
                createTab();
                break;
            }
//            case R.id.chooseColorButton: {
//                applyColorDialog();
//                break;
//            }
//            case R.id.addTabButton: {
//                dialog.show();
//                break;
//            }
            case R.id.tabCancelButton: {
                dialog.dismiss();
                break;
            }

        }
    }

    private void createTab() {
        tabNameString = tabNameEdit.getText().toString();
        if (!(tabNameString.equals(""))) {
            tabLayout.addTab(tabLayout.newTab().setText(tabNameString).setIcon(android.R.drawable.ic_menu_add));
            setupViewPager(viewPager);
            tabNameEdit.setText("");
            dialog.dismiss();
        } else {
            tabNameEdit.setError("Category name required");
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Template2Fragment(), "Template 2");
        viewPager.setAdapter(adapter);

    }

    public void applyColorDialog() {
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(995)
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        tabLayout.setBackgroundColor(selectedColor);
                        toolbar.setBackgroundColor(selectedColor);
                        navigationView.setItemTextColor(ColorStateList.valueOf(selectedColor));
                        navigationView.setItemIconTintList(ColorStateList.valueOf(selectedColor));
                        linearLayout.setBackgroundColor(selectedColor);
                        themeColor = selectedColor;

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item2) {
            menu = navigationView.getMenu();
            menu.add("Hello");
        }

        return true;
    }
}
