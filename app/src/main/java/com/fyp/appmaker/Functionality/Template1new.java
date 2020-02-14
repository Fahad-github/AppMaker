package com.fyp.appmaker.Functionality;

import androidx.annotation.ArrayRes;
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

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
    private List<Integer> idList;
    private EditText chooseColorText;
    private LinearLayout parent;
    private View header;
    private boolean spinnerInitialized;
    private boolean initialize=false;
    private int gradientType=0;
    private GradientDrawable gd;

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
        header=navigationView.getHeaderView(0);
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

    public void editGradient(final View view)
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
                    for (int i=0;i<number;i++)
                    {
                        addLayouts();
                    }
                }
            }
        });

        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setView(view1)
                .setTitle("Edit Header Background")
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (colorsList!=null && colorsList.size()>0)
                        {
                            if (colorsList.size()==1)
                            {
                                header.setBackgroundColor(colorsList.get(0).intValue());
                                colorsList=new ArrayList<>();
                                defaultColor= ContextCompat.getColor(Template1new.this,R.color.colorPrimary);
                            }else
                            {
                                View view2=LayoutInflater.from(Template1new.this).inflate(R.layout.gradient_details_dialog,null);
                                Spinner spinner=view2.findViewById(R.id.gradientTypesSpinner);
                                parent=view2.findViewById(R.id.gradientDetailsList);
                                spinnerInitialized=false;
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                                    @Override
                                    public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                                        if (!spinnerInitialized)
                                        {
                                            spinnerInitialized=true;
                                        }else
                                        {
                                            idList=new ArrayList<>();
                                            int[] colors = convertToIntArray();
                                            gd = new GradientDrawable(
                                                    GradientDrawable.Orientation.TOP_BOTTOM, colors);

//                                            gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
//                                            gd.setGradientRadius(0);
//                                            gd.setCornerRadius(0);
//                                            gd.setGradientCenter(0.5f,.5f);
                                            EditText centerX,centerY;
                                            parent.removeAllViews();
                                            parent.clearFocus();
                                            switch (position)
                                            {
                                                case 0:
                                                    break;
                                                case 1:
                                                    gradientType=1;
                                                    gd.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                                                    Spinner angleSpinner=new Spinner(Template1new.this);
                                                    angleSpinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    angleSpinner.setId(View.generateViewId());
                                                    angleSpinner.setPadding(5,5,5,5);
                                                    ArrayAdapter<String> spinnerArrayAdapter =
                                                            new ArrayAdapter<String>(Template1new.this, android.R.layout.simple_spinner_dropdown_item,
                                                                    getResources().getStringArray(R.array.gradient_angles));
                                                    angleSpinner.setAdapter(spinnerArrayAdapter);

                                                    angleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                        @Override
                                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                            if (!initialize)
                                                            {
                                                                initialize=true;
                                                            }else
                                                            {
                                                                switch (position)
                                                                {
                                                                    case 0:
                                                                        break;
                                                                    case 1:
                                                                        gd.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                                                                        break;
                                                                    case 2:
                                                                        gd.setOrientation(GradientDrawable.Orientation.BL_TR);
                                                                        break;
                                                                    case 3:
                                                                        gd.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                                                                        break;
                                                                    case 4:
                                                                        gd.setOrientation(GradientDrawable.Orientation.BR_TL);
                                                                        break;
                                                                    case 5:
                                                                        gd.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                                                                        break;
                                                                    case 6:
                                                                        gd.setOrientation(GradientDrawable.Orientation.TL_BR);
                                                                        break;
                                                                    case 7:
                                                                        gd.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                                                                        break;
                                                                    case 8:
                                                                        gd.setOrientation(GradientDrawable.Orientation.TR_BL);
                                                                        break;
                                                                }
//                                                        gd.setGradientRadius(Float.valueOf(getResources().getStringArray(R.array.gradient_angles)[position].replace("°","")));
                                                            }
                                                        }

                                                        @Override
                                                        public void onNothingSelected(AdapterView<?> parent) {

                                                        }
                                                    });
                                                    parent.addView(angleSpinner);
                                                    centerX=new EditText(Template1new.this);
                                                    centerX.setId(View.generateViewId());
                                                    centerX.setTag("linearCenterX");
                                                    centerX.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    centerX.setHint("Center X (Between 0-1)");
                                                    centerX.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                    centerX.setHintTextColor(getResources().getColor(R.color.black));
                                                    parent.addView(centerX);
                                                    centerY=new EditText(Template1new.this);
                                                    centerY.setId(View.generateViewId());
                                                    centerY.setTag("linearCenterY");
                                                    centerY.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    centerY.setHint("Center Y (Between 0-1)");
                                                    centerY.setInputType(InputType.TYPE_CLASS_NUMBER );
                                                    centerY.setHintTextColor(getResources().getColor(R.color.black));
                                                    parent.addView(centerY);
                                                    break;
                                                case 2:
                                                    gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                                                    gradientType=2;
                                                    EditText radius=new EditText(Template1new.this);
                                                    radius.setId(View.generateViewId());
                                                    radius.setTag("radialRadius");
                                                    radius.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    radius.setHint("Center Radius");
                                                    radius.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                                                    radius.setHintTextColor(getResources().getColor(R.color.black));
                                                    parent.addView(radius);
                                                    break;
                                                case 3:
                                                    gd.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                                                    gradientType=3;
                                                    centerX=new EditText(Template1new.this);
                                                    centerX.setId(View.generateViewId());
                                                    centerX.setTag("sweepCenterX");
                                                    centerX.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    centerX.setHint("Center X (Between 0-1)");
                                                    centerX.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                                                    centerX.setHintTextColor(getResources().getColor(R.color.black));
                                                    parent.addView(centerX);
                                                    centerY=new EditText(Template1new.this);
                                                    centerY.setId(View.generateViewId());
                                                    centerY.setTag("sweepCenterY");
                                                    centerY.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                                                    centerY.setHint("Center Y (Between 0-1)");
                                                    centerY.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                                                    centerY.setHintTextColor(getResources().getColor(R.color.black));
                                                    parent.addView(centerY);
                                                    break;
                                            }

                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
