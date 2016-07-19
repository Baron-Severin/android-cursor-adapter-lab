package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistver2.R;

/**
 * Created by erikrudie on 7/19/16.
 */
public class ShoppingCursorAdapter extends CursorAdapter {
    public ShoppingCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.shopping_list_items, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvItem = (TextView) view.findViewById(R.id.textView1);
        TextView tvType = (TextView) view.findViewById(R.id.textView2);
        TextView tvPrice = (TextView) view.findViewById(R.id.textView3);
        TextView tvDescription = (TextView) view.findViewById(R.id.textView4);

        String textItem = cursor.getString(cursor.getColumnIndexOrThrow(DBAssetHelper.COL_ITEM_NAME));
        String textType = cursor.getString(cursor.getColumnIndexOrThrow(DBAssetHelper.COL_TYPE));
        String textPrice = cursor.getString(cursor.getColumnIndexOrThrow(DBAssetHelper.COL_PRICE));
        String textDescription = cursor.getString(cursor.getColumnIndexOrThrow(DBAssetHelper.COL_DESC));

        tvItem.setText(textItem);
        tvType.setText(textType);
        tvPrice.setText(textPrice);
        tvDescription.setText(textDescription);
    }
}