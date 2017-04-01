package me.saket.dank.data;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import me.saket.dank.di.DankApi;

/**
 * API response for {@link DankApi#streamableVideoDetails(String)}.
 */
@AutoValue
public abstract class StreamableVideoResponse {

    @Json(name = "files")
    public abstract Files files();

    @AutoValue
    public abstract static class Files {
        @Json(name = "mp4")
        public abstract Video highQualityVideo();

        @Json(name = "mp4-mobile")
        public abstract Video lowQualityVideo();

        public static JsonAdapter<Files> jsonAdapter(Moshi moshi) {
            return new AutoValue_StreamableVideoResponse_Files.MoshiJsonAdapter(moshi);
        }
    }

    @AutoValue
    public abstract static class Video {
        @Json(name = "url")
        public abstract String url();

        public static JsonAdapter<Video> jsonAdapter(Moshi moshi) {
            return new AutoValue_StreamableVideoResponse_Video.MoshiJsonAdapter(moshi);
        }
    }

    public static JsonAdapter<StreamableVideoResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_StreamableVideoResponse.MoshiJsonAdapter(moshi);
    }

}