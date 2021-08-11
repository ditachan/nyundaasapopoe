package com.android.nyundaasapopoe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SQLiteListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> user_id;
    private ArrayList<String> user_kata;
    private ArrayList<String> user_arti;

    SQLiteListAdapter(Context context1, ArrayList<String> ID, ArrayList<String> KATA, ArrayList<String> ARTI) {
        this.context = context1;
        this.user_id = ID;
        this.user_kata = KATA;
        this.user_arti = ARTI;
    }

    public class Holder {
        TextView textView_id;
        TextView textView_kata;
        TextView textView_arti;
    }

    @Override
    public int getCount() {
        return user_id.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        LayoutInflater inflater;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_data_layout, null);

            holder = new Holder();

            holder.textView_id = convertView.findViewById(R.id.text_id);
            holder.textView_kata = convertView.findViewById(R.id.text_kata);
            holder.textView_arti = convertView.findViewById(R.id.text_arti);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.textView_id.setText(user_id.get(position));
        holder.textView_kata.setText(user_kata.get(position));
        holder.textView_arti.setText(user_arti.get(position));
        return convertView;
    }
}