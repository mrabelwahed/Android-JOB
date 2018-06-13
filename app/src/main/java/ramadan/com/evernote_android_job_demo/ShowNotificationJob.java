package ramadan.com.evernote_android_job_demo;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationManagerCompat;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.Random;

/**
 * Created by mahmoud on 13/06/18.
 */

public class ShowNotificationJob extends Job {

    static final String TAG = "show_notification_job_tag";
    @NonNull
    @Override
    protected Result onRunJob(Params params) {
        PendingIntent pi = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(), MainActivity.class), 0);

        Notification notification = new Notification.Builder(getContext())
                .setContentTitle("Android Job Demo")
                .setContentText("Notification from Android Job Demo App.")
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        NotificationManagerCompat.from(getContext())
                .notify(new Random().nextInt(), notification);

        return Result.SUCCESS;
    }


    static void schedulePeriodic(){
        new JobRequest.Builder(ShowNotificationJob.TAG)
                .setPeriodic(900000L)
                .setUpdateCurrent(true)
                .setPersisted(true)
                .build().schedule();

    }
}
