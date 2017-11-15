package com.example.max.testui.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.max.testui.R;
import com.example.max.testui.fragments.BlankFragment;
import com.example.max.testui.fragments.BlankFragment2;
import com.example.max.testui.fragments.BlankFragment3;
import com.example.max.testui.networking.dto.translateDTO;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements BlankFragment2.OnFragmentInteractionListener{

    private android.support.v4.app.FragmentTransaction getTransaction;
    private List<translateDTO> translateDTOS;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    getTransaction = getSupportFragmentManager().beginTransaction();
    getTransaction.replace(R.id.fl, new BlankFragment()).commit();



    if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS}, 1);

            }
        }



        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.screen1:
                            getTransaction.replace(R.id.fl, new BlankFragment2()).commit();
                        break;
                    case R.id.screen2:
                            getTransaction.replace(R.id.fl, new BlankFragment()).commit();
                        break;
                    case R.id.screen3:
                        getTransaction.replace(R.id.fl, new BlankFragment3()).commit();
                        break;
                }
                return false;
            }
        });

}

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
