package io.raisehand.tutorialoverlay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import uk.co.deanwild.materialshowcaseview.IShowcaseListener;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] ids = new String[]{"one", "two"};
        final int delay = 600;

        // single example

        new MaterialShowcaseView.Builder(MainActivity.this)
                .setTarget(findViewById(R.id.fetch_button))
                .setDismissText("Oh! I See")
                .setContentText("Smash this button to see all the products of this shop.")
                .setDelay(delay * 3) // optional but starting animations immediately in onCreate can make them choppy
                .singleUse("First") // provide a unique ID used to ensure it is only shown once
                .renderOverNavigationBar()
                .setMaskColour(getResources().getColor(R.color.colorPrimaryDarkTrans))
                .setDismissOnTargetTouch(true)
                .setDismissOnTouch(true)
                .setListener(new IShowcaseListener() {
                    @Override
                    public void onShowcaseDisplayed(MaterialShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseDismissed(MaterialShowcaseView showcaseView) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                new MaterialShowcaseView.Builder(MainActivity.this)
                                        .setTarget(findViewById(R.id.cancel_button))
                                        .setDismissText("Oh! OK")
                                        .setContentText("You can cancel in the middle.")
                                        .setDelay(delay) // optional but starting animations immediately in onCreate can make them choppy
                                        .singleUse("Second") // provide a unique ID used to ensure it is only shown once
                                        .renderOverNavigationBar()
                                        .setMaskColour(getResources().getColor(R.color.colorPrimaryDarkTrans))
                                        .setDismissOnTargetTouch(true)
                                        .setDismissOnTouch(true)
                                        .show();
                            }
                        }, 600);
                    }
                })
                .show();


        // sequence example
        /*
        ShowcaseConfig config = new ShowcaseConfig();
        config.setRenderOverNavigationBar(true);
        config.getRenderOverNavigationBar();
        config.setMaskColor(Color.BLACK);
        config.setContentTextColor(Color.WHITE);
        config.setDismissTextColor(Color.WHITE);
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(MainActivity.this, ids[0]);

        sequence.setConfig(config);

        sequence.addSequenceItem(findViewById(R.id.fetch_button),
                "Smash this button to see all the products of this shop.", "OK FINE");

        sequence.addSequenceItem(findViewById(R.id.cancel_button),
                "You can cancel in the middle.", "Oh! OK");

        sequence.start();
        */

    }
}
