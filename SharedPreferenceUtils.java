import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.preference.PreferenceManager;

public class SharedPreferenceUtils {
    private String TAG = "WH_"+SharedPreferenceUtils.class.getSimpleName();

    private SharedPreferences spf;

    public SharedPreferenceUtils(Context context) {
        spf = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Keys getPreferenceValue(){
        Keys keys = new Keys();
        keys.setting_server_https = spf.getBoolean(Keys.KEY_setting_server_https,false);
        Log.d(TAG, String.valueOf(keys.setting_server_https));

        keys.setting_server_address = spf.getString(Keys.KEY_setting_server_address,"127.0.0.1");
        Log.d(TAG,keys.setting_server_address);

        keys.setting_server_port = Integer.parseInt(spf.getString(Keys.KEY_setting_server_port,"5000"));
        Log.d(TAG, String.valueOf(keys.setting_server_port));

        keys.setting_access_token_key = spf.getString(Keys.KEY_setting_access_token_key,"access_token");
        Log.d(TAG,keys.setting_access_token_key);

        keys.setting_access_token_value = spf.getString(Keys.KEY_setting_access_token_value,"this is token value");
        Log.d(TAG,keys.setting_access_token_value);

        keys.setting_dev_name = spf.getString(Keys.KEY_setting_dev_name,"device");
        Log.d(TAG,keys.setting_dev_name);

        return keys;
    }

    public static class Keys{
        public boolean setting_server_https;
        public static final String KEY_setting_server_https = "setting_server_https";

        public String setting_server_address;
        public static final String KEY_setting_server_address = "setting_server_address";

        public int setting_server_port;
        public static final String KEY_setting_server_port = "setting_server_port";

        public String setting_access_token_key;
        public static final String KEY_setting_access_token_key = "setting_access_token_key";

        public String setting_access_token_value;
        public static final String KEY_setting_access_token_value = "setting_access_token_value";


        public String setting_dev_name;
        public static final String KEY_setting_dev_name = "setting_dev_name";

        public String getFullServerAddress(){
            String protocol = setting_server_https?"https":"http";
            return protocol+"://"+setting_server_address+":"+setting_server_port;
        }
    }
}
