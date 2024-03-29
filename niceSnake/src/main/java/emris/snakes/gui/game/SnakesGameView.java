package emris.snakes.gui.game;

import emris.snakes.game.SnakesGameInfo;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface SnakesGameView {

    @Contract(mutates = "this")
    void makeVisible();

    /**
     * Render any changes happened to the model this view is bound to
     * @throws IllegalStateException if not bound to any model
     */
    @Contract(mutates = "this")
    void updateView() throws IllegalStateException;

    /**
     * Bind this view to a model
     * @param gameState game model to bind to
     */
    @Contract(mutates = "this")
    void bindTo(final @NotNull SnakesGameInfo gameState);

    @Contract(mutates = "this")
    void setPreferredColour(final int playerId, final @NotNull Color color);

    @NotNull Color getColour(final int playerId);

    @Contract(mutates = "this")
    void follow(final int playerId);

    @Nullable Integer getFollowedPlayer();

    void unfollow();

    @NotNull BiConsumer<@NotNull Integer, @NotNull Runnable> getKeyBindingsRegisterer();

    @NotNull Consumer<@NotNull Runnable> getExitHookRegisterer();

    @NotNull Consumer<@NotNull Runnable> getLeaveHookRegisterer();

    void executeLeaveHooks();
}
