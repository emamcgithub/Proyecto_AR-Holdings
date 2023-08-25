package com.ar_holdings.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "Ar-Holdings-6ac8d.appspot.com";

    //Esta es la ruta básica de este proyecto Ar-Holdings
    final String rutaSuperiorStorage = "Ar-Holdings";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "Ar-Holdings-6ac8d-firebase-adminsdk-m0yru-db8cdaf2a1.json";

}
