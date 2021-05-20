package com.example.motelmanagement.View;

import android.content.ContentValues;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.motelmanagement.R;

public class SignUpActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "Motel.db";
    SQLiteDatabase DB;
    EditText edtPass, edtConPass, edtUserName, edtEmail, edtPhone;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPass =  findViewById(R.id.edtPass);
        edtConPass =  findViewById(R.id.edtConPass);
        edtUserName =  findViewById(R.id.edtUserName);
        edtEmail =  findViewById(R.id.edtEmail);
        edtPhone =  findViewById(R.id.edtPhone);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(v -> {
            String userName = edtUserName.getText().toString();
            String pass = edtPass.getText().toString();
            String cpass = edtConPass.getText().toString();
            String email = edtEmail.getText().toString();
            String phone = edtPhone.getText().toString();

            createUser(userName, pass, cpass, email, phone);
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
    public void ShowHideConPass(View view){

        if(view.getId()== R.id.imgConEye){

            if(edtConPass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_off_24);

                //Show Password
                edtConPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_24);
                //Hide Password
                edtConPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    private void createUser(String userName, String pass, String cPass, String email, String phone){
        DB = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        if(userName.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập tên tài khoản", Toast.LENGTH_SHORT).show();
            edtUserName.requestFocus();
        }
        else
        if(email.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập email", Toast.LENGTH_SHORT).show();
            edtEmail.requestFocus();
        }
        else
        if(phone.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
            edtPhone.requestFocus();
        }
        else
        if(pass.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
            edtPass.requestFocus();
        }
        else
        if(cPass.isEmpty()){
            Toast.makeText(this, "Xin vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
            edtConPass.requestFocus();
        }
        else
        if(!pass.equals(cPass)){
            Toast.makeText(this, "Nhập lại mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
            edtPass.setText("");
            edtConPass.setText("");
            edtPass.requestFocus();
        }
        else
        if(!isUserExists(userName)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("username",userName);
            contentValues.put("password",pass);
            contentValues.put("email",email);
            contentValues.put("phone",phone);
            DB.insert("user", null, contentValues);
            Toast.makeText(this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private boolean isUserExists(String userName){
        Cursor cursor = DB.rawQuery("select * from user where username = ?", new String[]{userName});
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