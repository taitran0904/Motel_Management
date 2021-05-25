package com.example.motelmanagement.View;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.motelmanagement.R;

public class Splash extends AppCompatActivity {
    public static final String DATABASE_NAME = "Motel.db";
    SQLiteDatabase DB;
    private static final String USER = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,username TEXT NOT NULL,password TEXT NOT NULL, email TEXT NOT NULL, phone TEXT NOT NULL)";
    private static final String ROOM = "CREATE TABLE room ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, room_name VARCHAR(20) NOT NULL, deposit MONEY NOT NULL, electric_num INTEGER NOT NULL, water_num INTEGER NOT NULL, status bit NOT NULL, id_user INTEGER NOT NULL)";
    private static final String RENTER = "CREATE TABLE renter ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name NVARCHAR(50) NOT NULL, sex bit NOT NULL, birthday NVARCHAR(20) NOT NULL, cmnd VARCHAR(20) NOT NULL, phone VARCHAR(12) NOT NULL, dayofhide NVARCHAR(20) NOT NULL, id_room INTEGER NOT NULL, id_user INTEGER NOT NULL)";
    private static final String PRICE = "CREATE TABLE price ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, electric MONEY NOT NULL, water MONEY NOT NULL, id_user INTEGER NOT NULL)";
    private static final String BILL = "CREATE TABLE bill ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, room_charge TEXT NOT NULL, electric_money TEXT NOT NULL, water_money TEXT NOT NULL, internet TEXT NOT NULL, other TEXT, reason TEXT, invoice_date TEXT NOT NULL, status TEXT NOT NULL, id_room INTEGER NOT NULL, total TEXT NOT NULL, electric_num TEXT NOT NULL, water_num TEXT NOT NULL, id_user INTEGER NOT NULL, FOREIGN KEY(id_user) REFERENCES user (id), FOREIGN KEY(id_room) REFERENCES room(id))";

    TextView app_name;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initDB();
        app_name =  findViewById(R.id.app_name);
        lottieAnimationView = findViewById(R.id.lottie);

        app_name.animate().translationY(0).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(0).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        },4000);
    }

    public void initDB(){
        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        try {
            if (!isTableExists(DB, "user")) {
                DB.execSQL(USER);
                String s;
                s = "insert into user(username, password, email, phone) values('admin','admin', 'admin@gmail.com', '0987654321')";
                DB.execSQL(s);
            }
            if (!isTableExists(DB, "room")) {
                DB.execSQL(ROOM);
            }
            if (!isTableExists(DB, "renter")) {
                DB.execSQL(RENTER);
            }
            if (!isTableExists(DB, "price")) {
                DB.execSQL(PRICE);
            }
            if (!isTableExists(DB, "bill")) {
                DB.execSQL(BILL);
            }
        }
        catch (Exception ex){
            Toast.makeText(this, "Khởi tạo dữ liệu không thành công", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isTableExists(SQLiteDatabase DB, String tableName){
        Cursor cursor = DB.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name " + "= '"+ tableName + "'", null);
        if(cursor!=null){
            if(cursor.getCount()>0){
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

}