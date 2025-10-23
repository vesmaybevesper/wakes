package com.goby56.wakes.mixin.events;

import com.goby56.wakes.worldrender.WorldRenderContextImpl;
import com.goby56.wakes.worldrender.WorldRenderEvents;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.util.Handle;
import net.minecraft.util.profiler.Profiler;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Unique
    private final WorldRenderContextImpl context = new WorldRenderContextImpl();

    @Inject(method = "method_62214", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;debugRenderer:Lnet/minecraft/client/render/debug/DebugRenderer;", ordinal = 0))
    private void beforeDebugRender(GpuBufferSlice gpuBufferSlice, WorldRenderState worldRenderState, Profiler profiler, Matrix4f matrix4f, Handle handle, Handle handle2, boolean bl, Frustum frustum, Handle handle3, Handle handle4, CallbackInfo ci){
        WorldRenderEvents.BEFORE_DEBUG_RENDER.invoker().beforeDebugRender(context);
    }
}
