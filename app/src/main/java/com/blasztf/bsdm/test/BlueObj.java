package com.blasztf.bsdm.test;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class BlueObj extends TestObj {

    protected BlueObj(TestLog logger) {
        super(logger);
    }

    @Override
    protected void start() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter.isDiscovering()) {
            adapter.cancelDiscovery();
        }

        for (BluetoothDevice device : adapter.getBondedDevices()) {
            getLogger().log(device.getName() + " => " + device.getAddress());
        }

    }
}
