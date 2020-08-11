package mx.edu.uacm.alarma.mx.edu.uacm.alarma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.uacm.alarma.R;
import mx.edu.uacm.alarma.control.resgistro;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar;
    private Button btn2;
    private TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 16) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        btn2=findViewById(R.id.btn);
        btnRegistrar=findViewById(R.id.btn2);
        btn2.setOnClickListener(mOnClickListener);
        btnRegistrar.setOnClickListener(mOnClickListener);
    }




    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                    case R.id.btn:
                        Intent intent = new Intent (v.getContext(), resgistro.class);
                        startActivityForResult(intent, 0);

                    case  R.id.btn2:
                         Intent intent2=new Intent(v.getContext(),LoginActivity.class);
                         startActivityForResult(intent2, 0);
            }
        }
    };
}
