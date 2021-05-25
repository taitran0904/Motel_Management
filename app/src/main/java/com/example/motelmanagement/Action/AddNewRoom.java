package com.example.motelmanagement.Action;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.motelmanagement.R;
import com.example.motelmanagement.View.MainActivity;

import java.util.ArrayList;

public class AddNewRoom extends AppCompatActivity {
    public static final String DATABASE_NAME = "Motel.db";
    SQLiteDatabase DB;
    EditText edtRoomName, edtDesposit, edtElectricNum, edtWaterNum;
    Spinner spnStatus;
    Button btnRoomAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_room);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtRoomName = findViewById(R.id.edtRoomName);
        edtDesposit = findViewById(R.id.edtDesposit);
        edtElectricNum = findViewById(R.id.edtElectricNum);
        edtWaterNum = findViewById(R.id.edtWaterNum);
        spnStatus = findViewById(R.id.spnStatus);
        btnRoomAdd = findViewById(R.id.btnRoomAdd);

        ArrayList<String> arrStatus = new ArrayList<>();
        arrStatus.add("Phòng trống");
        arrStatus.add("Đã thuê");
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,arrStatus);
        spnStatus.setAdapter(arrayAdapter);
        int idUser = getIntent().getIntExtra("ID_USER", 0);
        Toast.makeText(this, idUser+"", Toast.LENGTH_LONG).show();

        btnRoomAdd.setOnClickListener(v -> Add(idUser));
    }

    private void Add(int idUser){
        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        String roomName = edtRoomName.getText().toString();
        String desposit = edtDesposit.getText().toString();
        String electricNum = edtElectricNum.getText().toString();
        String waterNum = edtWaterNum.getText().toString();
        String status = spnStatus.getSelectedItem().toString();

        ContentValues contentValues = new ContentValues();

//        Cursor cursor = DB.rawQuery("select * from room",null);
//        do
//        {
//            cursor.moveToNext();
//            if(cursor.getString(1).equals(roomName))
//            {
//                roomName = roomName+"(1)";
//            }
//        }while(cursor.getString(1).equals(roomName));
        contentValues.put("room_name",roomName);
        contentValues.put("deposit",desposit);
        contentValues.put("electric_num",electricNum);
        contentValues.put("water_num",waterNum);
        if(status.equals("Phòng trống"))
        {
            contentValues.put("status",0);
        }
        else
        {
            contentValues.put("status",1);
        }
        contentValues.put("id_user", idUser);

        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        DB.insert("room",null,contentValues);

        Intent intent = new Intent(AddNewRoom.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(AddNewRoom.this, "Thêm phòng thành công", Toast.LENGTH_SHORT).show();
        onPause();
        DB.close();
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}