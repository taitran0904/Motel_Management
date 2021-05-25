package com.example.motelmanagement.View;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.motelmanagement.Action.AddNewRoom;
import com.example.motelmanagement.Adapter.RoomAdapter;
import com.example.motelmanagement.Model.Room;
import com.example.motelmanagement.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "Motel.db";
    SQLiteDatabase DB;
    GridView grvRoom;
    ArrayList<Room> listRoom = new ArrayList<>();
    RoomAdapter roomAdapter;
    int idRoom = -1;
    int position = 0;
    TextView txtNone;
    BottomNavigationView bottomNavigationView;
    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grvRoom = findViewById(R.id.gridViewRoom);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        topAppBar = findViewById(R.id.topAppBar);
        int idUser = getIntent().getIntExtra("ID_USER", 0);
        Toast.makeText(this, idUser+"", Toast.LENGTH_LONG).show();
        readData(idUser);

        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.app_bar_filer:
                        return true;
                    case R.id.app_bar_search:
                        return true;
                    case R.id.app_bar_add:
                        Intent intent = new Intent(MainActivity.this, AddNewRoom.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("ID_USER", idUser);
                        startActivity(intent);
                }
                return false;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.notification:
                    startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.home:
                    return true;
                case R.id.user:
                    startActivity(new Intent(getApplicationContext(), UserActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

    private void readData(int idUser) {

        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        Cursor cursor = DB.rawQuery("select * from room where id_user = ?", new String[]{idUser+""});
//        listRoom.clear();
        if(cursor.getCount() < 1){
            grvRoom.setVisibility(View.INVISIBLE);
        }
        else {
            grvRoom.setVisibility(View.VISIBLE);
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                int idRoom = cursor.getInt(0);
                String roomName = cursor.getString(1);
                String deposit = cursor.getString(2);
                int electricNum = cursor.getInt(3);
                int waterNum = cursor.getInt(4);
                String status = cursor.getString(5);
//            int id_User = cursor.getInt(6);
                listRoom.add(new Room(idRoom, roomName, deposit, electricNum, waterNum, status, idUser));
            }
//        roomAdapter.notifyDataSetChanged();

            roomAdapter = new RoomAdapter(this, android.R.layout.simple_list_item_1, listRoom);
            grvRoom.setAdapter(roomAdapter);
        }
    }
}