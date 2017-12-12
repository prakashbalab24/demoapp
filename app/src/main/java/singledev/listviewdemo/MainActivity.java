package singledev.listviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        ListView l1;
        private String[] messi={"messi1", "messi2", "messi3", "messi4", "messi5"};
        private int[] img={android.R.drawable.arrow_down_float,android.R.drawable.arrow_down_float,android.R.drawable.arrow_down_float,
                android.R.drawable.arrow_down_float,
                android.R.drawable.arrow_down_float};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            l1=(ListView)findViewById(R.id.list1);
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,messi);
            custamAdapter ca=new custamAdapter(this,messi,img);

            l1.setAdapter(ca);
            l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), "messi+"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
        public class custamAdapter extends BaseAdapter {
        String[] tit;
        int[] img;

    public custamAdapter(Context context, String[] tit, int[] img) {
        this.tit = tit;
        this.img = img;
    }

            @Override
            public int getCount() {
                return tit.length;
            }

            @Override
            public Object getItem(int position) {
                return tit[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

       /* LayoutInflater inf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
                View v = getLayoutInflater().inflate(R.layout.list, parent, false);
                ImageView iv=(ImageView)v.findViewById(R.id.imageView);
                TextView tv=(TextView)v.findViewById(R.id.textView);

                iv.setImageResource(img[position]);
                tv.setText(messi[position]);
                return v;

            }
        }

    }
