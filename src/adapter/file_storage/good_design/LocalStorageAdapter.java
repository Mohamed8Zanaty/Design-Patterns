package adapter.file_storage.good_design;

import adapter.file_storage.providor.LocalDiskSDK;

public class LocalStorageAdapter implements Storage {
    private final LocalDiskSDK sdk;

    public LocalStorageAdapter(LocalDiskSDK sdk) {
        this.sdk = sdk;
    }

    @Override
    public String save(byte[] data, String filename) {
        return sdk.writeFile(data, filename);
    }

    @Override
    public boolean delete(String identifier) {
        return sdk.remove(identifier);
    }
}
