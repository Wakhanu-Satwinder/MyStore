package com.gadaffi.mystore.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gadaffi.mystore.Constants;
import com.gadaffi.mystore.Models.Room;
import com.gadaffi.mystore.R;
import com.gadaffi.mystore.activities.RoomActivity;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Target;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> implements View.OnClickListener {

    Context context;
    private List<Room> room_list;
        SharedPreferences pref;

    public RoomAdapter(Context context, List<Room> room_list) {
        this.context = context;
        this.room_list = room_list;
    }

    public void setRoom_list(List<Room> room_list) {
        this.room_list = room_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roomslist, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.roomno.setText(room_list.get(position).getRoomno());
        holder.price.setText(room_list.get(position).getPrice());


//        if(room_list.get(position).getImg() != null && room_list.get(position).getImg().length()>0)
//        {
//            Picasso.get().load(BASE_URL+"/Uploads/"+updates_list.get(position).getImage()).
//                    placeholder(R.drawable.user_login).into(holder.image);
//        }else {
//
//            Picasso.get().load(R.drawable.user_login).into(holder.image);
//        }

//        holder.share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Shared from ChildCareKenya. (www.chidcarekenya.com). Please Help");
//                intent.putExtra(Intent.EXTRA_TEXT, "Shared from ChildCareKenya App. (www.childcarekenya.com) " +"\n"+
//                        updates_list.get(position).getTitle() + "\n" +
//                        "Please Help"+"  "+ updates_list.get(position).getChildname()+". " +"\n"+ updates_list.get(position).
//                        getDescription());
//
//                intent.setType("text/plain");
//                context.startActivity(Intent.createChooser(intent, "Share Via"));
//
//            }
//        });
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Room thisRoom = room_list.get(position);

                String[] room = {
                        thisRoom.getRname(),
                        thisRoom.getRoomno(),
                        thisRoom.getSpaces(),
                        thisRoom.getPrice(),
                        thisRoom.getImg()
                };

                openRoomDetail(room);



                };


        });


    }
    public void openRoomDetail(String[] data){

        pref = context.getSharedPreferences("roomdata", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.ROOMNAME,data[0]);
        editor.putString(Constants.ROOMNO,data[1]);
        editor.putString(Constants.SPACES,data[2]);
        editor.putString(Constants.PRICE,data[3]);
        editor.putString(Constants.IMAGE,data[4]);
        editor.apply();
        Intent intent = new Intent(context,RoomActivity.class);
        context.startActivity(intent);

    }


    @Override
    public int getItemCount() {
        if (room_list != null) {
            return room_list.size();
        }
        Toast.makeText(context, "No rooms yet", Toast.LENGTH_SHORT).show();
        return 0;
    }

    @Override
    public void onClick(View v) {


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView  roomno;
        TextView price;
        ImageView image;
        LinearLayout parentLayout;



        ViewHolder(@NonNull View itemView) {
            super(itemView);

            roomno = itemView.findViewById(R.id.roomno);
            price = itemView.findViewById(R.id.price);

            image = itemView.findViewById(R.id.thumbnail);
            parentLayout = itemView.findViewById(R.id.parent_layout);




        }


    }

}
