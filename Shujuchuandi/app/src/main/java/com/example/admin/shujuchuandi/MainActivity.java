package com.example.admin.shujuchuandi;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvanother=null;
    private Button btnopen=null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvanother=(TextView)super.findViewById(R.id.another);
        btnopen=(Button)super.findViewById(R.id.open);


        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("result","1+1=?");
                MainActivity.this.startActivityForResult(intent,1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (resultCode){
            case RESULT_OK:
                super.onActivityResult(requestCode,resultCode,data);
                Bundle bundle =data.getExtras();
                String sum=bundle.getString("1+1=?");
                tvanother.setText(sum);
        }
    }

}
