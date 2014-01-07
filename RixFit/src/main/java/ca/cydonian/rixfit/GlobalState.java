package ca.cydonian.rixfit;

import android.app.Application;

import ca.cydonian.rixfit.Data.WorkoutsDB;

/**
 * Created by Andy on 06/01/14.
 */
public class GlobalState extends Application {
    private WorkoutsDB db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = new WorkoutsDB(this);
    }

    public WorkoutsDB getDatabase()
    {
        return db;
    }
}
