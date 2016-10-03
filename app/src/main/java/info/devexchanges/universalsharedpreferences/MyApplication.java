package info.devexchanges.universalsharedpreferences;

        import android.app.Application;

        import com.zookey.universalpreferences.UniversalPreferences;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UniversalPreferences.initialize(this);
    }
}
