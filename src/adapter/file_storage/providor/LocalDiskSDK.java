package adapter.file_storage.providor;

public class LocalDiskSDK {
    public String writeFile(byte[] data, String filename) {
        String path = "/var/data/" + filename;
        System.out.println("[LocalDiskSDK] Wrote " + filename + " to " + path);
        return path;
    }

    public boolean remove(String path) {
        System.out.println("[LocalDiskSDK] Removed " + path);
        return true;
    }
}
