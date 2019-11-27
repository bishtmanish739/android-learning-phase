package in.technicalkeeda.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.mylistview);
        ArrayList<String> grocery = new ArrayList<>();
        grocery.add("Bhindi");
        grocery.add("Pen");
        grocery.add("Apples");
        grocery.add("Tea Leaves");
        grocery.add("Bhindi");
        grocery.add("Pen");
        grocery.add("Apples");
        grocery.add("Tea Leaves");
        grocery.add("Bhindi");
        grocery.add("Pen");
        grocery.add("Apples");
        grocery.add("Tea Leaves");
        grocery.add("Bhindi");
        grocery.add("Pen");
        grocery.add("Apples");
        grocery.add("Tea Leaves");
        grocery.add("Bhindi");
        grocery.add("Pen");
        grocery.add("Apples");
        grocery.add("Tea Leaves");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grocery);
        myListView.setAdapter(arrayAdapter);

       /* myListView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });*/

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                intent = new Intent(MainActivity.this,newActivity.class);
                intent.putExtra("hindi","english english english english");
                startActivity(intent);

            }
        });




    }
}

