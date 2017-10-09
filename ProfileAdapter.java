package com.example.mchho.networkasync;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by mchho on 04/10/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder>{

    private List<Profile> profileList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, address;
        private ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name_text);
            phone = (TextView) view.findViewById(R.id.phone_text);
            address = (TextView) view.findViewById(R.id.address_text);
            photo = (ImageView) view.findViewById(R.id.profile_image);
        }
    }


    public ProfileAdapter(Context context, List<Profile> profileList) {
        this.profileList = profileList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.name.setText(profile.getName());
        holder.phone.setText(profile.getPhone());
        holder.address.setText(profile.getAddress());
        Glide.with(context).load(profile.getPhoto()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}


