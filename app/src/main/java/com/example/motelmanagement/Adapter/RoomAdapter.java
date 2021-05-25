package com.example.motelmanagement.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.motelmanagement.Model.Room;
import com.example.motelmanagement.R;
import com.example.motelmanagement.View.MainActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static com.example.motelmanagement.R.drawable.home_color;

public class RoomAdapter extends ArrayAdapter<Room> {
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    ArrayList<Room> listRoom = new ArrayList<>();

    public RoomAdapter( Context context, int resource, ArrayList<Room> object) {
        super(context, resource, object);
        listRoom = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.room, null);

        TextView txtHome = row.findViewById(R.id.txtHome);
        TextView txtRoomName = row.findViewById(R.id.txtRoomName);
        TextView txtDesposit = row.findViewById(R.id.txtDeposit);
        TextView txtStatus = row.findViewById(R.id.txtStatus);
        Button btnRoomChange = row.findViewById(R.id.btnRoomChange);
        Button btnRoomDelete = row.findViewById(R.id.btnRoomDelete);

        Room room = listRoom.get(position);

        txtRoomName.setText(room.getRoomName());
        long desposit = Long.valueOf(room.getDeposit());
        txtDesposit.setText(currencyVN.format(desposit));

        if(room.getStatus().equals("1")){
            txtStatus.setText("Đã thuê");
            txtHome.setBackgroundResource(home_color);
        }
        else {
            txtStatus.setText("Phòng trống");
            txtHome.setBackgroundResource(home_color);
        }
        return row;
    }
}
