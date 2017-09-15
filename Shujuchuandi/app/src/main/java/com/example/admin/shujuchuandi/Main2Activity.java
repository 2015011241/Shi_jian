package com.example.admin.shujuchuandi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tvresult=null;
    private Button btnback=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvresult = (TextView)super.findViewById(R.id.result);
        btnback = (Button)super.findViewById(R.id.back);

        Intent intent=super.getIntent();
        String url=intent.getStringExtra("result");
        tvresult.setText(url);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("1+1=?","2");
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtras(bundle);
                Main2Activity.this.setResult(RESULT_OK,intent);
                Main2Activity.this.finish();

            }
        });



    }


}
