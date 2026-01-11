package com.example.task11_ya_thereal;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

/**
 * The MainActivity class manages the main user interface with five buttons,
 * each demonstrating a different type of AlertDialog functionality.
 * * @author Darya Hamalca
 * @version 1.0
 * @since 12/01/2026
 */
public class MainActivity extends AppCompatActivity
{
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    ConstraintLayout mainLayout;
    Random rnd = new Random();


    /**
     * Initializes the options menu for the activity.
     * <p>
     * This method inflates the menu resource into the existing menu.
     *
     * @param menu The options menu in which you place your items.
     * @return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    /**
     * Handles action bar item clicks.
     * <p>
     * This method is called whenever an item in your options menu is selected.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_credits)
        {
            Intent intent = new Intent(this, Credits.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the activity is first created.
     * <p>
     * Sets up the layout, initializes buttons, and assigns click listeners for each dialog trigger.
     * * @param savedInstanceState Bundle containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        mainLayout = findViewById(R.id.main);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog1();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog2();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog3();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog4();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog5();
            }
        });

    }

    /**
     * Displays a simple message dialog.
     * <p>
     * Requirement: Dialog with message only.
     */
    private void showDialog1()
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Message 1");
        adb.setMessage("albert is ok????");
        adb.show();
    }

    /**
     * Displays a message dialog with an icon.
     * <p>
     * Requirement: Dialog with message and an illustration (icon).
     */
    private void showDialog2()
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Message with Icon");
        adb.setMessage("albart ze svava?\n");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.show();
    }

    /**
     * Displays a dialog with message, icon, and a close button.
     * <p>
     * Requirement: Dialog with illustration and a close action.
     */
    private void showDialog3()
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Button 3");
            adb.setMessage("This one has a message, an icon, and a button!");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setNeutralButton("Close", null);
        adb.show();
    }

    /**
     * Displays a persistent dialog to change background colors.
     * <p>
     * Requirement: Change background to a random color and include a close button.
     */
    private void showDialog4() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Background Changer");
        adb.setMessage("Keep clicking 'Random' to change colors!");
        adb.setPositiveButton("Random Color", null);
        adb.setNeutralButton("Close", null);
        final AlertDialog ad = adb.create();
        ad.show();
        ad.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                mainLayout.setBackgroundColor(color);
            }
        });
    }

    /**
     * Displays a dialog with three control options.
     * <p>
     * Requirement: Options for random color, reset to white, and close button.
     */
    private void showDialog5() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Background Control");
        adb.setMessage("Choose an action for the background:");

        adb.setPositiveButton("Random", null);
        adb.setNegativeButton("White", null);
        adb.setNeutralButton("Close", null);
        final AlertDialog ad = adb.create();
        ad.show();
        ad.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                mainLayout.setBackgroundColor(color);
            }
        });
        ad.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.WHITE);
            }
        });
    }
}