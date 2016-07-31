package com.hitarthi.toastmessages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.steamcrafted.loadtoast.LoadToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "This is Toast 1", Toast.LENGTH_LONG).show();
    }

    public void toast_show(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.toast2:
            {
                int moveToastRight  = 100;
                int moveToastDown = 100;
                Toast toast = Toast.makeText(MainActivity.this, "Another Toast2", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, moveToastRight, moveToastDown);
                toast.show();
                break;
            }
            case R.id.toast3:
            {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
                Toast toast = Toast.makeText(MainActivity.this,"Hello From Toast3",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(layout);
                toast.show();
                break;
            }
            case R.id.toast4:
            {
                Toast toast = Toast.makeText(this, "I am custom Toast 4!", Toast.LENGTH_LONG);
                View toastView = toast.getView();
                TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
                toastMessage.setTextSize(25);
                toastMessage.setTextColor(Color.RED);
                toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0);
                toastMessage.setGravity(Gravity.CENTER);
                toastMessage.setCompoundDrawablePadding(16);
                toastView.setBackgroundColor(Color.CYAN);
                toast.show();
                break;
            }
            case R.id.toast5:
            {
                LoadToast lt = new LoadToast(this);
                lt.setText("Sending Reply...");
                lt.show();
                lt.setTextColor(Color.RED).setBackgroundColor(Color.BLACK).setProgressColor(Color.BLUE);
                break;
            }
        }
    }

}
