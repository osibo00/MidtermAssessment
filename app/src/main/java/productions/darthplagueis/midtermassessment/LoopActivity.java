package productions.darthplagueis.midtermassessment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        textView = (TextView) findViewById(R.id.loop_textview);

        Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
        startActivity(intent);

//        MyTask myTask = new MyTask();
//        int initialize = 0;
//        myTask.execute(initialize);
    }

    private class MyTask extends AsyncTask<Integer, Integer, Integer> {


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Integer doInBackground(Integer[] values) {

            while(values[0] <= 100000) {
                publishProgress();
            }
            return values[0];
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            textView.setText("Loops completed: " + progress.toString());
            Log.d("loop", "progressupdate");
        }

        @Override
        protected void onPostExecute(Integer result) {
            textView.setText("Loops completeddd: " + result.toString());
            Log.d("loop", "postexecute");
            Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    }
}
