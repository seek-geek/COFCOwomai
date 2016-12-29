package db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * User管理
 */
public class DBManger {
    private static DBManger dbManger;
    private DBHleper dbHleper;
    private SQLiteDatabase database;

    private DBManger(Context context) {
        dbHleper = new DBHleper(context);//初始化数据库

    }

    public static DBManger getInter(Context context) {
        if (dbManger == null) {
            dbManger = new DBManger(context);
        }
        return dbManger;
    }

    /**
     * 连接数据库
     */
    public void getConnect() {
        try {
            database = dbHleper.getWritableDatabase();
        } catch (Exception e) {

        }
    }

    /**
     * 关闭数据库
     */
    void getClose() {
        database.close();
    }

    /**
     * 增删改
     */
    public boolean update(String sql, Object[] objects) {

        getConnect();//连接数据库
        try {
            database.execSQL(sql, objects);//execSQL操作数据库数据
            return true;
        } catch (Exception e) {
            Log.e("=====","=======FFFFFFF===="+e.toString());
            return false;
        } finally {
          getClose(); //关闭数据库
        }
    }
    /**
     * 查询
     */
    public Cursor query(String sql, String[] set){
        getConnect();//连接数据库
        try {
            Cursor cursor=database.rawQuery(sql,set);//rawQuery查询
            return  cursor;
        }catch (Exception e){
            return  null;
        }
    }
}
