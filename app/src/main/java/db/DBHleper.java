package db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHleper extends SQLiteOpenHelper {
    private static final String name = "User";
    private static final int version = 1;

    public DBHleper(Context context) {
        super(context, name, null, version);
    }


    @Override

    public void onCreate(SQLiteDatabase db) {//创建表
        StringBuffer buffer = new StringBuffer();
        buffer.append("create table user");
        buffer.append("(");
        buffer.append("id integer PRIMARY KEY AUTOINCREMENT,");
        buffer.append("name text,");
        buffer.append("pwd text");
        buffer.append(")");
        db.execSQL(buffer.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
