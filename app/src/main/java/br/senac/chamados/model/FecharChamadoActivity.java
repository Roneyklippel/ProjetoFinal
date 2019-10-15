package br.senac.chamados.model;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.senac.chamados.R;
import br.senac.chamados.TabsActivity;
import br.senac.chamados.api.APIService;
import br.senac.chamados.api.ApiUtils;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class FecharChamadoActivity extends AppCompatActivity {

    private APIService mAPIService;
    private TextView mResponseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_solucao);

        final EditText edtMensagem = (EditText) findViewById(R.id.descricao);
        final EditText edtMensagem2 = (EditText) findViewById(R.id.solucao);
        Button btnEnviarMensagem = (Button) findViewById(R.id.buttonSave);

        mAPIService = ApiUtils.getService();

        btnEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {

                String mensagem = edtMensagem.getText().toString().trim();
                String mensagem2 = edtMensagem2.getText().toString().trim();
                Chamado chamado = new Chamado();
                chamado.setDescricao(mensagem);
                chamado.setSolucao(mensagem2);

                if (!TextUtils.isEmpty(mensagem)) {
                    enviarMensagem(chamado, getApplicationContext());
                }


            }
        });



        mAPIService = ApiUtils.getService();


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void enviarMensagem(Chamado chamado, final Context context) {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date dataAbertura = new Date();
        mAPIService = ApiUtils.getService();

        Map<String, String> jsonParams = new ArrayMap<>();
        jsonParams.put("descricao", chamado.getDescricao());
        jsonParams.put("dataAbertura", sdf.format(dataAbertura.getTime()));
        jsonParams.put("status", Status.FECHADO.toString());
        jsonParams.put("solucao",chamado.getSolucao());




        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<ResponseBody> response = mAPIService.salvarMensagem(body);

        response.enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse)
            {
                try
                {
                    Toast.makeText(context, "Chamado enviado com sucesso!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FecharChamadoActivity.this, TabsActivity.class);
                    startActivity(intent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable)
            {
                Toast.makeText(context, "O Envio do Chamado falhou!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}