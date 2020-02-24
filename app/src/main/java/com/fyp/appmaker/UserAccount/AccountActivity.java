package com.fyp.appmaker.UserAccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fyp.appmaker.Firebase.FirebaseDb;
import com.fyp.appmaker.Functionality.Template1ItemListAdapter;
import com.fyp.appmaker.Models.AppDetailsModel;
import com.fyp.appmaker.Models.ItemsModel;
import com.fyp.appmaker.R;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.fyp.appmaker.databinding.ActivityAccountBinding;

import java.util.ArrayList;

public class AccountActivity extends UtilitiesClass implements FirebaseDb.FirebaseCallBack {

    ActivityAccountBinding binding;
    ArrayList<ItemsModel> arrayListItem;
    FirebaseDb firebaseDb;
    ArrayList<AppDetailsModel> list = new ArrayList<>();
    ItemsModel itemsModel;
    Template1ItemListAdapter adapter;
    String creatorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_account);
        binding.loadingBar.setVisibility(View.VISIBLE);
        initViews();




    }

    private void initViews() {
        firebaseDb = new FirebaseDb(this);
        firebaseDb.getUserAppDetails(this);


//        binding.relativeInfo.animate().translationY(500f).setDuration(1500).start();
//        binding.refreshLayout.animate().translationY(-500f).setDuration(1500).start();
        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(AccountActivity.this, "List Refreshed", Toast.LENGTH_SHORT).show();
                binding.refreshLayout.setRefreshing(false);
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setRecyclerView() {
        binding.appViewRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Template1ItemListAdapter(this, "app", list);
        binding.appViewRecycler.setAdapter(adapter);
    }


    @Override
    public void LoadAppName(String name, String icon) {

    }

    @Override
    public void LoadAppDetails(ArrayList<AppDetailsModel> arrayList) {
        this.list = arrayList;
        creatorName = list.get(0).getCreatorName();
        binding.textViewCreatorName.setText(creatorName);
        binding.textViewAppCreated.setText("Apps Created: " + String.valueOf(list.size()));
        binding.textViewUserKey.setText(list.get(0).getUserId());

        setRecyclerView();
        binding.loadingBar.setVisibility(View.GONE);
        //adapter.notifyDataSetChanged();
    }


}
