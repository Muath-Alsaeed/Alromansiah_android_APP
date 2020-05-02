package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.alromansiah.MyDBHandler.COLUMN_RECID;
import static com.example.alromansiah.MyDBHandler.TABLE_NAME;


public class update extends AppCompatActivity {


    private EditText etID,meat1,meat2,chickens1,chickens2;

    private MyDBHandler dbHandler;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



        etID = (EditText)findViewById(R.id.idInp);
        meat1 = (EditText)findViewById(R.id.mandi_2);
        meat2 = (EditText)findViewById(R.id.mazgot);

        chickens1 = (EditText)findViewById(R.id.chaken3);
        chickens2 = (EditText)findViewById(R.id.checken4);





        dbHandler = new MyDBHandler(getApplicationContext());
        database = dbHandler.getWritableDatabase();
    }

    public void shwIDInfo(View V) {

        String meStr1 = meat1.getText().toString();
        String meStr2 = meat2.getText().toString();

        String chStr1 = chickens1.getText().toString();
        String chStr2 = chickens2.getText().toString();


        String id = etID.getText().toString();
        if (id.isEmpty()) {
            Toast.makeText(getApplicationContext(), "أدخل رقم الطلب", Toast.LENGTH_LONG).show();
            return;
        }
        String sqltStmt = "Select * from " + TABLE_NAME
                + " where " + COLUMN_RECID + " = ?";
        Cursor c = database.rawQuery(sqltStmt, new String[]{id});
        if (!c.moveToFirst()) {
            Toast.makeText(getApplicationContext(), "لايوجد نتائج", Toast.LENGTH_LONG).show();
            return;
        }

        meat1.setText(c.getString(1));
        meat2.setText(c.getString(2));
        chickens1.setText(c.getString(3));
        chickens2.setText(c.getString(4));

        c.close();

    }



    public void upd_1(View view){
        String id_no= etID.getText().toString();

         String meStr1 = meat1.getText().toString();
         String meStr2= meat2.getText().toString();
         String chStr1= chickens1.getText().toString();
         String chStr2= chickens2.getText().toString();

        if( id_no.isEmpty() || meStr1.isEmpty()&&meStr2.isEmpty()&& chStr1.isEmpty()  &&chStr2.isEmpty() )
        {  Toast.makeText(getApplicationContext(), "ادخل رقم الطلب اولاّ", Toast.LENGTH_LONG).show();}

        else {
            Toast.makeText(getApplicationContext(), " تم تعديل رقم الطلب "+ id_no  + " بنجاح ", Toast.LENGTH_LONG).show();
            etID.setText("");

            meat1.setText("");
            meat2.setText("");
            chickens1.setText("");
            chickens2.setText("");


            dbHandler.update(id_no, meStr1, meStr2, chStr1, chStr2);
        }
    }

    public void backTo2(View view){

        Intent t = new Intent(this,Choice.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_right,R.anim.slide_out_left);

        dbHandler.close();
        finish();
    }
}
