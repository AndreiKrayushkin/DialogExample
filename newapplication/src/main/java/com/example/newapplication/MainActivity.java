package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements OnChangeFragmentListener {
    FragmentAllServers fragmentAllServers = new FragmentAllServers();
    FragmentThisServer fragmentThisServer = new FragmentThisServer();
    ImageView buttonThisServer;
    ImageView buttonAllServers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAllServers = findViewById(R.id.button_all_servers);
        buttonThisServer = findViewById(R.id.button_my_server);

        activeAllServersFragment();

        buttonAllServers.setOnClickListener((view) -> {
            onFragmentChange(1, null);
            activeAllServersFragment();
        });

        buttonThisServer.setOnClickListener((view) -> {
            onFragmentChange(2, null);
            activeThisServersFragment();
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_list_servers, fragmentAllServers)
                .commit();
    }

    private void activeAllServersFragment() {
        buttonAllServers.setBackground(AppCompatResources.getDrawable(this, R.drawable.border_activity_element));
        buttonThisServer.setBackground(AppCompatResources.getDrawable(this, R.drawable.border_not_activity_element));
    }

    private void activeThisServersFragment() {
        buttonThisServer.setBackground(AppCompatResources.getDrawable(this, R.drawable.border_activity_element));
        buttonAllServers.setBackground(AppCompatResources.getDrawable(this, R.drawable.border_not_activity_element));
    }

    @Override
    public void onFragmentChange(Integer fragmentConst, Bundle bundle) {
        switch (fragmentConst){
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_list_servers, fragmentAllServers)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_list_servers, fragmentThisServer)
                        .commit();
                break;
        }
    }
}