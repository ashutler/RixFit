package ca.cydonian.rixfit.Data;

import android.provider.BaseColumns;

/**
 * Created by Andy on 06/01/14.
 */
public final class ExercisesContract
{
    public ExercisesContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ExerciseEntry implements BaseColumns {
        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_NAME_EXERCISE_NAME = "name";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
