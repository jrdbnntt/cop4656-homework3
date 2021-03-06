package com.jrdbnntt.cop4656.homework3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrdbnntt.cop4656.homework3.UrlListFragment.OnListFragmentInteractionListener;
import com.jrdbnntt.cop4656.homework3.UrlListContent.UrlListItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link UrlListItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUrlListRecyclerViewAdapter extends RecyclerView.Adapter<MyUrlListRecyclerViewAdapter.ViewHolder> {

    private final List<UrlListItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyUrlListRecyclerViewAdapter(List<UrlListItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_urllist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getUrlWithoutProtocol());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public UrlListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

    }
}
