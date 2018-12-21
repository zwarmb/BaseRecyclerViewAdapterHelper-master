package com.example.yida.qq.api.model.team;

import com.netease.nimlib.sdk.team.model.Team;

import java.util.List;

/**
 * Created by yida on 2018/10/29.
 */
public interface TeamDataChangedObserver {

    /**
     * 群更新
     *
     * @param teams 群列表
     */
    void onUpdateTeams(List<Team> teams);

    /**
     * 群删除
     *
     * @param team) 群
     */
    void onRemoveTeam(Team team);

}
