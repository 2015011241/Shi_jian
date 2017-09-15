package com.example.admin.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnmain = null;
    private TextView tvtga = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmain=(Button)super.findViewById(R.id.main);
        tvtga=(TextView)super.findViewById(R.id.tga);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message tga){
                tvtga.setText(tga.arg1+"");
            }
        };
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress<=100){
                    Message tga = new Message();
                    tga.arg1=progress;
                    handler.sendMessage(tga);
                    progress+=10;
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Message tga= handler.obtainMessage();
                tga.arg1=-1;
                handler.sendMessage(tga);
            }
        };
        btnmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread workThread = new Thread(null,runnable,"Workthread");
                workThread.start();
            }
        });
        }
}
