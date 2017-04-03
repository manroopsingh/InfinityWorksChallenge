package com.example.singh.infinityworkschallenge.utility;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.singh.infinityworkschallenge.R;
import com.example.singh.infinityworkschallenge.activities.AuthorityDetailActivity;
import com.example.singh.infinityworkschallenge.model.authorities.Authority;

import java.util.List;

/**
 * Created by singh on 29-Mar-17.
 */

public class AuthorityListAdapter extends RecyclerView.Adapter<AuthorityListAdapter.ViewHolder> {

    List<Authority> authorityList;
    Context context;

    public AuthorityListAdapter(Context context, List<Authority> authorityList) {
        this.authorityList = authorityList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView authorityName, regionName, authorityEmail;
        public LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            authorityName = (TextView) itemView.findViewById(R.id.tvAuthorityName);
            regionName = (TextView) itemView.findViewById(R.id.tvRegionName);
            authorityEmail = (TextView) itemView.findViewById(R.id.tvAuthorityEmail);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.llAuthority);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.authority_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Authority authority = authorityList.get(position);

        holder.authorityName.setText(authority.getName());
        holder.regionName.setText(authority.getRegionName());
        holder.authorityEmail.setText(authority.getEmail());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AuthorityDetailActivity.class);
                intent.putExtra("authority", authority);
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return authorityList.size();
    }
}
