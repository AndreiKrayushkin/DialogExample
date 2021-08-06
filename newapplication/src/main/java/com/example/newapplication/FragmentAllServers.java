package com.example.newapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentAllServers extends Fragment {
    AllServersAdapter allServersAdapter;
    RecyclerView recyclerView;
    ArrayList<DataServer> dataServer = new ArrayList<DataServer>();

    public FragmentAllServers() {
        super(R.layout.fragment_list_servers);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setServers();

        recyclerView = view.findViewById(R.id.rv_server_list);
        allServersAdapter = new AllServersAdapter(dataServer);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(allServersAdapter);
    }

    void setServers() {
        dataServer.add(new DataServer("Server1", 900, R.color.teal_200));
        dataServer.add(new DataServer("Server2", 300, R.color.orange));
        dataServer.add(new DataServer("Server3", 600, R.color.teal_700));
        dataServer.add(new DataServer("Server4", 780, R.color.orange));
        dataServer.add(new DataServer("Server4", 780, R.color.grey));
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("LOG_VIEW", "OnPause");
        dataServer.clear();
    }
}
