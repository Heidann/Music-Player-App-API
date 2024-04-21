package com.example.music_player_api;

import java.util.List;

public class AlbumClass {
    public static class AlbumResponse {
        private List<Album> albums;

        // Getter và setter
    }

    public static class Album {
        private String albumType;
        private List<Artist> artists;
        private List<Copyright> copyrights;
        private ExternalIds externalIds;
        private ExternalUrls externalUrls;
        private List<String> genres;
        private String id;
        private List<Image> images;
        private boolean isPlayable;
        private String label;
        private String name;
        private int popularity;
        private String releaseDate;
        private String releaseDatePrecision;
        private int totalTracks;
        private Tracks tracks;

        // Getter và setter
    }

    public static class Artist {
        private ExternalUrls externalUrls;
        private String id;
        private String name;
        private String type;
        private String uri;

        // Getter và setter
    }

    public static class Copyright {
        private String text;
        private String type;

        // Getter và setter
    }

    public static class ExternalIds {
        private String upc;

        // Getter và setter
    }

    public static class ExternalUrls {
        private String spotify;

        // Getter và setter
    }

    public static class Image {
        private int height;
        private String url;
        private int width;

        // Getter và setter
    }

    public static class Tracks {
        private List<TrackItem> items;
        private int limit;
        private String next;
        private int offset;
        private String previous;
        private int total;

        // Getter và setter
    }

    public static class TrackItem {
        private List<Artist> artists;
        private int discNumber;
        private long durationMs;
        private boolean isExplicit;
        private ExternalUrls externalUrls;
        private String id;
        private boolean isLocal;
        private boolean isPlayable;
        private String name;
        private String previewUrl;
        private int trackNumber;
        private String type;
        private String uri;

        // Getter và setter
    }
}