package ramadan.com.evernote_android_job_demo;

import android.app.Application;

import com.evernote.android.job.JobManager;

/**
 * Created by mahmoud on 13/06/18.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JobManager.create(this).addJobCreator(new DemoJobCreator());
    }
}
