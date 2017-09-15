package com.example.admin.duihuakuang;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.LoginFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        et1 = (EditText)findViewById(R.id.accout);
        et2 = (EditText)findViewById(R.id.password);

        switch(v.getId()){

            case R.id.quit:
                Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("确定退出？");//对话框标题
                dialog.setMessage("您确定退出吗？");//对话框内容
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.create();
                dialog.show();
                break;
            case R.id.login:
                if(et1.getText().toString().equalsIgnoreCase("abc")  && et2.getText().toString().equalsIgnoreCase("123") ){
                    Toast.makeText(this,"登陆成功" ,Toast.LENGTH_SHORT).show();
                    break;
                }
                else{
                    Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
                }
                break;

            }
        }
    }

