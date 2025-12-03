package adapter.file_storage.good_design;

public interface Storage {
    String save(byte[] data, String filename);
    boolean delete(String identifier);
}
