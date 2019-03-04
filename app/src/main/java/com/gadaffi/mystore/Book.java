package com.gadaffi.mystore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

import static android.support.v7.widget.RecyclerView.*;

public class Book extends AppCompatActivity {
    ListView list;
    String titles[] = {"Title One", "Title Two", "Title Three", "Title Four"};
    String descriptions[] = {"Description One...", "Description Two...", "Description Three..", "Description Four.."};
    int imgs[] = {R.drawable.apart4, R.drawable.apart3, R.drawable.apart2, R.drawable.apart2};
    String[]listviewitems=new String[]{

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


             list = findViewById(R.id.list1);
            //creating instance of class MyAdapter
            MyAdapter adapter = new MyAdapter(this, titles, imgs, descriptions);
            //set adapter to list
            list.setAdapter(adapter);
            //handle item clicks
            //toast on each item click using same method which can move to different activity
            //pass data to some activity
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Toast.makeText(Book.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 1) {
                        Toast.makeText(Book.this, "Item Two Clicked", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        Toast.makeText(Book.this, "Item Three Clicked", Toast.LENGTH_SHORT).show();
                    }
                    if (position == 3) {
                        Toast.makeText(Book.this, "Item Four Clicked", Toast.LENGTH_SHORT).show();
                    }

                    String Templistview=listviewitems[position].toString();
                   // Intent intent=new Intent(Book.this,Rooms.class);
                    //intent.putExtra("Listviewclickvalue",Templistview);
                    //startActivity(intent);
                }
            });
        }

        class MyAdapter extends ArrayAdapter<String> {
            String context;
            String myTitles[];
            String myDescriptions[];
            int[] imgs;

            MyAdapter(Context c, String[] titles, int[] imgs, String[] descriptions) {
                super(c, R.layout.fragment_book, R.id.text1, titles);
                this.context = "c";
                this.imgs = imgs;
                this.myTitles = titles;
                this.myDescriptions = descriptions;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View fragment_book = layoutInflater.inflate(R.layout.fragment_book, parent, false);
                ImageView images = fragment_book.findViewById(R.id.logo);
                TextView myTitle = fragment_book.findViewById(R.id.text1);
                TextView myDescription = fragment_book.findViewById(R.id.text2);
                images.setImageResource(imgs[position]);
                myTitle.setText(titles[position]);
                myDescription.setText(descriptions[position]);

                return fragment_book;

            }
        }
    }
