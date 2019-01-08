package com.statstracker.forfornitegame.pic.presenter;

import com.statstracker.forfornitegame.pic.WallPaperContract;
import com.statstracker.forfornitegame.pic.bean.WallPaperBean;
import com.statstracker.forfornitegame.pic.model.WallPaperModle;
import com.statstracker.forfornitegame.video.VideoListContract;
import com.statstracker.forfornitegame.video.VideoListModle;
import com.statstracker.forfornitegame.video.bean.VideoItemBean;

import java.util.List;

public class WallPaperPresenter implements WallPaperContract.Presenter {

    private WallPaperContract.View mView;
    private WallPaperModle mModle;


    @Override
    public void start() {

    }

    public WallPaperPresenter(WallPaperContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
        mModle = new WallPaperModle();

    }

    @Override
    public List<WallPaperBean> getWallPapers() {
        return mModle.getAllWallPaper();
    }
}
