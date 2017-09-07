package com.lost.temple.commonframe.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.LinearLayout;

import com.lost.temple.commonframe.R;
import com.lost.temple.commonframe.fragment.ContactsFragment;
import com.lost.temple.commonframe.fragment.MessageFragment;
import com.lost.temple.commonframe.fragment.MineFragment;
import com.lost.temple.commonframe.widget.QQNaviView;

public class MainActivity extends FragmentActivity {

    private QQNaviView menu_message;
    private QQNaviView menu_contacts;
    private QQNaviView menu_mine;

    private MessageFragment messageFragment;
    private ContactsFragment contactsFragment;
    private MineFragment mineFragment;

    private LinearLayout ll_frame;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        messageFragment = new MessageFragment();
        contactsFragment = new ContactsFragment();
        mineFragment = new MineFragment();


        ll_frame = findViewById(R.id.ll_frame);
        fragmentManager.beginTransaction().add(R.id.ll_frame, messageFragment)
                .add(R.id.ll_frame, mineFragment)
                .add(R.id.ll_frame, contactsFragment).commit();
    }

    private void initView() {

        menu_message = (QQNaviView) findViewById(R.id.menu_message);
        menu_contacts = (QQNaviView) findViewById(R.id.menu_contacts);
        menu_mine = (QQNaviView) findViewById(R.id.menu_mine);

    }

    public void onClick(View view) {

        resetIcon();

        switch (view.getId()) {
            case R.id.menu_message:
                menu_message.setBigIcon(R.mipmap.bubble_big);
                menu_message.setSmallIcon(R.mipmap.bubble_small);
                fragmentManager.beginTransaction().replace(R.id.ll_frame, messageFragment).commit();

                break;
            case R.id.menu_contacts:
                menu_contacts.setBigIcon(R.mipmap.person_big);
                menu_contacts.setSmallIcon(R.mipmap.person_small);
                fragmentManager.beginTransaction().replace(R.id.ll_frame, contactsFragment).commit();

                break;

            case R.id.menu_mine:
                menu_mine.setSmallIcon(R.mipmap.star_small);
                menu_mine.setBigIcon(R.mipmap.star_big);
                fragmentManager.beginTransaction().replace(R.id.ll_frame, mineFragment).commit();

                break;
            default:
                break;

        }

    }


    private void resetIcon() {

        menu_message.setBigIcon(R.mipmap.pre_bubble_big);
        menu_message.setSmallIcon(R.mipmap.pre_bubble_small);

        menu_contacts.setBigIcon(R.mipmap.pre_person_big);
        menu_contacts.setSmallIcon(R.mipmap.pre_person_small);

        menu_mine.setBigIcon(R.mipmap.pre_star_big);
        menu_mine.setSmallIcon(R.mipmap.pre_star_small);

    }
}
