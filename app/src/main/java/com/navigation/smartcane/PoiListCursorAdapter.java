package com.navigation.smartcane;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import khushboo.rohit.osmnavi.R;

public class PoiListCursorAdapter extends CursorAdapter {
    public PoiListCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.poilist_listview, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody2);
        TextView tvPriority = (TextView) view.findViewById(R.id.tvPriority2);
        // Extract properties from cursor
        String body = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String priority = "Distance: " + cursor.getString(cursor.getColumnIndexOrThrow("distance"));
        // Populate fields with extracted properties
        tvBody.setText(body);
        tvPriority.setText(priority);
    }
}