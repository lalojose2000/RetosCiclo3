package com.example.retos.Controller;

import com.example.retos.Model.Cloud;
import com.example.retos.Service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Cloud")

public class CloudController {
    @Autowired
    private CloudService cloudService;

    @GetMapping("/all")
    public List<Cloud> getAll(){
        return cloudService.getAll();
    }
    @GetMapping("/{id}")     ///     localhost:8080/api/Category/21
    public Optional<Cloud> getCloud(@PathVariable("id") int id) { return cloudService.getCloud(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) { return cloudService.save(cloud); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update (@RequestBody Cloud cloud){
        return cloudService.update(cloud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cloudService.delete(id);
    }

}