//                                header.setBackground(gd);
                                builder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        AlertDialog dialog1=AlertDialog.class.cast(dialog);
                                        LinearLayout parentLayout=dialog1.findViewById(R.id.gradientDetailsList);
                                        switch (gradientType)
                                        {
                                            case 1:
                                                EditText centerX= null;
                                                EditText centerY= null;
                                                if (parentLayout != null) {
                                                    centerX = parentLayout.findViewWithTag("linearCenterX");
                                                    centerY = parentLayout.findViewWithTag("linearCenterY");
                                                }
                                                
                                                Float x=Float.valueOf(centerX.getText().toString());
                                                Float y=Float.valueOf(centerY.getText().toString());
                                                try{
                                                    gd.setGradientCenter(x,y);
                                                }catch (NumberFormatException e)
                                                {
                                                    Toast.makeText(Template1new.this, "Invalid values", Toast.LENGTH_SHORT).show();
                                                }
                                                break;
                                            case 2:
                                                EditText radius=parentLayout.findViewWithTag("radialRadius");
                                                try{
                                                    Float r=Float.valueOf(radius.getText().toString());
                                                    gd.setGradientRadius(r);
                                                }catch (NumberFormatException e)
                                                {
                                                    Toast.makeText(Template1new.this, "Invalid Values", Toast.LENGTH_SHORT).show();
                                                }
                                                break;
                                            case 3:
                                                EditText sweepcenterX=parentLayout.findViewWithTag("sweepCenterX");
                                                EditText sweepcenterY=parentLayout.findViewWithTag("sweepCenterY");
                                                try{
                                                    Float xSweep=Float.valueOf(sweepcenterX.getText().toString());
                                                    Float ySweep=Float.valueOf(sweepcenterY.getText().toString());
                                                    gd.setGradientCenter(xSweep,ySweep);
                                                }catch (NumberFormatException e)
                                                {
                                                    Toast.makeText(Template1new.this, "Invalid Values", Toast.LENGTH_SHORT).show();
                                                }
                                                break;
                                        }
                                        header.setBackground(gd);
                                        colorsList=new ArrayList<>();
                                        defaultColor= ContextCompat.getColor(Template1new.this,R.color.colorPrimary);
                                    }
                                });
                                builder.setView(view2);
                                builder.create();
                                builder.show();
                            }
//                            dialog.dismiss();
                        }



                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        colorsList=new ArrayList<>();
                        defaultColor= ContextCompat.getColor(Template1new.this,R.color.colorPrimary);
                        dialog.dismiss();
                    }
                })
                .create();
        builder.show();
    }

    private int[] convertToIntArray() {
        int[] colors=new int[colorsList.size()];
        for (int i=0;i<colorsList.size();i++)
        {
            colors[i]=colorsList.get(i).intValue();
        }
        return colors;
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
                        colorsList.add(color);
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
