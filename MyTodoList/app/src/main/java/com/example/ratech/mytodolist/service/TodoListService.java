package com.example.ratech.mytodolist.service;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.ratech.mytodolist.data.TodoListContract;

public class TodoListService extends IntentService {

    public static final String EXTRA_TASK_DESCRIPTION = "EXTRA_TASK_DESCRIPTION";

    public TodoListService(String name) {
        super("TodoListService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String taskdescription = intent.getStringExtra("EXTRA_TASK_DESCRIPTION");

        ContentValues contentValues = new ContentValues();
        contentValues.put(TodoListContract.TodoEntry.COLUMN_DESCRIPTION, taskdescription);

        getContentResolver().insert(TodoListContract.TodoEntry.CONTENT_URI, contentValues);
    }

}
