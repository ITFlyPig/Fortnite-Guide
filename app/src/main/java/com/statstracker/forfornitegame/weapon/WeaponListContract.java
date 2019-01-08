package com.statstracker.forfornitegame.weapon;

import com.statstracker.forfornitegame.base.BasePresenter;
import com.statstracker.forfornitegame.base.BaseView;
import com.statstracker.forfornitegame.video.bean.VideoItemBean;
import com.statstracker.forfornitegame.weapon.bean.WeaponBean;

import java.util.List;

public class WeaponListContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {
        List<WeaponBean> getData(String language);
        List<WeaponBean> getThrowWeaponData(String language);
        List<WeaponBean> getMeleeData(String language);
    }


}
