package  com.example.evaluacionintermediamoduloiii.ui.login;

import android.app.Activity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluacionintermediamoduloiii.MainActivity;
import com.example.evaluacionintermediamoduloiii.R;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(TextView)findViewById(R.id.username);
        password=(TextView)findViewById(R.id.password);
        }

    public void login(View vista){
        String nombre= username.getText().toString();
        String contras= password.getText().toString();

        if (nombre.equals("usuario@correo.com") && contras.equals("123")){
            Intent entrar = new Intent(this, MainActivity.class);
            startActivity(entrar);

         }else {
            Toast.makeText(this,"Datos ingresados incorrectos",Toast.LENGTH_LONG).show();
        }


    }




}