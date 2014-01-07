package ca.cydonian.rixfit.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Andy on 06/01/14.
 */
public class WorkoutsDB {

    private SQLiteDatabase db;
    private final Context context;
    private final WorkoutsDbHelper dbhelper;

    public WorkoutsDB(Context c){
        context = c;
        dbhelper = new WorkoutsDbHelper(context, WorkoutsDbHelper.DATABASE_NAME, null, WorkoutsDbHelper.DATABASE_VERSION);
    }
    public void close()
    {
        db.close();
    }
    public void open() throws SQLiteException
    {
        try
        {
            db = dbhelper.getWritableDatabase();
        }
        catch(SQLiteException e)
        {
            Log.v("Open database exception caught", e.getMessage());
            db = dbhelper.getReadableDatabase();
        }
    }
    public long InsertExercise(String name, String subtitle)
    {
        try {
            ContentValues newExerciseValue = new ContentValues();
            newExerciseValue.put(ExercisesContract.ExerciseEntry.COLUMN_NAME_EXERCISE_NAME, name);
            newExerciseValue.put(ExercisesContract.ExerciseEntry.COLUMN_NAME_SUBTITLE, subtitle);
            return db.insert(ExercisesContract.ExerciseEntry.TABLE_NAME, null, newExerciseValue);
        } catch (SQLiteException e) {
            Log.v("InsertExercise exception caught", e.getMessage());
            return -1;
        }
    }
    public Cursor GetExercises()
    {
        Cursor c = db.query(ExercisesContract.ExerciseEntry.TABLE_NAME, null, null,
                null, null, null, null);
        return c;
    }
    public long InsertWorkout(int exerciseid, Date date, int numsets)
    {
        try {
            ContentValues newWorkoutValue = new ContentValues();
            newWorkoutValue.put(WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_EXERCISE_ID, exerciseid);
            newWorkoutValue.put(WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_DATE, date.getTime());
            newWorkoutValue.put(WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_NUMBER_OF_SETS, numsets);
            return db.insert(WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME, null, newWorkoutValue);
        } catch (SQLiteException e) {
            Log.v("InsertWorkout exception caught", e.getMessage());
            return -1;
        }
    }
    public Cursor GetWorkouts()
    {
        Cursor c = db.query(WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME, null, null,
                null, null, null, null);
        return c;
    }
    public Cursor GetWorkout(int workoutid)
    {
        String selection = WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_EXERCISE_ID + " LIKE ?";

        String[] selectionArgs = { String.valueOf(workoutid) };

        Cursor c = db.query(WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME, null,
                selection,
                selectionArgs,
                null, null, null);
        return c;
    }
    public long InsertWorkoutSet(int workoutid, int setid, int reps, float weight)
    {
        try {
            ContentValues newWorkoutValue = new ContentValues();
            newWorkoutValue.put(WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_WORKOUT_ID, workoutid);
            newWorkoutValue.put(WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_SET_ID, setid);
            newWorkoutValue.put(WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_REPS, reps);
            newWorkoutValue.put(WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_WEIGHT, weight);
            return db.insert(WorkoutResultsContract.WorkoutSetResultsEntry.TABLE_NAME, null, newWorkoutValue);
        } catch (SQLiteException e) {
            Log.v("InsertWorkoutSet exception caught", e.getMessage());
            return -1;
        }
    }
    public Cursor GetWorkoutSets(int workoutid)
    {
        String selection = WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_WORKOUT_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(workoutid) };

        Cursor c = db.query(WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME, null,
                selection,
                selectionArgs,
                null, null, null);
        return c;
    }
}
