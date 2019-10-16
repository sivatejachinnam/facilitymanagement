package com.dcrewit.facilitymanagement.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.dcrewit.facilitymanagement.R;
import com.dcrewit.facilitymanagement.fragments.TicketListFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TicketListFragment ticketListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ticketListFragment = new TicketListFragment();
        frameLayout = findViewById(R.id.mainframe);
        setFragment(ticketListFragment);
    }
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe, fragment);
        fragmentTransaction.commit();
    }

}
