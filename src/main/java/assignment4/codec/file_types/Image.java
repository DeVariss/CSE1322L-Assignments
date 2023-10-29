package assignment4.codec.file_types;

import assignment4.codec.standards.IImageStandard;

public class Image extends Media implements IImageStandard {
    private String imageCodec;

    public Image(String fileName, String imageCodec) {
        super(fileName);
        this.imageCodec = imageCodec;
    }

    public String getImageCodec() { return "Image Codec: " + this.imageCodec; }

    public String getMediaInfo() {
        return "Image ID: " + getID() + "\nImage name: " + getFileName() + "\n" + getImageCodec();
    }
}
