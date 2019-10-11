package br.senac.chamados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.gson.Gson;



import br.senac.chamados.api.LoginTask;
import br.senac.chamados.api.OnEventListener;
import br.senac.chamados.model.Login;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnlogar);
        final EditText viewlogin = (EditText) findViewById(R.id.textlogin);
        final EditText viewsenha = (EditText) findViewById(R.id.textsenha);


        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {


                final String txtlogin = viewlogin.getText().toString();
                final String txtsenha = viewsenha.getText().toString();


                Intent intent = new Intent(MainActivity.this, TabsActivity.class);
                startActivity(intent);

//                final LoginTask loginTask = new LoginTask(getApplicationContext(), new OnEventListener<String>() {
//
//                    @Override
//                    public void onSuccess(String result) {
//                        Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_LONG).show();
//                        Gson gson = new Gson();
//                        Login[] logins = gson.fromJson(result, Login[].class);
//
//                        for (Login login : logins) {
//                            if (login.getLogin().toLowerCase().equals(txtlogin) && login.getPassword().toLowerCase().equals(txtsenha)) {
//
//
//                            }
//                        }
//
//                    }
//
//                    public void onFailure(Exception e) {
//                        Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//
//                loginTask.execute();
            }
        });
    }
}