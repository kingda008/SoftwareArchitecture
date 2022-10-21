package com.baoge.kj01_butterknife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt)
    TextView txt;

    @BindView(R.id.btn1)
    Button btn1;

    @BindString(R.string.doint)
    String doit;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);


    }

    @OnClick(R.id.btn1)
    void doOnclick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                txt.setText(doit);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
