package error404.tutorpoints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_in_as_teacher:
                Intent sign_in_as_teacher_page=new Intent(this,SignInAsTeacher.class);
                startActivity(sign_in_as_teacher_page);
                break;
            case R.id.sign_up_as_teacher:
                Intent sign_up_as_teacher_page=new Intent(this,SignUpAsTeacher.class);
                startActivity(sign_up_as_teacher_page);
                break;
            case R.id.post_for_tution:
                break;
            case R.id.about_us:
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
