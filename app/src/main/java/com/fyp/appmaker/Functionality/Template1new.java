package com.fyp.appmaker.Functionality;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fyp.appmaker.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Template1new extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private  ActionBarDrawerToggle toggle;
    private int defaultColor;
    private List<Integer> colorsList;
    private EditText chooseColorText;
    private LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template1new);

        Toolbar toolbar=findViewById(R.id.template1ToolBar);
        setSupportActionBar(toolbar);

        colorsList=new ArrayList<>();
        defaultColor= ContextCompat.getColor(Template1new.this,R.color.colorPrimary);

        drawerLayout=findViewById(R.id.template1DrawerLayout);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.temp1_nav_drawer_open,R.string.temp1_nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

         navigationView=findViewById(R.id.template1_new_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        TextView textView=header.findViewById(R.id.headerTitle);
        textView.setText("My App");
        ImageView button=header.findViewById(R.id.addMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMenu();
            }
        });

    }

    @Override public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.categories:
                Toast.makeText(this, "Categories clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.addMenu:
//                addMenu();
//                break;
        }
        return true;
    }

    public void editGradient(View view)
    {
        final View view1= LayoutInflater.from(this).inflate(R.layout.edit_gradient_dialog,null);
        final EditText noOfcolorsEditText=view1.findViewById(R.id.noOfColorsEditText);
        parent=view1.findViewById(R.id.layoutList);
        Button okayButton=view1.findViewById(R.id.okayButton);
        okayButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (noOfcolorsEditText.getText().toString().isEmpty() || noOfcolorsEditText.getText().toString().replace(" ","").equals(""))
                {
                    Toast.makeText(Template1new.this, "Enter number of colors to add", Toast.LENGTH_SHORT).show();
                }else
                {
                    parent.removeAllViews();
                    int number=Integer.valueOf(noOfcolorsEditText.getText().toString());
//                    parent.removeViews(1,parent.getChildCount()-1);
//                    parent.removeAllViews();
                    for (int i=0;i<number;i++)
                    {
                        addLayouts();
                    }
//                    openColorPicker();
//                    ViewGroup viewGroup= (ViewGroup) v.getParent();
//                    if (colorsList!=null && colorsList.size()>0)
//                    {
//                        viewGroup.getChildAt(0).setBackgroundColor(colorsList.get(colorsList.size()-1));
//                    }
                }
            }
        });


//        noOfcolorsEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus)
//                {
//                    int number=Integer.valueOf(noOfcolorsEditText.getText().toString());
//                    LinearLayout linearLayout=new LinearLayout(MainActivity.this);
//                    linearLayout.setId(0);
//                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
//                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                    linearLayout.setBackgroundColor(getResources().getColor(R.color.black));
//                    parent.addView(linearLayout);
//                }
//            }
//        });

        AlertDialog builder=new AlertDialog.Builder(this)
                .setView(view1)
                .setTitle("Edit Header Background")
                .create();
        builder.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addLayouts() {
        LinearLayout linearLayout=new LinearLayout(Template1new.this);
        linearLayout.setId(0);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        chooseColorText=new EditText(Template1new.this);
        chooseColorText.setText("Choose Color");
        chooseColorText.setInputType(0);
        chooseColorText.setEnabled(false);
        chooseColorText.setId(ViewCompat.generateViewId());
        chooseColorText.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        chooseColorText.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        linearLayout.addView(chooseColorText);
        linearLayout.getChildAt(linearLayout.getChildCount()-1).setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1.3f));

        Button colorPickerButton=new Button(Template1new.this);
        colorPickerButton.setId(ViewCompat.generateViewId());
        colorPickerButton.setBackground(getDrawable(R.drawable.ic_color_lens_pink_24dp));
        colorPickerButton.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        colorPickerButton.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        colorPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                openColorPicker();
                AmbilWarnaDialog colorPicker=new AmbilWarnaDialog(Template1new.this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        colorsList.add(Integer.valueOf(color));
                        defaultColor=color;
                        ViewGroup row= (ViewGroup) v.getParent();
                        row.getChildAt(0).setBackgroundColor(color);
                        EditText text= (EditText) row.getChildAt(0);
                        text.setText("Color Added");
                    }
                });
                colorPicker.show();

//                        v..setText("Color Added");
//                        chooseColorText.setBackgroundColor(colorsList.get(colorsList.size()-1));

            }
        });

        linearLayout.addView(colorPickerButton);
        linearLayout.getChildAt(linearLayout.getChildCount()-1).setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,8));
        parent.addView(linearLayout);
        Log.e("here", "onClick: " );
    }

    private void addMenu() {
        Menu menu=navigationView.getMenu();
        menu.add("New menu");
        Toast.makeText(this, "New menu added", Toast.LENGTH_SHORT).show();
    }

    public void add(View view)
    {
        Menu menu=navigationView.getMenu();
        menu.add("New menu item");
    }

    private void openColorPicker() {
        AmbilWarnaDialog colorPicker=new AmbilWarnaDialog(Template1new.this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                colorsList.add(Integer.valueOf(color));
                defaultColor=color;
            }
        });
        colorPicker.show();
    }

//    private void addMenu() {
//        Menu menu=navigationView.getMenu();
//        menu.add("Categories").setVisible(true);
////        menu.getItem(R.id.profile).setVisible(true);
////        menu.findItem(R.id.profile).setVisible(true);
////        navigationView.getMenu().clear(); //clear old inflated items.
////        navigationView.inflateMenu(R.menu.template1new_menu);
//    }
}
