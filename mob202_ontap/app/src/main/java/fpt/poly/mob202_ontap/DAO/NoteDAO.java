package fpt.poly.mob202_ontap.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpt.poly.mob202_ontap.DBHelper.myDBHelper;
import fpt.poly.mob202_ontap.DTO.Note;

public class NoteDAO {
    SQLiteDatabase db;
    myDBHelper dbHelper;

    public NoteDAO(Context context) {
        dbHelper = new myDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long insertRow(Note objnote){
        ContentValues values = new ContentValues();
        values.put("content",objnote.getContent());
        values.put("time",objnote.getTime());
        long res = db.insert("note_table",null,values);
        return res;
    }
    public int updateRow(Note objnote){
        ContentValues values = new ContentValues();
        values.put("content",objnote.getContent());
        values.put("time",objnote.getTime());
        int res = db.update("note_table",values,"id=?",new String[]{String.valueOf(objnote.getId())});
        return res;
    }
    public int deleteRow(Note objnote){
        return db.delete("note_table","id=?",new String[]{String.valueOf(objnote.getId())});
    }
    public List<Note> getAll(){
        List<Note> listNote = new ArrayList<>();
        String[] ds_cot = new String[]{"*"};
        Cursor c = db.query("note_table",ds_cot,null,null,null,null,null);
        if(c.moveToFirst()){
            while (!c.isAfterLast()){
                Note objnote = new Note(c.getInt(0), c.getString(1), c.getString(2));
                objnote.setId(c.getInt(0));
                objnote.setContent(c.getString(1));
                objnote.setTime(c.getString(2));
                listNote.add(objnote);
                c.moveToNext();
            }
        }
        return listNote;
    }
    public List<Note> timkiem(String noidung) {
        List<Note> list = new ArrayList<>();
        Cursor c = db.rawQuery("select * from note_table where content like ? ", new String[]{noidung});
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                Note objnote = new Note(c.getInt(0), c.getString(1), c.getString(2));
                list.add(objnote);
                c.moveToNext();
            }
        }
        return list;
    }
}
