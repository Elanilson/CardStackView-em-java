package com.apkdoandroid.giftcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.apkdoandroid.giftcard.adapter.CardStackAdapter;
import com.apkdoandroid.giftcard.model.Spot;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStackListener {
    private CardStackView cardStackView;
    private CardStackLayoutManager manager ;
    private CardStackAdapter adapter;
    private SwipeAnimationSetting setting;
    private FloatingActionButton buttonLike, buttonDeslike,buttonparabaixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       cardStackView = findViewById(R.id.card_stack_view);
       manager = new CardStackLayoutManager(this,this);
       adapter = new CardStackAdapter(createSpots());
       buttonLike = findViewById(R.id.like_button);
       buttonDeslike = findViewById(R.id.skip_button);
       buttonparabaixo = findViewById(R.id.rewind_button);
       buttonparabaixo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               parabaixo();
           }
       });
       buttonDeslike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               deslike();
           }
       });
       buttonLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               like();
           }
       });

        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(true);
//        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
//        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);

    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }

    private List<Spot> createSpots(){
        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot(1L, "Yasaka Shrine",  "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        spots.add(new Spot( 2L, "Fushimi Inari Shrine",  "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        spots.add(new Spot( 3L, "Bamboo Forest",  "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        spots.add(new Spot( 4L, "Brooklyn Bridge",  "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        spots.add(new Spot( 5L, "Empire State Building",  "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"));
        spots.add(new Spot( 6L, "The statue of Liberty",  "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        spots.add(new Spot( 7L, "Louvre Museum",  "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"));
        spots.add(new Spot( 8L, "Eiffel Tower",  "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"));
        spots.add(new Spot( 9L, "Big Ben",  "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"));
        spots.add(new Spot( 10L, "Great Wall of China",  "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"));

        return spots;

    }
    public void deslike(){
        setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(1000)
                .build();
        manager.setSwipeAnimationSetting(setting);
        cardStackView.swipe();
    }
    private  void parabaixo(){
        setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(1000)
                .build();
        manager.setSwipeAnimationSetting(setting);
        cardStackView.rewind();
    }
    private void like(){
        setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(1000)
                .build();
        manager.setSwipeAnimationSetting(setting);
        cardStackView.swipe();

    }
}