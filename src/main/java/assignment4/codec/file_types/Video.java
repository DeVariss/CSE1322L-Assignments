package assignment4.codec.file_types;

import codec.standards.IAudioStandard;
import codec.standards.IImageStandard;

public class Video extends Media implements IImageStandard, IAudioStandard {
    private String imageCodec;
    private String audioCodec;

    public Video (String fileName, String imageCodec, String audioCodec) {
        super(fileName);
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }

    public String getImageCodec() { return "Image codec: " + this.imageCodec; }

    public String getAudioCodec() { return "Audio codec: " + this.audioCodec; }

    public String getMediaInfo() {
        return "Video ID: " + getID() + "\nVideo name: " + getFileName() + "\n" + getImageCodec() + "\n" + getAudioCodec();
    }
}
