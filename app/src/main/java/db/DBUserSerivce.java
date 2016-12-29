package db;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBUserSerivce {
    private DBManger dbManger;

    public DBUserSerivce(Context context) {
        dbManger = DBManger.getInter(context);//调用单列

    }
    /**
     * 新增
     *
     * @param user
     * @return
     */
    public boolean addUser(UserName user) {
        try {
            String sql = "insert into user (name,pwd) values (?,?)";
            Object[] o = new Object[]{
                  user.getName(), user.getPwd()
            };
            boolean flag = dbManger.update(sql, o);
            return flag;
        } catch (Exception e) {
            Log.e("=====","=======EEEEE===="+e.toString());
            return false;
        }
    }

    /**
     * 删除
     *
     * @param user
     * @return
     */
    public boolean deleteUser(UserName user) {

        try {
            String sql = "delete from user where id=?";
            Object[] objects = new Object[]{
                    user.getName()
            };
            boolean flag = dbManger.update(sql, objects);
            return flag;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 修改
     */
    public boolean updataUser(UserName user) {
        try {
            String sql = "update user set name=? where id=?";
            Object[] oe = new Object[]{
                    user.getName(), user.getPwd()
            };
            boolean falg = dbManger.update(sql, oe);
            return falg;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 查询用户名和密码
     * @param name
     * @param pwd
     * @return
     */
    public int queryUser2(String name,String pwd){
        Cursor cursor = null;
        Log.d("==ada==",name+"");
        Log.d("==ada==",pwd+"");
        try{
            String sql = "select * from user where name = ? and pwd = ?";
            cursor = dbManger.query(sql,new String[]{name,pwd});
            if (cursor.getCount() == 0){
                return 0;
            }else{
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            if (cursor != null){
                cursor.close();
            }
            dbManger.getClose();
        }
    }


    /**
     * 查询单个
     */
    public int queryUser(String name ) {
        Cursor cursor = null;
        try{
            String sql = "select * from user where name = ?";
            cursor = dbManger.query(sql,new String[]{name});
            if(cursor == null || cursor.getCount() == 0){
                return 0;
            }else{
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }finally {
            if (cursor != null){
                cursor.close();
            }
            dbManger.getClose();
        }
    }

    /**
     * 查询全部
     * @return
     */

    public List<UserName> queryUserqb() {

        List<UserName> users = new ArrayList<>();
        Cursor cursor = null;
        try {
            String sql = "select  * from user";
            cursor = dbManger.query(sql, null);
            if (cursor == null || cursor.getCount() == 0) {
                return users;
            }
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
                UserName userName = new UserName(pwd,name);
                users.add(userName);
            }
            return users;//接收什么返回什么
        } catch (Exception e) {
            return users;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            dbManger.getClose();
        }
    }


    private UserName getCount(Cursor cursor) {

        if (cursor == null)
            return null;
Integer  id=cursor.getInt(cursor.getColumnIndex("id"));
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
        UserName user = new UserName(id,name,pwd);
        return user;
    }
}
