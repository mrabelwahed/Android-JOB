package ramadan.com.evernote_android_job_demo;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * Created by mahmoud on 13/06/18.
 */

public class DemoJobCreator implements JobCreator {
    @Override
    public Job create(String tag) {
        switch (tag) {
            case ShowNotificationJob.TAG:
                return new ShowNotificationJob();
            default:
                return null;

        }
    }
}
