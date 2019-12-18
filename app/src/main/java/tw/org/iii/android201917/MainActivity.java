package tw.org.iii.android201917;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyAsyncTask myAsyncTask;
    private TextView name1, name2,name3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
    }

    public void test1(View view) {
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute("Brad","Peter","Tony");

    }

    private class MyAsyncTask extends AsyncTask<String,String,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.v("brad", "onPreExecute");
        }

        @Override
        protected Void doInBackground(String... names) {
            Log.v("brad", "doInBackground");

            for (int i=0; i<names.length; i++){
                publishProgress(""+i, names[i],
                        "" +(int)(Math.random()*49+1));
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            if (values[0].equals("0")){
                name1.setText(values[1] + ":" + values[2]);
            }else if(values[0].equals("1")){
                name2.setText(values[1] + ":" + values[2]);
            }else if(values[0].equals("2")){
                name3.setText(values[1] + ":" + values[2]);
            }

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.v("brad", "onPostExecute");
        }


        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
            Log.v("brad", "onCancelled(xx)");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.v("brad", "onCancelled");
        }

    }

}
