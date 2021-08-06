package com.example.newapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentThisServer extends Fragment {
    TextView nameServer;
    TextView currentUsers;
    TextView maxValueUsers;
    ImageView bgColor;
    ProgressBar progressBar;
    ArrayList<DataServer> dataServers = new ArrayList<DataServer>();

    public FragmentThisServer(){
        super(R.layout.fragment_this_server);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setData();

        nameServer = view.findViewById(R.id.name_server_this);
        currentUsers = view.findViewById(R.id.current_number_users_this);
        bgColor = view.findViewById(R.id.bg_color_this);
        progressBar = view.findViewById(R.id.progress_bar_server_this);
        maxValueUsers = view.findViewById(R.id.max_value_users_this);

        String nameServerThis = dataServers.get(0).getNameServer();
        nameServer.setText(nameServerThis);
        Integer currentUsersInServer = dataServers.get(0).getNumberOfUsers();
        currentUsers.setText(currentUsersInServer.toString());

        bgColor.setColorFilter(requireContext().getColor(dataServers.get(0).getBgColor()), PorterDuff.Mode.SRC_ATOP);

        progressBar.setMax(1000);
        progressBar.setProgress(dataServers.get(0).getNumberOfUsers());
        progressBar.getProgressDrawable().setColorFilter(requireContext().getColor(dataServers.get(0).getBgColor()), PorterDuff.Mode.SRC_ATOP);
        maxValueUsers.setTextColor(dataServers.get(0).getBgColor());
    }

    void setData() {
        dataServers.add(new DataServer("Server1", 900, R.color.orange));
    }
}