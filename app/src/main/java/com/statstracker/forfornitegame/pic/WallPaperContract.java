package com.statstracker.forfornitegame.pic;

import com.statstracker.forfornitegame.base.BasePresenter;
import com.statstracker.forfornitegame.base.BaseView;
import com.statstracker.forfornitegame.pic.bean.WallPaperBean;
import com.statstracker.forfornitegame.video.bean.VideoItemBean;

import java.util.List;

public class WallPaperContract {

    public interface View extends BaseView<Presenter> {

    }

    public interface Presenter extends BasePresenter<View> {
        List<WallPaperBean> getWallPapers();
    }


}
