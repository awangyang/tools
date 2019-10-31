package com.example.tools.aspose;

import com.aspose.words.IImageSavingCallback;
import com.aspose.words.ImageSavingArgs;

import java.io.ByteArrayOutputStream;

/**
 * @author wangyang
 * @date 2019/10/31
 */
public class ImageSavingCallback implements IImageSavingCallback {

    @Override
    public void imageSaving(ImageSavingArgs imageSavingArgs) {
        imageSavingArgs.setImageStream(new ByteArrayOutputStream());
        imageSavingArgs.setKeepImageStreamOpen(false);
    }
}