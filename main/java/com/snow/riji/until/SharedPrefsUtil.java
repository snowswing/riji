package com.snow.riji.until;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Toast;

import com.snow.riji.R;

public class SharedPrefsUtil {
    private static SharedPreferences sSharedPrefs;
    /** The name of preferences file. */
    public static final String PREFERENCE_NAME = "KneeRehabilitationPref";

    private static final String HOLD_TIME = "HoldTime";
    private static int DEFAULT_TIME = 10000;

    public static SharedPreferences getKneeRehabSharedPreferences(Context context){
        if (sSharedPrefs == null) {
            sSharedPrefs = context.getSharedPreferences(
                          PREFERENCE_NAME, Context.MODE_WORLD_READABLE);
        }
        return sSharedPrefs;
    }

    /**
     * Return 抬腿时长，默认10秒
     *
     * @param context The context to operate in
     * @return The value of the subscription.
     */
    public static int getHoldTime(Context context) {
        // Get a reference to the shared preferences reader.
        SharedPreferences sharedPreferences = getKneeRehabSharedPreferences(context);

        // Return the current value for the show subscription flag.
        return sharedPreferences.getInt(HOLD_TIME,
        		DEFAULT_TIME);
    }

    /**
     * 写入一级睡眠的时间.
     *
     * @param context The context to operate in
     * @param  time new value to write.
     */
    public static void setHoldTime(Context context, int time) {
        // Get our shared preferences modifier tool.
        SharedPreferences sharedPreferences = getKneeRehabSharedPreferences(context);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

        // Write the provided value.
        sharedPreferencesEditor.putInt(HOLD_TIME,
        		time*1000);
        sharedPreferencesEditor.commit();
        Toast toast = Toast.makeText(context,
			     R.string.hold_time_set_suc_text, Toast.LENGTH_LONG);
			   toast.setGravity(Gravity.CENTER, 0, 0);
			   toast.setDuration(3000);
			   toast.show();
    }

}
