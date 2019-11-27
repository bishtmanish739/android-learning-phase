package in.technicalkeeda.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class newActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent=getIntent();
        String s=intent.getStringExtra("hindi");
        TextView textView=findViewById(R.id.textView);
        textView.setText(s);
    }
}
