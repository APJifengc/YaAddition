package io.github.apjifengc.yaaddition.recipe.excption;

/**
 * 配方种类不正确
 */
public class WrongRecipeTypeException extends Exception {

    private static final long serialVersionUID = -423822976320622245L;

    public WrongRecipeTypeException(String message) {
        super(message);
    }

}
