package dev.mks.androidintro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyCustomAdapter extends BaseAdapter {
    String [] title,description;

    public MyCustomAdapter(String[] title, String[] description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            TextView tvtitle = convertView.findViewById(R.id.txt_title);
            TextView tvdesc = convertView.findViewById(R.id.txt_desc);
            tvtitle.setText(title[position]);
            tvdesc.setText(description[position]);
        }
        return convertView;
    }
}
