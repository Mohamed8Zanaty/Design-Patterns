package adapter.file_storage.bad_design;

import adapter.file_storage.providor.LocalDiskSDK;
import adapter.file_storage.providor.S3SDK;

public class FileService {
    private final LocalDiskSDK local = new LocalDiskSDK();
    private final S3SDK s3 = new S3SDK();
    private final String defaultBucket = "my-app-bucket";

    public String saveFile(String provider, byte[] data, String filename) {
        if ("local".equalsIgnoreCase(provider)) {
            return local.writeFile(data, filename);
        } else if ("s3".equalsIgnoreCase(provider)) {
            // S3 needs bucket + key; also order of params differs
            return s3.upload(data, defaultBucket, filename);
        } else {
            throw new IllegalArgumentException("Unknown provider: " + provider);
        }
    }

    public boolean deleteFile(String provider, String identifier) {
        if ("local".equalsIgnoreCase(provider)) {
            return local.remove(identifier); // identifier is a path
        } else if ("s3".equalsIgnoreCase(provider)) {
            // identifier is a URL; we must parse bucket/key or rely on known bucket
            String key = extractKeyFromUrl(identifier);
            s3.deleteObject(defaultBucket, key);
            return true;
        } else {
            throw new IllegalArgumentException("Unknown provider: " + provider);
        }
    }

    private String extractKeyFromUrl(String url) {
        // quick-and-dirty parsing used inline (example fragile code)
        int lastSlash = url.lastIndexOf('/');
        return (lastSlash >= 0) ? url.substring(lastSlash + 1) : url;
    }
}
