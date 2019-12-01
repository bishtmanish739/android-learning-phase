package in.technicalkeeda.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    private  String url="https://newsapi.org/v2/top-headlines?country=in&apiKey=7af3c581e44447f79c3b0cece2aba534";
String s1=" ";
    ArrayList<String> grocery = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        downloadTask d=new downloadTask();
        d.execute(url);

        setContentView(R.layout.activity_main);


         myListView = findViewById(R.id.mylistview);



       /* grocery.add("Bhindi");
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
        grocery.add("Tea Leaves");*/

        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grocery);
        myListView.setAdapter(arrayAdapter);*/

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
    public class  downloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            ArrayList<String> myarraylist;
            String urlstring=strings[0];
            HttpsURLConnection httpsURLConnection=null;
            String result="";
            try{
                URL url=new URL(urlstring);
                httpsURLConnection=(HttpsURLConnection)url.openConnection();
                httpsURLConnection.connect();
                InputStream inputStream=httpsURLConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int data=reader.read();
                while(data!=-1){
                    char currentchar=(char)data;
                    result+=currentchar;
                    data=reader.read();
                }
                return  result;

            }
            catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s==""){
                Toast.makeText(MainActivity.this, "No data found please check your internet connection", Toast.LENGTH_SHORT).show();
            }
            else{
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "could not found json object", Toast.LENGTH_SHORT).show();
                }
                s1= null;
                try {
                    s1 = jsonObject.getString("status");
                    grocery.add(s1);
                    grocery.add("masala");
                    grocery.add("shimlamirch");
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, grocery);
                    myListView.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    s1="could no found status string" ;
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, s1+"this is result", Toast.LENGTH_SHORT).show();



            }
        }
    }
}

