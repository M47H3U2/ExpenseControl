package com.example.prototypofinance.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.prototypofinance.pojos.Account_POJO;
import com.example.prototypofinance.pojos.Expense_POJO;
import com.example.prototypofinance.pojos.Income_POJO;
import com.example.prototypofinance.pojos.Transfer_POJO;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASENAME = "FINANCE";
    private static final int VERSIONDATABASE = 1;
    //private String createDB = "CREATE TABLE ";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the tables in the data base

        db.execSQL(accountTable());
        db.execSQL(expenseTable());
        db.execSQL(incomeTable());
        db.execSQL(transferTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CATEGORIA VAI VIRAR TEMPORARIAMENTE PARTEDA TABELA
    private String accountTable() {
        return "CREATE TABLE accounts ("
                + "ACCOUNT_ID integer primary key autoincrement,"
                + "ACCOUNT_DATETIME datetime not null,"
                + "ACCOUNT_NAME varchar(50) not null,"
                + "ACCOUNT_CATEGORY varchar(50) not null,"
                + "ACCOUNT_VALUE int not null);";
    }

    private String expenseTable() {
        return "CREATE TABLE expenses ("
                + "EXPENSE_ID integer primary key autoincrement,"
                + "EXPENSE_DATETIME datetime not null,"
                + "EXPENSE_ACCOUNT_ID int not null,"
                + "EXPENSE_CATEGORY varchar not null,"
                + "EXPENSE_VALUE int not null,"
                + "EXPENSE_DESCRIPTION varchar(200),"
                + "foreign key (EXPENSE_ACCOUNT_ID) references accounts(ACCOUNT_ID));";
    }

    private String incomeTable() {
        return "CREATE TABLE incomes ("
                + "INCOME_ID integer primary key autoincrement,"
                + "INCOME_DATETIME datetime not null,"
                + "INCOME_ACCOUNT_ID int not null,"
                + "INCOME_CATEGORY varchar not null,"
                + "INCOME_VALUE int not null,"
                + "INCOME_DESCRIPTION_TEXT varchar,"
                + "foreign key (INCOME_ACCOUNT_ID) references accounts(ACCOUNT_ID))";
    }

    private String transferTable() {
        return "CREATE TABLE transfers ("
                + "TRANSFER_ID integer primary key autoincrement,"
                + "TRANSFER_DATETIME datetime not null,"
                + "TRANSFER_NAME varchar(50) not null,"
                + "TRANSFER_VALUE int not null,"
                + "TRANSFER_ACCOUNT_ID_SENDER int not null,"
                + "TRANSFER_ACCOUNT_ID_RECEIVER int not null,"
                + "TRANSFER_DESCRIPTION_TEXT varchar,"
                + "foreign key (TRANSFER_ACCOUNT_ID_SENDER) references accounts(ACCOUNT_ID),"
                + "foreign key (TRANSFER_ACCOUNT_ID_RECEIVER) references accounts(ACCOUNT_ID));";
    }

    public void insertAccount(Account_POJO pojoAccount) {
        //Opening the connection between the database
        SQLiteDatabase db = this.getWritableDatabase();

        //the statment receive the sql and your values
        SQLiteStatement sqLiteStatement =
                db.compileStatement(
                        "insert into accounts ( ACCOUNT_DATETIME, ACCOUNT_NAME,ACCOUNT_CATEGORY, ACCOUNT_VALUE )"
                                + "values (?, ?, ?, ?)");

        //Bind together all data from the pojos into the query line by index
        sqLiteStatement.bindString(1, pojoAccount.getDate());
        sqLiteStatement.bindString(2, pojoAccount.getName());
        sqLiteStatement.bindString(3, pojoAccount.getCategory());
        sqLiteStatement.bindLong(4, pojoAccount.getValue());

        //Execute the code after finished
        sqLiteStatement.execute();
        //Finish the object created to execute to exeute
        sqLiteStatement.close();
        //Finish the database connection
        db.close();
    }

    public void insertExpense(Expense_POJO expense_pojo) {
        //Opening the connection between the database
        SQLiteDatabase db = this.getWritableDatabase();
        //the statment receive the sql and your values
        SQLiteStatement sqLiteStatement =
                db.compileStatement("insert into expenses (EXPENSE_DATETIME, EXPENSE_ACCOUNT_ID, EXPENSE_CATEGORY_ID, EXPENSE_VALUE, EXPENSE_DESCRIPTION) values (?,?,?,?,?)");

        //Bind together all data from the pojos into the query line by index
        sqLiteStatement.bindString(1, expense_pojo.getDatetime());
        sqLiteStatement.bindString(2, expense_pojo.getAccountName());
        sqLiteStatement.bindString(3, expense_pojo.getType());
        sqLiteStatement.bindLong(4, expense_pojo.getValue());
        sqLiteStatement.bindString(5, expense_pojo.getDescription());

        //Execute the code after finished
        sqLiteStatement.execute();
        //Finish the object created to execute to exeute
        sqLiteStatement.close();
        //Finish the database connection
        db.close();
    }

    public void insertIncome(Income_POJO income_pojo) {
        //Opening the connection between the database
        SQLiteDatabase db = this.getWritableDatabase();
        //the statment receive the sql and your values
        SQLiteStatement sqLiteStatement = db.compileStatement(
                "insert into accounts ( INCOME_DATETIME, INCOME_ACCOUNT_ID, INCOME_CATEGORY_ID, INCOME_VALUE, INCOME_DESCRIPTION_TEXT )"
                        + "values (?, ?, ?, ?,?)");

        //Bind together all data from the pojos into the query line by index
        sqLiteStatement.bindString(1, income_pojo.getDatetime());
        sqLiteStatement.bindString(2, income_pojo.getAccountName());
        sqLiteStatement.bindString(3, income_pojo.getType());
        sqLiteStatement.bindLong(4, income_pojo.getValue());
        sqLiteStatement.bindString(5, income_pojo.getDescription());

        //Execute the code after finished
        sqLiteStatement.execute();
        //Finish the object created to execute to exeute
        sqLiteStatement.close();
        //Finish the database connection
        db.close();

    }

    public void insertTransfer(Transfer_POJO transfer_pojo) {
        //Opening the connection between the database
        SQLiteDatabase db = this.getWritableDatabase();
        //the statment receive the sql and your values
        SQLiteStatement sqLiteStatement = db.compileStatement("insert into accounts ( ACCOUNT_DATETIME, ACCOUNT_NAME,ACCOUNT_CATEGORY, ACCOUNT_VALUE )"
                + "values (?, ?, ?, ?)");

        //Bind together all data from the pojos into the query line by index
        sqLiteStatement.bindString(1, transfer_pojo.getDate());
        sqLiteStatement.bindString(2, transfer_pojo.getAccountGive());
        sqLiteStatement.bindString(3, transfer_pojo.getAccountTake());
        sqLiteStatement.bindString(4, transfer_pojo.getValue());
        sqLiteStatement.bindString(5, transfer_pojo.getDescription());

        //Execute the code after finished
        sqLiteStatement.execute();
        //Finish the object created to execute to exeute
        sqLiteStatement.close();
        //Finish the database connection
        db.close();

    }

    public ArrayList<Account_POJO> selectAccount() {

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM accounts";
        Cursor cursor = db.rawQuery(query, null);

        //If the first column of the data base is null return;
        if (cursor.moveToFirst()) {
            ArrayList<Account_POJO> arrayList = new ArrayList<>();
            do {
                int count = 0;
                Account_POJO pojoAccount = new Account_POJO();
                pojoAccount.setDate(cursor.getString(1));
                pojoAccount.setName(cursor.getString(2));
                pojoAccount.setValue(cursor.getInt(3));
                pojoAccount.setCategory(cursor.getString(4));
                arrayList.add(count, pojoAccount);
                count++;
            } while (cursor.moveToNext() != false);
            db.close();
            return arrayList;
        } else {
            return null;
        }
    }

    public ArrayList<Expense_POJO> selectExpense() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM expense";
        Cursor cursor = db.rawQuery(query, null);

        //If the first column of the data base is null return;
        if (cursor.moveToFirst()) {
            ArrayList<Expense_POJO> arrayList = new ArrayList<>();
            do {
                int count = 0;
                Expense_POJO expense_pojo = new Expense_POJO();

                expense_pojo.setDatetime(cursor.getString(1));
                expense_pojo.setAccountName(cursor.getString(2));
                expense_pojo.setValue(cursor.getInt(3));
                expense_pojo.setType(cursor.getString(4));
                expense_pojo.setDescription(cursor.getString(5));

                arrayList.add(count, expense_pojo);
                count++;
            } while (cursor.moveToNext() != false);
            db.close();
            return arrayList;
        } else {
            return null;
        }
    }

    public ArrayList<Income_POJO> selectIncome() {

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM income";
        Cursor cursor = db.rawQuery(query, null);

        //If the first column of the data base is null return;
        if (cursor.moveToFirst()) {
            ArrayList<Income_POJO> arrayList = new ArrayList<>();
            do {
                int count = 0;
                Income_POJO income_pojo = new Income_POJO();

                income_pojo.setDatetime(cursor.getString(1));
                income_pojo.setAccountName(cursor.getString(2));
                income_pojo.setValue(cursor.getInt(3));
                income_pojo.setType(cursor.getString(4));
                income_pojo.setDescription(cursor.getString(5));

                arrayList.add(count, income_pojo);
                count++;
            } while (cursor.moveToNext() != false);
            db.close();
            return arrayList;
        } else {
            return null;
        }

    }

    public ArrayList<Transfer_POJO> selectTransfer() {

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM transfer";
        Cursor cursor = db.rawQuery(query, null);

        //If the first column of the data base is null return;
        if (cursor.moveToFirst()) {
            ArrayList<Transfer_POJO> arrayList = new ArrayList<>();
            do {
                int count = 0;
                Transfer_POJO transfer_pojo = new Transfer_POJO();

                transfer_pojo.setDate(cursor.getString(1));
                transfer_pojo.setAccountGive(cursor.getString(2));
                transfer_pojo.setAccountTake(cursor.getString(3));
                transfer_pojo.setValue(cursor.getString(4));
                transfer_pojo.setDescription(cursor.getString(5));

                arrayList.add(count, transfer_pojo);
                count++;
            } while (cursor.moveToNext() != false);
            db.close();
            return arrayList;
        } else {
            return null;
        }

    }

}
