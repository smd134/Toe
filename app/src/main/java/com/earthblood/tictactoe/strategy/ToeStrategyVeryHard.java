package com.earthblood.tictactoe.strategy;

import com.earthblood.tictactoe.util.GameSymbol;

/**
 * @author John Piser developer@earthblood.com
 *         Copyright 2014.
 */
public class ToeStrategyVeryHard implements ToeStrategy{

    private final int[] selectedXBoxIds;
    private final int[] selectedOBoxIds;
    private final GameSymbol androidSymbol;

    public ToeStrategyVeryHard(int[] selectedXBoxIds, int[] selectedOBoxIds, GameSymbol androidSymbol) {
        this.selectedXBoxIds = selectedXBoxIds;
        this.selectedOBoxIds = selectedOBoxIds;
        this.androidSymbol   = androidSymbol;
    }

    @Override
    public int getBoxId() {

        StrategyItemPickRandomBox  pickRandom          = new StrategyItemPickRandomBox();
        StrategyItemPickMiddleBox  pickMiddle          = new StrategyItemPickMiddleBox(pickRandom);
        StrategyItemDefensiveHigh  pickDefensiveHigh   = new StrategyItemDefensiveHigh(pickMiddle);
        StrategyItemOffensive      pickOffensive       = new StrategyItemOffensive(pickDefensiveHigh);


        return pickOffensive.execute(selectedXBoxIds, selectedOBoxIds, androidSymbol);
    }

    @Override
    public GameSymbol getSymbol() {
        return androidSymbol;
    }
}
