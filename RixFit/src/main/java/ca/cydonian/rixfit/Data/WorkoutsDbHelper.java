package ca.cydonian.rixfit.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andy on 06/01/14.
 */
public class WorkoutsDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Workouts.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_EXERCISE_ENTRIES =
            "CREATE TABLE " + ExercisesContract.ExerciseEntry.TABLE_NAME + " (" +
                    ExercisesContract.ExerciseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ExercisesContract.ExerciseEntry.COLUMN_NAME_EXERCISE_NAME + TEXT_TYPE + COMMA_SEP +
                    ExercisesContract.ExerciseEntry.COLUMN_NAME_1RM + REAL_TYPE + COMMA_SEP +
                    ExercisesContract.ExerciseEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE  +
                    " )";

    private static final String SQL_CREATE_RESULTS_ENTRIES =
            "CREATE TABLE " + WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME + " (" +
                    WorkoutResultsContract.WorkoutResultsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_EXERCISE_ID + INTEGER_TYPE + COMMA_SEP +
                    WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_DATE + INTEGER_TYPE + COMMA_SEP +
                    WorkoutResultsContract.WorkoutResultsEntry.COLUMN_NAME_NUMBER_OF_SETS + INTEGER_TYPE +
                    " )";

    private static final String SQL_CREATE_RESULT_SETS_ENTRIES =
            "CREATE TABLE " + WorkoutResultsContract.WorkoutSetResultsEntry.TABLE_NAME + " (" +
                    WorkoutResultsContract.WorkoutSetResultsEntry._ID + " INTEGER PRIMARY KEY," +
                    WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_WORKOUT_ID + INTEGER_TYPE + COMMA_SEP +
                    WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_SET_ID + INTEGER_TYPE + COMMA_SEP +
                    WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_REPS + INTEGER_TYPE + COMMA_SEP +
                    WorkoutResultsContract.WorkoutSetResultsEntry.COLUMN_NAME_WEIGHT + REAL_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ExercisesContract.ExerciseEntry.TABLE_NAME;
    private static final String SQL_DELETE_RESULT_ENTRIES =
            "DROP TABLE IF EXISTS " + WorkoutResultsContract.WorkoutResultsEntry.TABLE_NAME;
    private static final String SQL_DELETE_RESULT_SET_ENTRIES =
            "DROP TABLE IF EXISTS " + WorkoutResultsContract.WorkoutSetResultsEntry.TABLE_NAME;

    public WorkoutsDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_EXERCISE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_RESULTS_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_RESULT_SETS_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_RESULT_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_RESULT_SET_ENTRIES);
        onCreate(sqLiteDatabase);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
