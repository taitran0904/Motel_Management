package com.example.motelmanagement.View;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motelmanagement.R;

public class LoginActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "Motel.db";
    SQLiteDatabase DB;
    Button btnLogin;
    EditText edtUserName,edtPass;
    TextView txtDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin =  findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPass);
        edtUserName =  findViewById(R.id.edtUserName);
        txtDK =  findViewById(R.id.txtDK);

        btnLogin.setOnClickListener(v -> {
            Login(edtUserName.getText().toString(), edtPass.getText().toString());
        });
        txtDK.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
    public void ShowHidePass(View view){

        if(view.getId()== R.id.imgEye){

            if(edtPass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_off_24);

                //Show Password
                edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);
                //Hide Password
                edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }
    }

    private void Login(String userName, String pass){
        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        if(userName.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập tên tài khoản", Toast.LENGTH_SHORT).show();
            edtUserName.requestFocus();
        }
        else
        if(pass.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
            edtPass.requestFocus();
        }
        else {
            Cursor cursor = DB.rawQuery("select * from user where username = ?  and password = ?", new String[]{userName, pass});
            if (cursor.getCount() < 1)
                Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không chính xác !!!", Toast.LENGTH_SHORT).show();
            else {
                cursor.moveToPosition(0);
                int idUser = cursor.getInt(0);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("ID_USER", idUser);
                startActivity(intent);
            }
            cursor.close();
        }
    }
}