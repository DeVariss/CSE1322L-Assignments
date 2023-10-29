package assignment4.codec.file_types;

public abstract class Media {
    private static int nextId;

    private String fileName;
    private final int ID = nextId;

    public Media() { nextId++; }

    public Media(String fileName) {
        this();
        this.fileName = fileName;
    }

    public int getID() { return this.ID; }
    public String getFileName() { return this.fileName; }
}
