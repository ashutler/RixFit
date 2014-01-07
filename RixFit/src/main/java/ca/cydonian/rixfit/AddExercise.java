package ca.cydonian.rixfit;

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
import android.widget.EditText;

public class AddExercise extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_exercise, menu);
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
    public class PlaceholderFragment extends Fragment implements View.OnClickListener{

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_add_exercise, container, false);
            Button addExercise = (Button)rootView.findViewById(R.id.addButton);
            if (addExercise != null)
            {
                addExercise.setOnClickListener(this);
            }
            return rootView;
        }

        @Override
        public void onClick(View view) {
            EditText exerciseName, exerciseDescription;
            exerciseName = (EditText)getView().findViewById(R.id.exerciseNameText);
            exerciseDescription = (EditText)getView().findViewById(R.id.exerciseDescriptionText);

            GlobalState gs = (GlobalState) getApplication();
            gs.getDatabase().InsertExercise(exerciseName.getText().toString(),
                    exerciseDescription.getText().toString());



            getActivity().finish();
        }
    }

}
