package com.statstracker.forfornitegame.video;

import com.statstracker.forfornitegame.base.BasePresenter;
import com.statstracker.forfornitegame.base.BaseView;
import com.statstracker.forfornitegame.video.bean.VideoItemBean;

import java.util.List;

public class VideoListContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {
        List<VideoItemBean> getPcData(String language);
        List<VideoItemBean> getModileData(String language);
        List<VideoItemBean> getFunnyData(String language);
    }


}
