package br.com.digitalhouse.componentesmaterialdesign.login;

import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.componentesmaterialdesign.R;
import br.com.digitalhouse.componentesmaterialdesign.home.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputlayoutPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                validateAndGoToHome();
            }
        });


    }

    private void validateAndGoToHome() {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputlayoutPassword.getEditText().getText().toString();

        if(email.isEmpty()){
            textInputLayoutEmail.setError("Email não pode ser vazio");
            return;
        }

        if(email.isEmpty()){
            textInputlayoutPassword.setError("Password não pode ser vazio");
            return;
        }

        if (email.equals("tairo@digitalhouse.com")  && password.equals("123")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("NAME","Tairo");

            intent.putExtras(bundle);

            startActivity(intent);
        }else{
            Snackbar.make(textInputLayoutEmail,"Email ou senha invalidos",Snackbar.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputlayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
