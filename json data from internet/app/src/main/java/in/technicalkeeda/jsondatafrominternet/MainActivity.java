package in.technicalkeeda.jsondatafrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    public class  downloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            URL url;
            HttpsURLConnection urlConnection =null;
            try {
                url=new URL(strings[0]);
                urlConnection=(HttpsURLConnection)url.openConnection();
                InputStream inputStream= urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int data=reader.read();
                while (data!=-1){
                    char character=(char)data;
                    result+=character;
                    data=reader.read();

                }
                return  result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.i("this is msg",result);
            //TextView textView=findViewById(R.id.textview);
           // textView.setText(result);
        }
    }

    public  void btn(View view){
        downloadTask downloadTask=new downloadTask();

        try {
            downloadTask.execute("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2012-01-01&endtime=2012-12-01&minmagnitude=6").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
