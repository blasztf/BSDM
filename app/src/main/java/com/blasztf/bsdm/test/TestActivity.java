package com.blasztf.bsdm.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.blasztf.bsdm.MainActivity;
import com.blasztf.bsdm.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Deprecated
public class TestActivity extends AppCompatActivity implements TestLog {

    private static final boolean TEST_STATE = true;

    private EditText tEditText;

    @Deprecated
    public static void start(Activity that) {
        ass();
        Intent intent = new Intent(that, TestActivity.class);
        that.startActivity(intent);
    }

    @Deprecated
    private static void ass() {
        dessert(TEST_STATE, "TestErr");
    }

    // assert android
    @Deprecated
    private static void dessert(boolean condition) {
        if (!condition) throw new RuntimeException();
    }

    // assert android
    @Deprecated
    private static void dessert(boolean condition, String error) {
        if (!condition) throw new RuntimeException(error);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tactivity_test);
        prepareChildView();
        log("===LOG===");
        debug();
        log("===END===");

    }

    private void debug() {
        TestObj test = createTest(BlueObj.class);
        test.start();
    }

    private <T extends TestObj> T createTest(Class<T> clazz) {
        try {
            Constructor<T> ctor = clazz.getDeclaredConstructor(TestLog.class);
            return ctor.newInstance(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Hmmm?");
    }

    private void prepareChildView() {
        tEditText = findViewById(R.id.tEditText);
    }

    @Override
    public void log(String text) {
        ass();
        dessert(tEditText != null);
        tEditText.getText().append(text).append("\n");
    }

}