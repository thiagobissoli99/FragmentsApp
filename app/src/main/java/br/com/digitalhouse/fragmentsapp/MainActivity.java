package br.com.digitalhouse.fragmentsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.fragmentsapp.fragments.Fragment2;
import br.com.digitalhouse.fragmentsapp.fragments.fragmento1;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment1;
    private Button btnFragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnFragment2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addFragment(new Fragment2());

                    }
                });


                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, new fragmento1());
                transaction.addToBackStack("Fragments");
                transaction.commit();
            }
        });
    }

    private void initViews() {
        btnFragment1 = findViewById(R.id.btnFragmento1);
        btnFragment2 = findViewById(R.id.btnFragmento2);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new fragmento1());
        transaction.addToBackStack("Fragments");
        transaction.commit();

    }
}