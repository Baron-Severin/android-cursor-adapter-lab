package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class DBAssetHelper extends SQLiteOpenHelper {

    private static final String TAG = DBAssetHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 13;
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String SHOPPING_LIST_TABLE_NAME = "SHOPPING_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_DESC = "DESCRIPTION";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";

    public static final String[] SHOPPING_COLUMNS = {COL_ID, COL_ITEM_NAME, COL_DESC, COL_PRICE, COL_PRICE, COL_TYPE};

    private static final String CREATE_SHOPPING_LIST_TABLE =
            "create table " + SHOPPING_LIST_TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ITEM_NAME + " TEXT,"
                    + COL_DESC + " TEXT," + COL_PRICE + " TEXT," + COL_TYPE + " TEXT);";


    private static DBAssetHelper instance;

    public static DBAssetHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBAssetHelper(context);
        }
        return instance;
    }

    private DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, CREATE_SHOPPING_LIST_TABLE);
        db.execSQL(CREATE_SHOPPING_LIST_TABLE);
//        db.execSQL("INSERT INTO " + SHOPPING_LIST_TABLE_NAME + "(" + COL_ITEM_NAME + ", "
//                + COL_DESC + ", " + COL_PRICE + ", " + COL_TYPE + ") VALUES ('item', 'description', 'price', 'type');");
    }

    public void insertIntoDB(String itemName, String description, String price, String type) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO " + SHOPPING_LIST_TABLE_NAME + "(" + COL_ITEM_NAME + ", " + COL_DESC
                + ", " + COL_PRICE + ", " + COL_TYPE + ") VALUES ('" + itemName + "', '"
                + description + "', '" + price + "', '" + type + "');");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor getCursor() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SHOPPING_LIST_TABLE_NAME + ";", null);
        return cursor;
    }


}
