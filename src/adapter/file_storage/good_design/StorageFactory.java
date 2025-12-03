package adapter.file_storage.good_design;

import adapter.file_storage.providor.LocalDiskSDK;
import adapter.file_storage.providor.S3SDK;

public class StorageFactory {
    public static Storage create(String provider) {
        if ("local".equalsIgnoreCase(provider)) {
            return new LocalStorageAdapter(new LocalDiskSDK());
        } else if ("s3".equalsIgnoreCase(provider)) {
            // in real apps bucket/name come from config
            return new S3StorageAdapter(new S3SDK(), "my-app-bucket");
        } else {
            throw new IllegalArgumentException("Unknown provider: " + provider);
        }
    }
}
