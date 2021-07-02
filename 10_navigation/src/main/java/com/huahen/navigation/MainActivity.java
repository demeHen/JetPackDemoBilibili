package com.huahen.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huahen.navigation.basicJump.BasicJumpActivity;
import com.huahen.navigation.deepLink.DeepLinkActivity;
import com.huahen.navigation.navui.NavUiActivity;
import com.huahen.navigation.safeArgs.SafeArgsActivity;
import com.huahen.navigation.viewModel.ViewModelActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, BasicJumpActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, SafeArgsActivity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(MainActivity.this, NavUiActivity.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(MainActivity.this, DeepLinkActivity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
                break;
            default:
                Toast.makeText(this, "未设置的事件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
