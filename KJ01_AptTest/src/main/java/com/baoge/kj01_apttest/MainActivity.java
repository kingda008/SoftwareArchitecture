package com.baoge.kj01_apttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.baoge.kj01_annotation.BindView;
import com.baoge.kj01_libapt.Apt;
import com.baoge.kj01_libapt.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt)
    TextView txt;

    @BindView(R.id.btn1)
    Button btn1;
    Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder= Apt.bind(this);
        txt.setText("text");
        btn1.setText("btn");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
