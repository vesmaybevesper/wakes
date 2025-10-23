package com.goby56.wakes.worldrender;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class WorldRenderEvents {
    private WorldRenderEvents(){}


    public static final Event<DebugRender> BEFORE_DEBUG_RENDER = EventFactory.createArrayBacked(DebugRender.class, context -> {}, callbacks -> context ->{
        for (final DebugRender callback: callbacks){
            callback.beforeDebugRender(context);
        }
    });

    public static final Event<AfterTranslucent> AFTER_TRANSLUCENT = EventFactory.createArrayBacked(AfterTranslucent.class, context -> {}, callbacks -> context -> {
        for (final AfterTranslucent callback : callbacks){
            callback.afterTranslucent(context);
        }
    });

    @FunctionalInterface
    public interface DebugRender{
        void beforeDebugRender(WorldRenderContext context);
    }

    @FunctionalInterface
    public interface AfterTranslucent{
        void afterTranslucent(WorldRenderContext context);
    }
}
