
package jp.keita.kagurazaka.gojappemod;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Pref extends PreferenceActivity {

  public static final String BOOKMARK = "bookmark";
  public static final String DELETEDS = "deleteds";
  public static final String CATEGORYLIST = "categoy"; // pfname.category.
  public static final String LASTCATEGORY = "LASTCATEGORY";
  public final static String FONT = "font";
  public final static String JAVASCRIPT = "javascript";
  public final static String UA = "ua";
  public static final String VOLUMESCROLL = "volume";
  public final static String LOADIMAGE = "loadimage";
  public final static String LASTITEM = "lastitem";
  public static final String LISTCOLOR = "listcolor";
  public static final String LISTBACK = "listback";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.pref);
  }

  public static void WhatsNew(Context c) {
        /*
         * WHAT'S NEW!!
         */
    final SharedPreferences pf = PreferenceManager
        .getDefaultSharedPreferences(c);
    final String versionName;
    final String description = "**0.9.2mnmn \nバグ修正、ライブラリ更新 \n kagurazaka氏にパッチをもらいました。";

    try {
      versionName = c.getPackageManager().getPackageInfo(
          c.getPackageName(), 0).versionName;
      boolean newVersion = pf.getBoolean(versionName, true);
      if (newVersion) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setCancelable(true);
        builder.setTitle("ver: " + versionName);
        builder.setMessage(description);
        builder.setPositiveButton("ok",
                                  new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        final int which) {
                                      pf.edit().putBoolean(versionName, false).apply();
                                      dialog.dismiss();
                                    }// end on-click.
                                  });// end Listener.
        builder.show();
      }
    } catch (NameNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void putLastItemName(Context c, String name) {
    // called from ItemClick;
    final SharedPreferences pf = PreferenceManager
        .getDefaultSharedPreferences(c);
    pf.edit().putString(LASTITEM, name).apply();
  }

  public static String getLastItemName(Context c) {
    // called from Admob;
    final SharedPreferences pf = PreferenceManager
        .getDefaultSharedPreferences(c);
    String name = pf.getString(LASTITEM, "gojappe rss android");
    return name;
  }

  public static String getListStringColor(Context c) {
    final SharedPreferences pf = PreferenceManager
        .getDefaultSharedPreferences(c);
    String color = pf.getString(LISTCOLOR, "#FFFFFF");// def=white
    return color;
  }

  public static String getBackgroundColor(Context c) {
    final SharedPreferences pf = PreferenceManager
        .getDefaultSharedPreferences(c);
    int transRate = pf.getInt(LISTBACK, 80);
    transRate = (int) ((double) transRate * 255.0 / 100.0);
    String hex = String.format("#%02x000000", Integer.valueOf(transRate));
    return hex;
  }
}
