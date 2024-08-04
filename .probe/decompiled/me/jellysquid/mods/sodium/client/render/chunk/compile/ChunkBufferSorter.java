package me.jellysquid.mods.sodium.client.render.chunk.compile;

import com.google.common.primitives.Floats;
import it.unimi.dsi.fastutil.ints.IntArrays;
import java.util.BitSet;
import me.jellysquid.mods.sodium.client.util.NativeBuffer;
import org.embeddedt.embeddium.render.chunk.sorting.TranslucentQuadAnalyzer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public class ChunkBufferSorter {

    private static final int ELEMENTS_PER_PRIMITIVE = 6;

    private static final int VERTICES_PER_PRIMITIVE = 4;

    private static final int FAKE_STATIC_CAMERA_OFFSET = 1000;

    public static int getIndexBufferSize(int numPrimitives) {
        return numPrimitives * 6 * 4;
    }

    public static NativeBuffer generateSimpleIndexBuffer(NativeBuffer indexBuffer, int numPrimitives, int offset) {
        int minimumRequiredBufferSize = getIndexBufferSize(numPrimitives) + offset * 4;
        if (indexBuffer.getLength() < minimumRequiredBufferSize) {
            throw new IllegalStateException("Given index buffer has length " + indexBuffer.getLength() + " but we need " + minimumRequiredBufferSize);
        } else {
            long ptr = MemoryUtil.memAddress(indexBuffer.getDirectBuffer()) + (long) offset * 4L;
            for (int primitiveIndex = 0; primitiveIndex < numPrimitives; primitiveIndex++) {
                int indexOffset = primitiveIndex * 6;
                int vertexOffset = primitiveIndex * 4;
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 0) * 4), vertexOffset + 0);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 1) * 4), vertexOffset + 1);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 2) * 4), vertexOffset + 2);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 3) * 4), vertexOffset + 2);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 4) * 4), vertexOffset + 3);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 5) * 4), vertexOffset + 0);
            }
            return indexBuffer;
        }
    }

    private static NativeBuffer generateIndexBuffer(NativeBuffer indexBuffer, int[] primitiveMapping) {
        int bufferSize = getIndexBufferSize(primitiveMapping.length);
        if (indexBuffer.getLength() != bufferSize) {
            throw new IllegalStateException("Given index buffer has length " + indexBuffer.getLength() + " but we expected " + bufferSize);
        } else {
            long ptr = MemoryUtil.memAddress(indexBuffer.getDirectBuffer());
            for (int primitiveIndex = 0; primitiveIndex < primitiveMapping.length; primitiveIndex++) {
                int indexOffset = primitiveIndex * 6;
                int vertexOffset = primitiveMapping[primitiveIndex] * 4;
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 0) * 4), vertexOffset + 0);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 1) * 4), vertexOffset + 1);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 2) * 4), vertexOffset + 2);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 3) * 4), vertexOffset + 2);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 4) * 4), vertexOffset + 3);
                MemoryUtil.memPutInt(ptr + (long) ((indexOffset + 5) * 4), vertexOffset + 0);
            }
            return indexBuffer;
        }
    }

    private static void buildStaticDistanceArray(float[] centers, float[] distanceArray, float x, float y, float z, float normX, float normY, float normZ, int quadCount, BitSet normalSigns) {
        for (int quadIdx = 0; quadIdx < quadCount; quadIdx++) {
            int centerIdx = quadIdx * 3;
            float qX = centers[centerIdx + 0] - x;
            float qY = centers[centerIdx + 1] - y;
            float qZ = centers[centerIdx + 2] - z;
            distanceArray[quadIdx] = (normX * qX + normY * qY + normZ * qZ) * (float) (normalSigns.get(quadIdx) ? 1 : -1);
        }
    }

    private static void buildDynamicDistanceArray(float[] centers, float[] distanceArray, int quadCount, float x, float y, float z) {
        for (int quadIdx = 0; quadIdx < quadCount; quadIdx++) {
            int centerIdx = quadIdx * 3;
            float qX = centers[centerIdx + 0] - x;
            float qY = centers[centerIdx + 1] - y;
            float qZ = centers[centerIdx + 2] - z;
            distanceArray[quadIdx] = qX * qX + qY * qY + qZ * qZ;
        }
    }

    public static NativeBuffer sort(NativeBuffer indexBuffer, @Nullable TranslucentQuadAnalyzer.SortState chunkData, float x, float y, float z) {
        if (chunkData != null && chunkData.level() != TranslucentQuadAnalyzer.Level.NONE && chunkData.centers().length >= 3) {
            float[] centers = chunkData.centers();
            int quadCount = centers.length / 3;
            int[] indicesArray = new int[quadCount];
            float[] distanceArray = new float[quadCount];
            boolean isStatic = chunkData.level() == TranslucentQuadAnalyzer.Level.STATIC;
            int quadIdx = 0;
            while (quadIdx < quadCount) {
                indicesArray[quadIdx] = quadIdx++;
            }
            if (isStatic) {
                buildStaticDistanceArray(centers, distanceArray, centers[0] + chunkData.sharedNormal().x * 1000.0F, centers[1] + chunkData.sharedNormal().y * 1000.0F, centers[2] + chunkData.sharedNormal().z * 1000.0F, chunkData.sharedNormal().x, chunkData.sharedNormal().y, chunkData.sharedNormal().z, quadCount, chunkData.normalSigns());
            } else {
                buildDynamicDistanceArray(centers, distanceArray, quadCount, x, y, z);
            }
            IntArrays.mergeSort(indicesArray, (a, b) -> Floats.compare(distanceArray[b], distanceArray[a]));
            return generateIndexBuffer(indexBuffer, indicesArray);
        } else {
            return indexBuffer;
        }
    }
}