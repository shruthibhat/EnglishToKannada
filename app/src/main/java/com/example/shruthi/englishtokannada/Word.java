package com.example.shruthi.englishtokannada;

/**
 * Created by shruthi on 4/21/17.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_AUDIO_PROVIDED = -1;
    private int mAudioResourceId = NO_AUDIO_PROVIDED;
    private String mDefaultTranslation;
    private String mKannadaTranslation;

    public Word(String defaultTranslation,String KannadaTranslation,int AudioResourceId )
    {
        mDefaultTranslation=defaultTranslation;
        mKannadaTranslation=KannadaTranslation;
        mAudioResourceId=AudioResourceId;

    }

    public Word(String defaultTranslation,String KannadaTranslation,int ImageResourceId,int AudioResourceId )
    {
        mDefaultTranslation=defaultTranslation;
        mKannadaTranslation=KannadaTranslation;
        mImageResourceId=ImageResourceId;
        mAudioResourceId=AudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getmKannadaTranslation() {
        return mKannadaTranslation;
    }

    public void setmKannadaTranslation(String mKannadaTranslation) {
        this.mKannadaTranslation = mKannadaTranslation;
    }


    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public void setmAudioResourceId(int mAudioResourceId) {
        this.mAudioResourceId = mAudioResourceId;
    }

    public boolean hasAudio() {
        return mAudioResourceId != NO_IMAGE_PROVIDED;
    }

}
