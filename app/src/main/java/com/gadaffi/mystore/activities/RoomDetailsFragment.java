package com.gadaffi.mystore.activities;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gadaffi.mystore.Constants;
import com.gadaffi.mystore.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomDetailsFragment extends Fragment {


    TextView roomname,roomno,nofspaces,price;

    ImageView image;
    SharedPreferences pref;



    public RoomDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_details, container, false);


        initViews(view);
        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        pref = getContext().getSharedPreferences("roomdata",MODE_PRIVATE);
        price.setText(pref.getString(Constants.PRICE,""));
       nofspaces.setText(pref.getString(Constants.SPACES,""));
        roomno.setText(pref.getString(Constants.ROOMNO,""));

//
//        if(pref.getString(Constants.IMAGE,"") != null)
//        {
//            Picasso.get().load(BASE_URL+"/web/uploaded_images/" +pref.getString(Constants.IMAGE,"")).
//                    placeholder(R.drawable.user_login).into(homeImageView);
//        }else {
//
//            Picasso.get().load(R.drawable.user_login).into(homeImageView);
//        }



    }


    private void initViews(View view){

        price = (TextView)view.findViewById(R.id.price);
        nofspaces = (TextView)view.findViewById(R.id.nofspaces);
        roomno = (TextView)view.findViewById(R.id.roomno);
        image = (ImageView) view.findViewById(R.id.thumbnail);


    }



}
