package com.fyp.appmaker.Authenticaiton;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.fyp.appmaker.Firebase.FirebaseDb;
import com.fyp.appmaker.Models.UserModel;
import com.fyp.appmaker.R;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.fyp.appmaker.databinding.ActivitySignUpBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends UtilitiesClass implements View.OnClickListener {

    ActivitySignUpBinding signUpBinding;
    Pattern pattern;
    Matcher matcher;
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    MaterialAlertDialogBuilder alertDialogBuilder;
    String userId;
    String name, email, pass, confirmPass;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
    FirebaseDb db;


    String termsAndCconditions = "Introduction\n" +
            "These Website Standard Terms and Conditions written on this webpage shall manage your use of our website, Webiste Name accessible at Website.com.\n" +
            "\n" +
            "These Terms will be applied fully and affect to your use of this Website. By using this Website, you agreed to accept all terms and conditions written in here. You must not use this Website if you disagree with any of these Website Standard Terms and Conditions.\n" +
            "\n" +
            "Minors or people below 18 years old are not allowed to use this Website.\n" +
            "\n" +
            "Intellectual Property Rights\n" +
            "Other than the content you own, under these Terms, Company Name and/or its licensors own all the intellectual property rights and materials contained in this Website.\n" +
            "\n" +
            "You are granted limited license only for purposes of viewing the material contained on this Website.\n" +
            "\n" +
            "Restrictions\n" +
            "You are specifically restricted from all of the following:\n" +
            "\n" +
            "Your Content\n" +
            "In these Website Standard Terms and Conditions, “Your Content” shall mean any audio, video text, images or other material you choose to display on this Website. By displaying Your Content, you grant Company Name a non-exclusive, worldwide irrevocable, sub licensable license to use, reproduce, adapt, publish, translate and distribute it in any and all media.\n" +
            "\n" +
            "Your Content must be your own and must not be invading any third-party's rights. Company Name reserves the right to remove any of Your Content from this Website at any time without notice.\n" +
            "\n" +
            "No warranties\n" +
            "This Website is provided “as is,” with all faults, and Company Name express no representations or warranties, of any kind related to this Website or the materials contained on this Website. Also, nothing contained on this Website shall be interpreted as advising you.\n" +
            "\n" +
            "Limitation of liability\n" +
            "In no event shall Company Name, nor any of its officers, directors and employees, shall be held liable for anything arising out of or in any way connected with your use of this Website whether such liability is under contract.  Company Name, including its officers, directors and employees shall not be held liable for any indirect, consequential or special liability arising out of or in any way related to your use of this Website.\n" +
            "\n" +
            "Indemnification\n" +
            "You hereby indemnify to the fullest extent Company Name from and against any and/or all liabilities, costs, demands, causes of action, damages and expenses arising in any way related to your breach of any of the provisions of these Terms.\n" +
            "\n" +
            "Severability\n" +
            "If any provision of these Terms is found to be invalid under any applicable law, such provisions shall be deleted without affecting the remaining provisions herein.\n" +
            "\n" +
            "Variation of Terms\n" +
            "Company Name is permitted to revise these Terms at any time as it sees fit, and by using this Website you are expected to review these Terms on a regular basis.\n" +
            "\n" +
            "Assignment\n" +
            "The Company Name is allowed to assign, transfer, and subcontract its rights and/or obligations under these Terms without any notification. However, you are not allowed to assign, transfer, or subcontract any of your rights and/or obligations under these Terms.\n" +
            "\n" +
            "Entire Agreement\n" +
            "These Terms constitute the entire agreement between Company Name and you in relation to your use of this Website, and supersede all prior agreements and understandings.\n" +
            "\n" +
            "Governing Law & Jurisdiction\n" +
            "These Terms will be governed by and interpreted in accordance with the laws of the State of Country, and you submit to the non-exclusive jurisdiction of the state and federal courts located in Country for the resolution of any disputes.";

    public SignUpActivity()
    {

    }

    public SignUpActivity(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        db = new FirebaseDb(this);
        initListeners();

    }


    private void initListeners() {
        findViewById(R.id.tncTV).setOnClickListener(this);
        findViewById(R.id.signUpButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tncTV: {
                openTermsAndConditions();
                break;
            }
            case R.id.signUpButton: {
                initSignUpProcess();
                break;
            }
        }
    }

    private void initSignUpProcess() {


        name = signUpBinding.nameET.getText().toString();
        email = signUpBinding.emailET.getText().toString();
        pass = signUpBinding.passwordET.getText().toString();
        confirmPass = signUpBinding.confirmPassET.getText().toString();
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(email);
        signUpBinding.loadingBar.setVisibility(View.VISIBLE);

        if (!(name.isEmpty() && email.isEmpty() && pass.isEmpty() && confirmPass.isEmpty())) {
            if (pass.equals(confirmPass)) {
                if (matcher.matches()) {
                    checkIfUserExists(email);
                } else {
                    signUpBinding.emailET.setError("Invalid email");
                    signUpBinding.loadingBar.setVisibility(View.INVISIBLE);
                }
            } else {
                signUpBinding.confirmPassET.setError("Password doesn't match");
                signUpBinding.loadingBar.setVisibility(View.INVISIBLE);
            }
        } else {
            signUpBinding.nameET.setError("Name required");
            signUpBinding.emailET.setError("Email required");
            signUpBinding.passwordET.setError("Password required");
            signUpBinding.loadingBar.setVisibility(View.INVISIBLE);

        }

    }

    private void checkIfUserExists(String userEmail) {
        Query query = mDatabase.orderByChild("email").equalTo(userEmail);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            boolean exist = false;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    exist = true;
                    signUpBinding.loadingBar.setVisibility(View.INVISIBLE);
                    signUpBinding.emailET.setError("User with this email already exists");
                }
                if (!exist) {
                    signUpBinding.loadingBar.setVisibility(View.INVISIBLE);
                    db.addUser(new UserModel("",name, email, pass));
                    Toast.makeText(SignUpActivity.this, "Account created!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SignUpActivity.this, "something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void openTermsAndConditions() {

        alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        alertDialogBuilder.setTitle("Terms and Conditions")
                .setMessage(termsAndCconditions)
                .setPositiveButton("Agree", null)
                .show();
    }


}
