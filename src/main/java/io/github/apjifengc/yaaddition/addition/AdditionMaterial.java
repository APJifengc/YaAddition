package io.github.apjifengc.yaaddition.addition;

import io.github.apjifengc.yaaddition.core.state.State;

abstract public class AdditionMaterial {
    public final State state;

    protected AdditionMaterial(State stata) {
        this.state = stata;
    }
}
