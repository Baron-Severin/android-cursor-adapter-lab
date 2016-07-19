package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;
import ly.generalassemb.drewmahrt.shoppinglistver2.setup.ShoppingCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBAssetHelper dbHelp = DBAssetHelper.getInstance(this);

        dbHelp.insertIntoDB("New Item", "This item is pretty sick", "$1", "big");
        dbHelp.insertIntoDB("Sev Item", "Also quite sick", "$2", "item");
        dbHelp.insertIntoDB("A THIRD ITEM", "meh, take it or leave it", "$3", "adjective");

        ListView listView = (ListView) findViewById(R.id.shopping_list_view);
        Cursor cursor = dbHelp.getCursor();
        ShoppingCursorAdapter cursorAdapter = new ShoppingCursorAdapter(this, cursor);
        cursor.close();

        dbHelp.insertIntoDB("New Item", "This item is pretty sick", "$1", "big");
        dbHelp.insertIntoDB("Sev Item", "Also quite sick", "$2", "item");
        dbHelp.insertIntoDB("A THIRD ITEM", "meh, take it or leave it", "$3", "adjective");
        cursor = dbHelp.getCursor();
        cursorAdapter.changeCursor(cursor);

        listView.setAdapter(cursorAdapter);

    }




}
