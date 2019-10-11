package br.senac.chamados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class TabsActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChamadosAbertos(),"Chamados Abertos");
        adapter.addFragment(new ChamadosFechados(),"Chamados Fechados");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Button btnNovaMensagem = (Button) findViewById(R.id.btn_nova_mensagem);

        btnNovaMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TabsActivity.this, NovaMensagemActivity.class);
                startActivity(intent);
            }
        });
    }

}
