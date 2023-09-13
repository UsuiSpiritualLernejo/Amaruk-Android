package usl.amaruk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LocaleUtils {

    public static Context getContext(Context c) {
        Configuration overrideConfiguration = c.getResources().getConfiguration();
        SharedPreferences sharedPref = c.getApplicationContext().getSharedPreferences("poetry", Context.MODE_PRIVATE);
        Locale locale = new Locale(sharedPref.getString("locale", "en"));
        Locale.setDefault(locale);
        overrideConfiguration.setLocale(locale);
        Configuration config = c.getResources().getConfiguration();
        config.setLocale(locale);
        return c.createConfigurationContext(config);
    }

    public static String getString(Context c, int id) {
        Configuration overrideConfiguration = c.getResources().getConfiguration();
        SharedPreferences sharedPref = c.getApplicationContext().getSharedPreferences("poetry", Context.MODE_PRIVATE);
        Locale locale = new Locale(sharedPref.getString("locale", "en"));
        Locale.setDefault(locale);
        overrideConfiguration.setLocale(locale);
        Configuration config = c.getResources().getConfiguration();
        config.setLocale(locale);
        Context ac = c.createConfigurationContext(config);
        return ac.getResources().getString(id);
    }

    public static String getString(Context c, int id, String langCode) {
        Configuration overrideConfiguration = c.getResources().getConfiguration();
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        overrideConfiguration.setLocale(locale);
        Configuration config = c.getResources().getConfiguration();
        config.setLocale(locale);
        Context ac = c.createConfigurationContext(config);
        return ac.getResources().getString(id);
    }

}