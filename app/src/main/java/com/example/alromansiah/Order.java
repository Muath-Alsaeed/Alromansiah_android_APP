package com.example.alromansiah;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Order extends AppCompatActivity  {
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;

    private TextView meat1, meat2, chickens1, chickens2;
    private MyDBHandler dbHandler;
    private SQLiteDatabase db;
    String dbData = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        meat1 = (TextView) findViewById(R.id.editmeat1);
        meat2 = (TextView) findViewById(R.id.editmeat2);
        chickens1 = (TextView) findViewById(R.id.editchickens1);
        chickens2 = (TextView) findViewById(R.id.editchickens2);
        dbHandler = new MyDBHandler(getApplicationContext());
        db = dbHandler.getWritableDatabase();
    }


    public void add1(View v) {
        counter1 = counter1 + 1;
        if(counter1<=0){counter1=0;}
        meat1.setText(String.valueOf(counter1));

    }

    public void add2(View v) {
        counter2 = counter2 + 1;
        meat2.setText(String.valueOf(counter2));

    }

    public void min1(View v) {

        counter1 = counter1 - 1;
        if(counter1<=0){counter1=0;}
        meat1.setText(String.valueOf(counter1));
        if (counter1 <=0){
            meat1.setText("");
            return;
        }

    }

    public void min2(View v) {
        counter2 = counter2 - 1;
        if(counter2<=0){counter2=0;}
        meat2.setText(String.valueOf(counter2));
        if (counter2 <=0){
            meat2.setText("");
            return;
        }
    }

    public void add3(View v) {
        counter3 = counter3 + 1;
        chickens1.setText(String.valueOf(counter3));

    }

    public void add4(View v) {
        counter4 = counter4 + 1;
        chickens2.setText(String.valueOf(counter4));

    }

    public void min3(View v) {
        counter3 = counter3 - 1;
        if(counter3<=0){counter3=0;}
        chickens1.setText(String.valueOf(counter3));
        if (counter3 <=0){
            chickens1.setText("");
            return;
        }

    }

    public void min4(View v) {
        counter4 = counter4 - 1;
        if(counter4<=0){counter4=0;}
        chickens2.setText(String.valueOf(counter4));
        if (counter4 <=0){
            chickens2.setText("");
            return;
        }

    }

    public void addButtonClicked(View view) {
        String meStr1 = meat1.getText().toString();
        String meStr2 = meat2.getText().toString();

        String chStr1 = chickens1.getText().toString();
        String chStr2 = chickens2.getText().toString();


        if (meStr1.isEmpty() && meStr2.isEmpty() && chStr1.isEmpty() && chStr2.isEmpty()) {
            Toast.makeText(getApplicationContext()," قم بتعبة حقل واحد على الاقل", Toast.LENGTH_LONG).show();
            return;
        }

        db.execSQL("insert into " + dbHandler.TABLE_NAME + "(" + dbHandler.COLUMN_m + "," + "  " + dbHandler.COLUMN_mm + "," +
                dbHandler.COLUMN_c + "," + "  " + dbHandler.COLUMN_cc + ") VALUES (?,?,?,?)", new String[]{meStr1, meStr2, chStr1, chStr2});




        meat1.setText("");
        meat2.setText("");
        chickens1.setText("");
        chickens2.setText("");
        String query = "SELECT * FROM " + MyDBHandler.TABLE_NAME;
        String dbData = " ";
        //Cursor point to a location in your result
        Cursor c = db.rawQuery(query, null);
        //Move to first row in your result
        c.moveToLast();
        //Position after the last row means the end of the results
        dbData +="تمت اضافة الطلب بنجاح " ;
        dbData += "\n";
        dbData +=" رقم الفاتورة = ";








        dbData +=  c.getString(c.getColumnIndex(MyDBHandler.COLUMN_RECID));





        Toast.makeText(getApplicationContext(),dbData, Toast.LENGTH_LONG).show();
       // Toast.makeText(getApplicationContext(),  "تمت اضافة الطلب بنجاح " , Toast.LENGTH_LONG).show();

    }

    public void backTo1(View view) {
        Intent t = new Intent(this, Choice.class);
        startActivity(t);
        overridePendingTransition(R.anim.slide_left,R.anim.slide_out_right);

        dbHandler.close();
        finish();
    }


}