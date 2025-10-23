package com.goby56.wakes.worldrender;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public class WorldRenderContextImpl implements WorldRenderContext.BlockOutlineContext, WorldRenderContext {
    private WorldRenderer worldRenderer;
    private RenderTickCounter tickCounter;
    private boolean blockOutlines;
    private Camera camera;
    private GameRenderer gameRenderer;
    private Matrix4f positionMatrix;
    private Matrix4f projectionMatrix;
    private VertexConsumerProvider consumers;
    private boolean advancedTranslucency;
    private ClientWorld world;
    @Nullable
    private Frustum frustum;
    @Nullable
    private MatrixStack matrixStack;
    private boolean translucentBlockOutline;
    private Entity entity;
    private double cameraX;
    private double cameraY;
    private double cameraZ;
    private BlockPos blockPos;
    private BlockState blockState;


    public void prepare(
            WorldRenderer worldRenderer,
            RenderTickCounter tickCounter,
            boolean blockOutlines,
            Camera camera,
            GameRenderer gameRenderer,
            Matrix4f positionMatrix,
            Matrix4f projectionMatrix,
            VertexConsumerProvider consumers,
            boolean advancedTranslucency,
            ClientWorld world
    ){
        this.worldRenderer = worldRenderer;
        this.tickCounter = tickCounter;
        this.blockOutlines = blockOutlines;
        this.camera = camera;
        this.gameRenderer = gameRenderer;
        this.positionMatrix = positionMatrix;
        this.projectionMatrix = projectionMatrix;
        this.consumers = consumers;
        this.advancedTranslucency = advancedTranslucency;
        this.world = world;

        frustum = null;
        matrixStack = null;
    }

    public void setFrustum(Frustum frustum) {
        this.frustum = frustum;
    }

    public void setMatrixStack(MatrixStack matrixStack) {
        this.matrixStack = matrixStack;
    }

    public void setTranslucentBlockOutline(boolean translucentBlockOutline) {
        this.translucentBlockOutline = translucentBlockOutline;
    }

    public void prepareBlockOutline(
            Entity entity,
            double cameraX,
            double cameraY,
            double cameraZ,
            BlockPos blockPos,
            BlockState blockState
    ) {
        this.entity = entity;
        this.cameraX = cameraX;
        this.cameraY = cameraY;
        this.cameraZ = cameraZ;
        this.blockPos = blockPos;
        this.blockState = blockState;
    }

    @Override
    public WorldRenderer worldRenderer() {
        return worldRenderer;
    }

    @Override
    public RenderTickCounter tickCounter() {
        return this.tickCounter;
    }

    @Override
    public boolean blockOutlines() {
        return blockOutlines;
    }

    @Override
    public Camera camera() {
        return camera;
    }

    @Override
    public GameRenderer gameRenderer() {
        return gameRenderer;
    }

    @Override
    public Matrix4f positionMatrix() {
        return positionMatrix;
    }

    @Override
    public Matrix4f projectionMatrix() {
        return projectionMatrix;
    }

    @Override
    public ClientWorld world() {
        return world;
    }

    @Override
    public boolean advancedTranslucency() {
        return advancedTranslucency;
    }

    @Override
    public VertexConsumerProvider consumers() {
        return consumers;
    }

    @Override
    @Nullable
    public Frustum frustum() {
        return frustum;
    }

    @Override
    @Nullable
    public MatrixStack matrixStack() {
        return matrixStack;
    }

    @Override
    public boolean translucentBlockOutline() {
        return translucentBlockOutline;
    }

    @Override
    public Entity entity() {
        return entity;
    }

    @Override
    public double cameraX() {
        return cameraX;
    }

    @Override
    public double cameraY() {
        return cameraY;
    }

    @Override
    public double cameraZ() {
        return cameraZ;
    }

    @Override
    public BlockPos blockPos() {
        return blockPos;
    }

    @Override
    public BlockState blockState() {
        return blockState;
    }
}
