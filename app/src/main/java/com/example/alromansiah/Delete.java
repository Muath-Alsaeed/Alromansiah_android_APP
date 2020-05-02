package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.alromansiah.MyDBHandler.COLUMN_RECID;
import static com.example.alromansiah.MyDBHandler.TABLE_NAME;


public class Delete extends AppCompatActivity {

    private EditText etID;
    private TextView meat1,meat2,chickens1,chickens2,idTxtView20,idTxtView21,idTxtView22,idTxtView23,ps1,ps2,ps3,ps4,
            NM1,NM2,NM3,NM4;
    private MyDBHandler dbHandler;
    String tstMsg;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);



        etID = (EditText)findViewById(R.id.idInp);
        meat1 = (TextView)findViewById(R.id.mandi_2);
        meat2 = (TextView)findViewById(R.id.mazgot);

        idTxtView20 = (TextView)findViewById(R.id.idTxtView2);
        idTxtView21 = (TextView)findViewById(R.id.idTxtView3);
        idTxtView22 = (TextView)findViewById(R.id.idTxtView4);
        idTxtView23 = (TextView)findViewById(R.id.idTxtView5);


        NM1 = (TextView)findViewById(R.id.mandi_2);

        NM2 = (TextView)findViewById(R.id.mazgot);

        NM3 = (TextView)findViewById(R.id.chaken3);

        NM4 = (TextView)findViewById(R.id.checken4);



        ps1 = (TextView)findViewById(R.id.prise1);

        ps2 = (TextView)findViewById(R.id.prise2);

        ps3 = (TextView)findViewById(R.id.prise3);

        ps4 = (TextView)findViewById(R.id.prise4);


        chickens1 = (TextView)findViewById(R.id.chaken3);
        chickens2 = (TextView)findViewById(R.id.checken4);






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
            Toast.makeText(getApplicationContext(), "لا يوجد نتائج", Toast.LENGTH_LONG).show();
            return;
        }

        meat1.setText(c.getString(1));
        meat2.setText(c.getString(2));


        chickens1.setText(c.getString(3));


        chickens2.setText(c.getString(4));

        c.close();



    }
    public void delTsk(View view){
        String id = etID.getText().toString();
        if(id.isEmpty()){
            Toast.makeText(getApplicationContext(),"ادخل رقم الطلب",Toast.LENGTH_LONG).show();
            return; }
        database.execSQL("delete from " + TABLE_NAME + " where " +COLUMN_RECID+"="+id+" ; " );
        tstMsg = "الطلب رقم " + id  + " تم حذفه ";
        Toast.makeText(getApplicationContext(),tstMsg,Toast.LENGTH_LONG).show();
        meat1.setText("");
        meat2.setText("");
        chickens1.setText("");
        chickens2.setText("");




    }
    public void backTo2(View view){

        Intent t = new Intent(this,Choice.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_left,R.anim.slide_out_right);

        dbHandler.close();
        finish();
    }
}