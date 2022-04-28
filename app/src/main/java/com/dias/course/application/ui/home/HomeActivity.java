package com.dias.course.application.ui.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dias.course.R;
import com.dias.course.application.ui.home.fragments.poducts.ProductFragment;
import com.dias.course.application.ui.home.fragments.receipt.ReceiptFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Nullable
    private ProductFragment productFragment;
    @Nullable
    private ReceiptFragment receiptFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        productFragment = ProductFragment.newInstance();
        receiptFragment = ReceiptFragment.newInstance();

        showFragment(productFragment);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_products) {
                    showFragment(productFragment);

                    Toast.makeText(HomeActivity.this, "Product Tab selected!!!!", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.action_receipts) {
                    showFragment(receiptFragment);

                    Toast.makeText(HomeActivity.this, "Receipt Tab selected!!!!", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        if(bottomNavigationView.getSelectedItemId() == R.id.action_products){
            super.onBackPressed();
        }else {
            bottomNavigationView.setSelectedItemId(R.id.action_products);
        }
    }

    protected boolean hasTabletDevice() {
        boolean status = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
        if (status)
            return false; //"Mobile"
        else
            return true; //"Tablet"
    }
}