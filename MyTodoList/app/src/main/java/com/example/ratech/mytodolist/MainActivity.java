package com.example.ratech.mytodolist;

import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ratech.mytodolist.data.TodoListContract;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

//import edu.galileo.todolist.AddTaskDialogFragment.AddTaskDialogListener;
//import edu.galileo.todolist.TodoCursorAdapter.ToggleTodoCheckListener;
//import edu.galileo.todolist.data.TodoListContract.TodoEntry;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<Cursor>,
        AddTaskDialogFragment.AddTaskDialogListener,
        TodoCursorAdapter.ToggleTodoCheckListener {

    private TodoCursorAdapter cursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setHasFixedSize(true);

        cursorAdapter = new TodoCursorAdapter(null, this);
        mRecyclerView.setAdapter(cursorAdapter);

        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.floating_action_btn);
        actionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTaskDialogFragment dialogFragment = new AddTaskDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "addTask");
            }
        });

        getSupportLoaderManager().initLoader(0, null, this);

        showNotification();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                this,
                TodoListContract.TodoEntry.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }

    @Override
    public void onDialogPositiveClick(String stringValue) {
        if (!TextUtils.isEmpty(stringValue)) {
            getContentResolver().insert(
                    TodoListContract.TodoEntry.CONTENT_URI,
                    getTodoListContentValues(stringValue)
            );
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    @Override
    public void onTodoItemChange(int todoID, boolean done) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TodoListContract.TodoEntry.COLUMN_DONE, done ? 1 : 0);
        String[] mSelectionArgs = {Integer.toString(todoID)};
        getContentResolver().update(
                TodoListContract.TodoEntry.CONTENT_URI,
                contentValues, TodoListContract.TodoEntry.WHERE_TODO_ID,
                mSelectionArgs
        );
    }

    private ContentValues getTodoListContentValues(String stringValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TodoListContract.TodoEntry.COLUMN_DESC, stringValue);
        contentValues.put(
                TodoListContract.TodoEntry.COLUMN_DATETEXT,
                Calendar.getInstance().getTimeInMillis()
        );
        return contentValues;
    }


    // the following is for L5_Chapter3_Notifications
    public static final int NOTIFICATION_ID = 1;

    private void showNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Notification success" );

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // NOTIFICATION_ID allows you to update the notification later on
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }

}
