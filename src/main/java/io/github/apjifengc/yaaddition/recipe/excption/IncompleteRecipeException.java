package io.github.apjifengc.yaaddition.recipe.excption;

/**
 * 配方不完整
 */
public class IncompleteRecipeException extends Exception {

    private static final long serialVersionUID = 9124861022962441864L;

    public IncompleteRecipeException(String message) {
        super(message);
    }

}
