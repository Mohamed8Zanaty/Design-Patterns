package adapter.file_storage.good_design;

public class FileService {
    private Storage storage;

    public FileService(Storage storage) {
        this.storage = storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String saveFile(byte[] data, String filename) {
        return storage.save(data, filename);
    }

    public boolean deleteFile(String identifier) {
        return storage.delete(identifier);
    }
}
