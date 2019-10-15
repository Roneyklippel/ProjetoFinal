package br.senac.chamados;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import br.senac.chamados.api.ChamadoTask;
import br.senac.chamados.api.OnEventListener;
import br.senac.chamados.model.Chamado;

public class ChamadosAbertos extends Fragment {

    ListView listaMensagensChamadosAbertos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View viewFragment = inflater.inflate(R.layout.fragment_one, container, false);

        final FloatingActionButton btnAtualizar = (FloatingActionButton) viewFragment.findViewById(R.id.btn_atualizar);

        atualizaListaMensagens(viewFragment);

        btnAtualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                atualizaListaMensagens(viewFragment);

            }
        });


        return viewFragment;
    }

    private void atualizaListaMensagens(final View viewMetodo) {

        ChamadoTask chamadoTask = new ChamadoTask(viewMetodo.getContext(), new OnEventListener<String>() {
            final List<Chamado> novaListaDeChamados = new ArrayList<Chamado>();

            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();

                Chamado[] chamados = gson.fromJson(result, Chamado[].class);

                for (Chamado chamado : chamados) {
                    if (chamado.getStatus() != null) {
                        if (chamado.getStatus().toString().equals("ABERTO")) {
                            novaListaDeChamados.add(chamado);

                        }
                    }
                }
                ArrayAdapter<Chamado> adapter = new ArrayAdapter<Chamado>(getActivity(), android.R.layout.simple_list_item_1, novaListaDeChamados);

                listaMensagensChamadosAbertos = (ListView) viewMetodo.findViewById(R.id.lista_mensagens_enviadas);
                listaMensagensChamadosAbertos.setAdapter(adapter);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(viewMetodo.getContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        chamadoTask.execute();
    }
}