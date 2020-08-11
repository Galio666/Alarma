package mx.edu.uacm.alarma.control;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import mx.edu.uacm.alarma.R;

public class resgistro extends AppCompatActivity {

    private Button btnQr;

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);
        btnQr =findViewById(R.id.btnqr);
        txt=findViewById(R.id.txtPost);
        btnQr.setOnClickListener(mOnClickListener);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result;
        result=IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
            if (result.getContents() != null){
                txt.setText(result.getContents());
            }else{
                txt.setText("Error al escanear el código qr");
            }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnqr:
                    new IntentIntegrator(resgistro.this).setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES).setBarcodeImageEnabled(true).setBeepEnabled(false).setPrompt("Coloca el codigo de tu credencial dentro del recuadro").initiateScan();


                    break;


            }
        }
    };
}
