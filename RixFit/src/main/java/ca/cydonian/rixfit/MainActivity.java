package ca.cydonian.rixfit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        GlobalState gs = (GlobalState) getApplication();
        gs.getDatabase().open();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalState gs = (GlobalState) getApplication();
        gs.getDatabase().close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public  class PlaceholderFragment extends Fragment implements View.OnClickListener {
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Button addExercise = (Button)rootView.findViewById(R.id.addExerciseBtn);
            if (addExercise != null)
            {
                addExercise.setOnClickListener(this);
            }
            Button viewExercise = (Button)rootView.findViewById(R.id.viewExercisesBtn);
            if (viewExercise != null)
            {
                viewExercise.setOnClickListener(this);
            }
            Button addWorkout = (Button)rootView.findViewById(R.id.addWorkoutBtn);
            if (addWorkout != null)
            {
                addWorkout.setOnClickListener(this);
            }
            Button viewWorkouts = (Button)rootView.findViewById(R.id.viewWorkoutsBtn);
            if (viewWorkouts != null)
            {
                viewWorkouts.setOnClickListener(this);
            }
            return rootView;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.addExerciseBtn:
                    try
                    {
                        Intent addExercise = new Intent(view.getContext(), AddExercise.class);
                        startActivity(addExercise);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.addWorkoutBtn:
                    try
                    {
                        Intent addWorkouts = new Intent(view.getContext(), AddWorkout.class);
                        startActivity(addWorkouts);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.viewExercisesBtn:
                    try
                    {
                        Intent viewExercises = new Intent(view.getContext(), ExerciseListActivity.class);
                        startActivity(viewExercises);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.viewWorkoutsBtn:
                    try
                    {
                        Intent viewWorkouts = new Intent(view.getContext(), WorkoutListActivity.class);
                        startActivity(viewWorkouts);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

}
