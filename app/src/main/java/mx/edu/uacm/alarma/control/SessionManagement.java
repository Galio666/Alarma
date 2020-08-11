package mx.edu.uacm.alarma.control;

import android.content.Context;
import android.content.SharedPreferences;

import mx.edu.uacm.alarma.model.Login;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME="session";
    String KEY_USERNAME="username";
    String KEY_PASSWORD="password";

    public SessionManagement(Context context){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    //Gaurda la session cuando un usario se loguea

    public void saveSession(Login user){

        String usuario=user.getUsername();
        String password=user.getPassword();
        editor.putString(KEY_USERNAME,usuario).putString(KEY_PASSWORD,password).commit();

    }

    //Recupera la session cuando un usuario ya tiene almacenado su sesion
    public String getSession(){

        return sharedPreferences.getString(KEY_USERNAME,"");


    }
}
