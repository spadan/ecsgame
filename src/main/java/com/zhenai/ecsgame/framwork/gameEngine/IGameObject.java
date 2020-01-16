package com.zhenai.ecsgame.framwork.gameEngine;

public interface IGameObject {


    public enum GameState{
        STATE_START,
        STATE_ING,
        STATE_END
    }


    /**
     * 游戏驱动
     */
    void gameUpdate();


    /**
     * 调用结束GameObject
     */
    void destory() throws Exception;

    /**
     * 获取游戏状态
     * @return
     */

    GameState getGameState();



    /**
     * 设置游戏状态
     * @param state
     */
    void setGameState(GameState state) throws Exception;
}
