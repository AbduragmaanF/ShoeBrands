package com.example.abduragmaanlistview;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String item[]={
            "Addidas",
            "Converse",
            "Diesel",
            "Lacoste",
            "Nike",
            "New Balance",
            "Reebok",
            "Timberland",
            "Sebago"};

    int image[]={
            R.drawable.addidas,
            R.drawable.converse,
            R.drawable.diesel,
            R.drawable.lacoste,
            R.drawable.nike,
            R.drawable.nwbal,
            R.drawable.reebok,
            R.drawable.timberland,
            R.drawable.sebago};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView);

        CustAdapter custAdapter= new CustAdapter();
        lv.setAdapter(custAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "U clicked:" + item[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CustAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return image.length;
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
            View v = getLayoutInflater().inflate(R.layout.listview, null);

            ImageView i = (ImageView)  v.findViewById(R.id.itemName);
            TextView t = (TextView) v.findViewById(R.id.itemPic);

            i.setImageResource(image[position]);
            t.setText(item[position]);

            return v;
        }
    }
}