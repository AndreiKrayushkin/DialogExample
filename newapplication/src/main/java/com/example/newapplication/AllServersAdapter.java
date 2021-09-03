package com.example.newapplication;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllServersAdapter extends RecyclerView.Adapter<AllServersAdapter.AllServersHolder> {

    private List<DataServ> dataServers;
    private OnClickListener onClickListener;

    interface OnClickListener {
        void click (DataServ dataServer);
    }

    public AllServersAdapter(List<DataServ> dataServers, OnClickListener onClickListener) {
        this.dataServers = dataServers;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AllServersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.server_element, parent, false);
        return new AllServersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllServersHolder holder, int position) {
        DataServ dataServer = dataServers.get(position);
        holder.nameServer.setText(dataServer.getNameServer());
        Integer numberOfUsers = dataServer.getNumberOfUsers();
        holder.currentNumberUsers.setText(numberOfUsers.toString());

        holder.bgColor.setColorFilter(ContextCompat.getColor(holder.bgColor.getContext(), dataServer.getBgColor()));
        holder.progressBar.setMax(1000);
        holder.progressBar.setProgress(dataServer.getNumberOfUsers());

        holder.progressBar.getProgressDrawable().setColorFilter(ContextCompat.getColor(holder.progressBar.getContext(), dataServer.getBgColor()), PorterDuff.Mode.SRC_ATOP);

        holder.maxValueUsers.setTextColor(ContextCompat.getColor(holder.maxValueUsers.getContext(),
                dataServer.getBgColor()));

    }

    @Override
    public int getItemCount() {
        return dataServers.size();
    }

    public class AllServersHolder extends RecyclerView.ViewHolder {
        final TextView nameServer;
        final TextView currentNumberUsers;
        TextView maxValueUsers;
        ImageView bgColor;
        ProgressBar progressBar;
        AllServersHolder(@NonNull View itemView) {
            super(itemView);
            nameServer = itemView.findViewById(R.id.name_server);
            currentNumberUsers = itemView.findViewById(R.id.current_number_users);
            maxValueUsers = itemView.findViewById(R.id.max_value_users);
            bgColor = itemView.findViewById(R.id.bg_color);
            progressBar = itemView.findViewById(R.id.progress_bar_server);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataServ dataServ = dataServers.get(getLayoutPosition());
                    onClickListener.click(dataServ);
                }
            });
        }
    }
}
