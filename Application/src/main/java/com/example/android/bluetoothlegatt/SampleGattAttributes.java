/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.bluetoothlegatt;

import java.util.HashMap;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */
public class SampleGattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";

    //SERVICIO Y CARACTERISTICAS A LA QUE SUSCRIBIMOS en BLEServices.java
    public static String USER_SERVICE_1="eed82c0a-b1c2-401e-ae4a-afac80c80c72";
    public static String USER_SERVICE_1_CHAR4 ="be39a5dc-048b-4b8f-84cb-94c197edd26e";
    public static String USER_SERVICE_1_CHAR6 ="a5853c93-08af-4186-8dba-b4c0cc74a23b";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    static {
        // Sample Services.GATT Specifications
        attributes.put("00001800-0000-1000-8000-00805f9b34fb", "Generic Access Profile");
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information");
        attributes.put("00001813-0000-1000-8000-00805f9b34fb", "SCAN Parameters");
        attributes.put("00001802-0000-1000-8000-00805f9b34fb", "Immediate Alert");
        attributes.put("00001803-0000-1000-8000-00805f9b34fb", "Link Loss");
        attributes.put(USER_SERVICE_1, "USER SERVICE 1 LIBELIUM");
        attributes.put("13744e03-9c88-4808-89a7-c2897e4e1b90", "USER SERVICE 2 LIBELIUM");
        // Sample Characteristics.
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        //El servicio Informacion del dispositivo tiene estas caracteristicas
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Nombre del fabricante");
        attributes.put("00002a24-0000-1000-8000-00805f9b34fb", "Modelo");
        attributes.put("00002a25-0000-1000-8000-00805f9b34fb", "Serial Number");//A ver si puedo meter aqui los datos
        attributes.put("00002a28-0000-1000-8000-00805f9b34fb", "SW Version");
        //UUID de la caracteristica 1.4 del USER SERVICE 1 Read/Write/Notify
        attributes.put(USER_SERVICE_1_CHAR4, "Temperatura");
        attributes.put(USER_SERVICE_1_CHAR6, "Humedad");
        //Su CLIENT CHARACTERISTIC CONFIGURATION es segun nRF Tools 0x2902
        //Que es la isma que la de heart rate measurement
        //quizas sea igual para todas las caracteristicas read/write/notify
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
