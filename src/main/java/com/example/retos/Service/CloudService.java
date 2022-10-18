package com.example.retos.Service;

import com.example.retos.Model.Cloud;
import com.example.retos.Repository.CloudRepository;
import com.example.retos.Repository.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CloudService {
    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll(){
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud cloud){
        if (cloud.getId()==null){
            return cloudRepository.save(cloud);
        }else{
            Optional<Cloud> cloudEncontrado = getCloud(cloud.getId());
            if (cloudEncontrado.isEmpty()){
                return cloudRepository.save(cloud);
            }else{
                return cloud;
            }
        }

    }

    public Cloud update(Cloud cloud){
        if (cloud.getId()!=null){
            Optional<Cloud> cloudEncontrado = getCloud(cloud.getId());
            if (!cloudEncontrado.isEmpty()) {
                if (cloud.getName() != null) {
                    cloudEncontrado.get().setName(cloud.getName());
                }
                if (cloud.getBrand() != null) {
                    cloudEncontrado.get().setBrand(cloud.getBrand());
                }
                if (cloud.getCloud() != null) {
                    cloudEncontrado.get().setCloud(cloud.getCloud());
                }
                if (cloud.getDescription() != null) {
                    cloudEncontrado.get().setDescription(cloud.getDescription());
                }
                if (cloud.getCategory() != null) {
                    cloudEncontrado.get().setCategory(cloud.getCategory());
                }
                return cloudRepository.save(cloudEncontrado.get());

            }
        }
        return cloud;
    }

    public boolean delete(int id){
        Boolean respuesta = getCloud(id).map(elemento ->{
            cloudRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }

}
