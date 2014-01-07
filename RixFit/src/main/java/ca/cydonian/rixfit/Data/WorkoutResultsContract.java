package ca.cydonian.rixfit.Data;

import android.provider.BaseColumns;

/**
 * Created by Andy on 06/01/14.
 */
public final class WorkoutResultsContract {

    public WorkoutResultsContract() {}

    /* Inner class that defines the table contents */
    public static abstract class WorkoutResultsEntry implements BaseColumns {
        public static final String TABLE_NAME = "workoutresults";
        public static final String COLUMN_NAME_EXERCISE_ID = "exerciseid";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_NUMBER_OF_SETS = "numsets";
    }
    public static abstract class WorkoutSetResultsEntry implements BaseColumns {
        public static final String TABLE_NAME = "workoutsetresults";
        public static final String COLUMN_NAME_WORKOUT_ID = "resultid";
        public static final String COLUMN_NAME_SET_ID = "setid";
        public static final String COLUMN_NAME_REPS = "reps";
        public static final String COLUMN_NAME_WEIGHT = "weight";
    }
}
