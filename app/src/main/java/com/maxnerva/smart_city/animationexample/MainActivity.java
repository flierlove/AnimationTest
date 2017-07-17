package com.maxnerva.smart_city.animationexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView = (ListView)findViewById(R.id.listView);
        List<String> items = new ArrayList<>();
        items.add("ViewAnimation");
        items.add("DrawableAnimation");
        items.add("PropertyAnimation");

        listView.setAdapter(new MyAdapter(items, new OnClickAtIndexListener() {
            @Override
            public void OnClickAtIndex(int position) {
                switch (position){
                    case 0:
                    {
                        Intent intent = new Intent(MainActivity.this,ViewAnimationActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                    break;
                    case 1:
                    {
                        Intent intent = new Intent(MainActivity.this,DrawableAnimationActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                    break;
                    case 2:
                    {
                        Intent intent = new Intent(MainActivity.this,PropertyAnimationActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                    break;
                }
            }
        }));
    }

    private interface OnClickAtIndexListener{
        void OnClickAtIndex(int position);
    }
    private class MyAdapter extends BaseAdapter {

        private OnClickAtIndexListener onClickAtIndexListener;
        private List<String> items;

        public MyAdapter(List<String> items, OnClickAtIndexListener onClickAtIndexListener) {
            this.items = items;
            this.onClickAtIndexListener = onClickAtIndexListener;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                viewHolder.position = position;
                convertView = getLayoutInflater().inflate(R.layout.item_view, null);
                viewHolder.textView = (TextView)convertView.findViewById(R.id.textView);
                convertView.setTag(viewHolder);
                convertView.setOnClickListener(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
                viewHolder.position = position;
            }

            viewHolder.textView.setText(items.get(position));
            return convertView;
        }

        private final class ViewHolder implements View.OnClickListener {
            TextView textView;
            int position;

            @Override
            public void onClick(View v) {
                onClickAtIndexListener.OnClickAtIndex(position);
            }
        }
    }
}
