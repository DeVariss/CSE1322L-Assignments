package assignment4.codec.file_types;

import assignment4.codec.standards.IAudioStandard;

public class Music extends Media implements IAudioStandard {
    private String audioCodec;

    public Music(String fileName, String audioCodec) {
        super(fileName);
        this.audioCodec = audioCodec;
    }

    public String getAudioCodec() { return "Audio Codec: " + this.audioCodec; }

    public String getMediaInfo() {
        return "Music ID: " + getID() + "\nMusic name: " + getFileName() + "\n" + getAudioCodec();
    }
}
