package com.example.cepexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText cepEditText;
    private Button consultarButton;
    private TextView enderecoTextView;
    private TextView bairroTextView;
    private TextView estadoTextView;
    private TextView ufTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cepEditText = findViewById(R.id.cepEditText);
        consultarButton = findViewById(R.id.consultarButton);
        enderecoTextView = findViewById(R.id.enderecoTextView);
        bairroTextView = findViewById(R.id.bairroTextView);
        estadoTextView = findViewById(R.id.estadoTextView);
        ufTextView = findViewById(R.id.ufTextView);

        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarCEP();
            }
        });

        Button buttonStart = findViewById(R.id.exit_button);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void consultarCEP() {
        String cep = cepEditText.getText().toString();

        if (cep.isEmpty()) {
            Toast.makeText(this, "Por favor, digite um CEP válido.", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String endereco = response.getString("logradouro");
                            String bairro = response.getString("bairro");
                            String estado = response.getString("localidade");
                            String uf = response.getString("uf");

                            enderecoTextView.setText(endereco);
                            bairroTextView.setText(bairro);
                            estadoTextView.setText(estado);
                            ufTextView.setText(uf);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Erro ao processar resposta da API.", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Erro na requisição. Verifique sua conexão ou tente novamente mais tarde.", Toast.LENGTH_SHORT).show();
                    }
                });
        Volley.newRequestQueue(this).add(request);
    }
}
