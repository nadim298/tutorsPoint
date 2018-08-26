package error404.tutorpoints;

import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpAsTeacher extends AppCompatActivity {

    DatabaseHelper db;
    EditText email,password,confirm_password;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_as_teacher);

        db=new DatabaseHelper(this);
        email= (EditText) findViewById(R.id.emailET);
        password= (EditText) findViewById(R.id.passwordET);
        confirm_password= (EditText) findViewById(R.id.confirmPasswordET);
        btnRegister= (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText=email.getText().toString();
                String passwordText=password.getText().toString();
                String confirmPasswordText=confirm_password.getText().toString();

                if(emailText.equals("")||passwordText.equals("")||confirmPasswordText.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(passwordText.equals(confirmPasswordText)){
                        Boolean isEmailExists=db.isEmailExists(emailText);
                        if(isEmailExists==true){
                            Boolean insert=db.insert(emailText,passwordText);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Succesfull",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else Toast.makeText(getApplicationContext(),"Email is already exists",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
