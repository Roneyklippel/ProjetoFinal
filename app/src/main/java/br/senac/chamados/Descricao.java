package br.senac.chamados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Descricao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        final EditText descricao = (EditText) findViewById(R.id.descricao);
        Button bntSave =(Button) findViewById(R.id.buttonSave);
       final String des = descricao.getText().toString();

        bntSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Descricao.this ,ChamadosAbertos.class );
                i.putExtra("newDes" , des);
                startActivity(i);
            }
        });
    }
}
