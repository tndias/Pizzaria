package br.com.psoa.hungry4pizza;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout userName;

    @BindView(R.id.password)
    TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        userName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaUsuario();

            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaSenha();

            }
        });
    }

    private boolean validaUsuario() {
        if (userName.getEditText().getText().toString().isEmpty()) {
            userName.setError("Login não informado");
            return false;
        } else {
            userName.setError(null);
        }
        return true;
    }

    private boolean validaSenha() {
        if (password.getEditText().getText().toString().isEmpty()) {
            password.setError("Senha não informada");
            return false;
        } else {
            password.setError(null);

        }
        return  true;
    }

    @OnClick(R.id.btConectar)
    public void conectar () {
        if(validaUsuario() && validaSenha()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("USERNAME", userName.getEditText().getText().toString());
            startActivity(intent);
        }
    }
}
