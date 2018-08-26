package error404.tutorpoints;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInAsTeacher extends AppCompatActivity {

    DatabaseHelper db;
    EditText email,password;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_as_teacher);

        db=new DatabaseHelper(this);
        email= (EditText) findViewById(R.id.loginEmailET);
        password= (EditText) findViewById(R.id.loginPasswordET);
        btnLogin= (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText=email.getText().toString();
                String passwordText=password.getText().toString();

                Boolean checkEmailPassword=db.isEmailAndPasswordMatch(emailText,passwordText);
                if(checkEmailPassword==true){
                    Toast.makeText(getApplicationContext(),"Login successfull",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Invalid login",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
