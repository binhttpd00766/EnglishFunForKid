package com.fpoly.db;

import com.fpoly.object.English;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Mydatabase extends SQLiteOpenHelper {

	// khai bao
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "Database";
	private static final String CAREATE_TABLE="CREATE TABLE ENGLISH(id INTEGER PRIMARY KEY  AUTOINCREMENT, name_image  INTEGER , name_audio  INTEGER , decription  INTEGER )";

	public Mydatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d(null, " create db--------------------------------------------------------------------");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CAREATE_TABLE);
		Log.d("table in crate", "create table --------------------------------------------------------");


	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS  ENGLISH ");
		onCreate(db);

	}
	   public int addCauhoi(English SV){
	        SQLiteDatabase db=this.getWritableDatabase();
	        ContentValues values=new ContentValues();
	      //  values.put("id",SV.getMaLop());
	        values.put("name_image",SV.getImage());
	        values.put("name_audio",SV.getAudio());
	        values.put("decription",SV.getDecription());

	        int error=(int) db.insert("ENGLISH",null,values);
	        if (error==-1){
	            Log.d("====", "error in");
	            //Toast.makeText(Activity_LopHoc.class,"lỗi",Toast.LENGTH_LONG)

	        } else Log.d("-----","Ok");

	        return error;
	    }
	

    public void closeDB(){
        SQLiteDatabase db=this.getReadableDatabase();
        if (db!=null && db.isOpen())
            db.close();
    }

}
