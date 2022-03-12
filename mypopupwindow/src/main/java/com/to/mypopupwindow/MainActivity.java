package com.to.mypopupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gaoxClick(View view) {
        View popuppView = getLayoutInflater().inflate(R.layout.popup_view, null);
        Button bnt1 = popuppView.findViewById(R.id.btn1);
        Button bnt2 = popuppView.findViewById(R.id.btn2);
        PopupWindow popupWindow = new PopupWindow(popuppView, ViewGroup.LayoutParams.WRAP_CONTENT
                ,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.showAsDropDown(view,view.getWidth(),view.getHeight());
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("hahahaha","onvlick: 你是住在上海吗？");
                //关闭
                popupWindow.dismiss();
            }
        });
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("hahahaha","onvlick: 你是住在广州吗？");
                popupWindow.dismiss();
            }
        });
    }
}