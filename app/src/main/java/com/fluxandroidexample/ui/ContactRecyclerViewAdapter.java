package com.fluxandroidexample.ui;

import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import com.fluxandroidexample.*;
import com.fluxandroidexample.model.*;

import io.realm.*;

/**
 * RecyclerView Adapter
 */
class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    private RealmResults<Contact> mContactList;

    ContactRecyclerViewAdapter(RealmResults<Contact> contacts) {
        this.mContactList = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mContactList.get(position));
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    void refreshData(RealmResults<Contact> contactsList) {
        mContactList = contactsList;
        notifyDataSetChanged();
    }

    /**
     * View holder for the Recycler view
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContactName;
        private TextView mTvContactNumber;

        ViewHolder(View itemView) {
            super(itemView);
            mTvContactName = (TextView) itemView.findViewById(R.id.tv_contact_name);
            mTvContactNumber = (TextView) itemView.findViewById(R.id.tv_contact_number);
        }

        void setData(Contact contact) {
            mTvContactName.setText(contact.getName());
            mTvContactNumber.setText(contact.getContactNumber());
        }
    }
}
