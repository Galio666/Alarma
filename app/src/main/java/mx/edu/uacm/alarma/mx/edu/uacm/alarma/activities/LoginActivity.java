package mx.edu.uacm.alarma.mx.edu.uacm.alarma.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.uacm.alarma.R;
import mx.edu.uacm.alarma.control.SessionManagement;
import mx.edu.uacm.alarma.mx.edu.uacm.alarma.api.PostService;
import mx.edu.uacm.alarma.model.Login;
import mx.edu.uacm.alarma.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText usuario;
    EditText password;
    private PostService postService;
    String accesToken="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=findViewById(R.id.txtUserName);
        password=findViewById(R.id.txtPassword);
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarSesion();
    }

    private void userLogin() {
        Login loginResponse = new Login();
        loginResponse.setPassword(password.getText().toString());
        loginResponse.setUsername(usuario.getText().toString());

        Call<User> call = postService.sendPostLogin(loginResponse);

        call.enqueue(new Callback<User>() {
            @Override   // este metodo es para mostrarle al usuario que la operacion se realizo con exito
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body().toString());
            }

            @Override// muestra el error
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Error Usuario o contraseña",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void postRequest(){

        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://incidencias-servicio-backend.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService= retrofit.create(PostService.class);
            userLogin();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void verificarSesion(){
        //Veridica si el usuario esta logueado
        //Si el usuario esta logueado ->Entra a la actividad principal

        SessionManagement sessionManagement=new SessionManagement(LoginActivity.this);
        String userName=sessionManagement.getSession();

        if (userName != ""){
            Intent intent=new Intent(LoginActivity.this,SesionAbierta.class);
            intent.putExtra("TOKEN", accesToken);
            //System.out.println( "Token:"+accesToken);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else {
            //No se hace nada
        }
    }
}
