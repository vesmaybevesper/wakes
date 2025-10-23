package com.goby56.wakes.worldrender;

import com.google.common.base.Preconditions;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public interface WorldRenderContext {
    static WorldRenderContext getInstance(WorldRenderer worldRenderer){
        Preconditions.checkNotNull(worldRenderer, "worldRenderer");
        return ((WorldRenderHooks) worldRenderer).getWorldRenderContext();
    }

    WorldRenderer worldRenderer();

    RenderTickCounter tickCounter();

    boolean blockOutlines();

    Camera camera();

    GameRenderer gameRenderer();

    Matrix4f positionMatrix();

    Matrix4f projectionMatrix();

    ClientWorld world();

    boolean advancedTranslucency();

    @Nullable
    VertexConsumerProvider consumers();

    @Nullable
    Frustum frustum();

    @Nullable
    MatrixStack matrixStack();

    boolean translucentBlockOutline();

    interface BlockOutlineContext{
        Entity entity();

        double cameraX();

        double cameraY();

        double cameraZ();

        BlockPos blockPos();

        BlockState blockState();
    }
}
